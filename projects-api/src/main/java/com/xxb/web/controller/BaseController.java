package com.xxb.web.controller;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.xxb.utils.PropertiesUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张玉
 * @Date 2018/7/11.
 */
@Api(tags = "基本功能")
@RestController
@RequestMapping("/base")
public class BaseController {

    private static final PropertiesUtil pu = new PropertiesUtil("/qiniu.properties");
    private static final Auth qiniu = Auth.create(pu.getProperty("AK"), pu.getProperty("SK"));
    private static final String bucket = pu.getProperty("bucket");
    private static final Integer expires = Integer.parseInt(pu.getProperty("expires"));
    private static final String path = pu.getProperty("url");

    /**
     * 获取七牛上传文件token
     */
    @GetMapping("/qiniu")
    @ApiOperation(value = "获取七牛上传文件token")
    public Map<String, String> qiniu() {
        StringMap policy = new StringMap();
        policy.put("returnBody", "{\"key\": $(key), \"hash\": $(etag), \"w\": $(imageInfo.width), \"h\": $(imageInfo.height)}");
        String token = qiniu.uploadToken(bucket, null, expires, policy);
        Map<String, String> res = new HashMap<>();
        res.put("uptoken", token);
        res.put("path", path);
        return res;
    }
}
