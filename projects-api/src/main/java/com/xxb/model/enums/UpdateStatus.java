package com.xxb.model.enums;

/**
 * @author 张玉
 * @Date 2018/7/20.
 */
public enum UpdateStatus {
    不强制更新(0),强制更新(1),不更新(2);
    Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    UpdateStatus(Integer code) {
        this.code = code;
    }
}
