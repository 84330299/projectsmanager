package com.xxb.web.aop;

import com.xxb.exception.MyException;
import com.xxb.model.entity.Logs;
import com.xxb.model.service.ILogsService;
import com.xxb.utils.HttpContextUtil;
import com.xxb.utils.IPUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/10 13:32
 */
//@Aspect
//@Component
public class SysLogAop {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ILogsService iLogsService;

    @Pointcut("execution(* com.xxb.web.controller.*.*(..))")
    public void sysLogPointCut() {
    }

    @Around("sysLogPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        //方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //请求的方法名
        String methodName = signature.getName();
        //请求的参数
        String params = null;
        Object[] args = joinPoint.getArgs();
//        params = JSON.toJSONString(args);
        //获取request
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        //获取IP地址
        String ipAddr = IPUtil.getIpAddr(request);
        //开始时间
        long beginTime = System.currentTimeMillis();
        //打印结果拼接
        StringBuilder sb = new StringBuilder("\n******************************************************************************************************");
        sb.append("\n*  类名:" + className);
        sb.append("\n*  方法:" + methodName);
        sb.append("\n*  参数:" + params);
        sb.append("\n*  IP:" + ipAddr);

        Logs logs = new Logs(className, methodName, params, ipAddr);
        //执行时长(毫秒)
        long endTime = 0;
        //执行方法
        Object result = null;
        try {
            result = joinPoint.proceed();
            //执行时长(毫秒)
            endTime = System.currentTimeMillis() - beginTime;
            sb.append("\n*  耗时:" + endTime + "毫秒");
            sb.append("\n******************************************************************************************************");
            logger.info(sb.toString());
            logs.setConsumerTime(endTime);
            //日志插入数据库 (成功调用信息暂时不进数据库)
//            iLogsService.insert(logs);
            return result;
        } catch (Throwable throwable) {
            //可做数据库操作并可优化
            sb.append("\n*  耗时:" + endTime + "毫秒");
            sb.append("\n*  异常:" + throwable.getMessage());
            sb.append("\n******************************************************************************************************");
            logger.info(sb.toString());
            logs.setConsumerTime(endTime);
            logs.setExpInfo(throwable.getMessage());
            //日志插入数据库
            iLogsService.insert(logs);
            throw new MyException(throwable.getMessage());
        }
    }
}
