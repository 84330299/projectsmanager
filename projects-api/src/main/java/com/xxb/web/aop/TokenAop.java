package com.xxb.web.aop;

import com.xxb.web.dto.LoginDto;
import com.xxb.web.dto.ResultJson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/9 11:35
 */
@Aspect
@Component
public class TokenAop {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(com.xxb.annotation.Token)")
    public void tokenPointCut() {
    }

    @Around("tokenPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String token = request.getHeader("Token");
        //通过token,从缓存中获取用户信息
        LoginDto loginDto = (LoginDto) redisTemplate.opsForValue().get(token);
        if (loginDto == null) {
            return resultJson.setCode(600).setMsg("登录失效，请重新登录");
        } else {
            return joinPoint.proceed();
        }
//        Claims claims = JwtUtil.parseJWT(token);
//        try {
//            if (claims != null) {
//                return joinPoint.proceed();
//            } else {
//                return resultJson.setCode(401).setData(null);
//            }
//        } catch (Throwable throwable) {
//            throw new MyException(throwable.getMessage());
//        }
    }


}
