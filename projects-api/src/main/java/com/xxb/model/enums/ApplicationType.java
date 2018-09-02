package com.xxb.model.enums;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/19 19:14
 */
public enum ApplicationType {
    App名称(0),创建人(1);
    Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    ApplicationType(Integer code) {
        this.code = code;
    }
}
