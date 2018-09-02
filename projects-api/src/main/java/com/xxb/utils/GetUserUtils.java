package com.xxb.utils;

import com.xxb.model.entity.Users;
import com.xxb.web.dto.LoginDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 张玉
 * @Date 2018/7/21.
 */
@Component
public class GetUserUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private static GetUserUtils getUserUtils;

    @PostConstruct
    public void init() {
        getUserUtils= this;
        getUserUtils.redisTemplate = this.redisTemplate;
    }

    public static Users getUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
//        String token = request.getParameter("token");
//        通过token,从缓存中获取用户信息
        LoginDto loginDto = (LoginDto) getUserUtils.redisTemplate.opsForValue().get(token);
        Users users=null;
        if(loginDto!=null){
            users = loginDto.getUsers();
        }
        return users;
    }
}
