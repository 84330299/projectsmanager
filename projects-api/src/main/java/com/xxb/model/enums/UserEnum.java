package com.xxb.model.enums;

/**
 * Created by Administrator on 2018/7/6.
 */
public enum UserEnum {
    删除(0),未删除(1);
    Integer code;

    UserEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserEnum{" +
                "code=" + code +
                '}';
    }
}
