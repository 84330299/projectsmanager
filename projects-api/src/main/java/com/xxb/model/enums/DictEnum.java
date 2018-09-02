package com.xxb.model.enums;

/**
 * Created by Administrator on 2018/7/7.
 */
public enum DictEnum {
    应用商店(1),组别(2),职位(3),反馈类型(4);
    Integer code;

    DictEnum(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DictEnum{" +
                "code=" + code +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
