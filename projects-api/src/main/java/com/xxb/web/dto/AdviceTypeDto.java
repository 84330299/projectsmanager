package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 张玉
 * @Date 2018/7/11.
 */
public class AdviceTypeDto {
    @ApiModelProperty(value = "反馈类型id",example = "1")
    private Integer dictId;
    @ApiModelProperty(value = "反馈类型名字",example = "问题反馈")
    private String typeName;

    @Override
    public String toString() {
        return "AdviceTypeDto{" +
                "dictId=" + dictId +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
