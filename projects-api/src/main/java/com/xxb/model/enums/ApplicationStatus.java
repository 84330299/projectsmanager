package com.xxb.model.enums;

/**
 * @author 张玉
 * @Date 2018/7/17.
 */
public enum ApplicationStatus {

    启用(0),关闭(1);
    Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    ApplicationStatus(Integer code) {
        this.code = code;
    }
}
