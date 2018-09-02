package com.xxb.model.enums;

/**
 * @author 张玉
 * @Date 2018/7/16.
 */
public enum MsgStatus {

    OK(1);
    Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    MsgStatus(Integer code) {
        this.code = code;
    }
}
