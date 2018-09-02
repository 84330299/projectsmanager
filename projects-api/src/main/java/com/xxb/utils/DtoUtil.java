package com.xxb.utils;

import org.springframework.beans.BeanUtils;

/**
 * @Author: 陈亮
 * @Date: 2018/7/4 22:18
 */
public class DtoUtil {
    public static <T> T convertObject(Object sourceObj, Class<T> targetClz) {
        if (sourceObj == null) {
            return null;
        }

        if (targetClz == null) {
            throw new IllegalArgumentException("parameter clz shoud not be null");
        }
        try {
            Object targetObj = targetClz.newInstance();
            BeanUtils.copyProperties(sourceObj, targetObj);
            return (T) targetObj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
