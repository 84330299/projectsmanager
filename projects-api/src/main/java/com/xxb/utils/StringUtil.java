package com.xxb.utils;

import java.util.UUID;

/**
 * @author zhenghe
 * @date 2018/7/18  16:03
 */
public class StringUtil {
    //生成uuid
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}
