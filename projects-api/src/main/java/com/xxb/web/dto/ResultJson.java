package com.xxb.web.dto;

import java.io.Serializable;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/4 10:07
 */
public class ResultJson<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private static volatile ResultJson instance = null;
    private String msg;
    private Integer code;
    private T t;

    public ResultJson() {
    }

//    public static ResultJson getInstance() {
//        if (instance == null) {
//            synchronized (ResultJson.class) {
//                if (instance == null) {
//                    instance = new ResultJson();
//                }
//            }
//        }
//        return instance;
//    }


    public String getMsg() {
        return msg;
    }

    public ResultJson setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ResultJson setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return t;
    }

    public ResultJson setData(T t) {
        this.t = t;
        return this;
    }
}
