package com.xxb.model.enums;

/**
 * @author 张玉
 * @Date 2018/7/26.
 */
public enum TelephoneType {

    IOS(0),Android(1);
    Integer code;

    TelephoneType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
