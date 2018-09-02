package com.xxb.model.enums;

/**
 * @author 张玉
 * @Date 2018/7/10.
 */
public enum AdviceDescriptionEnum {

    未解决(0),已解决(1),暂缓(2);
    Integer code;

    AdviceDescriptionEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
