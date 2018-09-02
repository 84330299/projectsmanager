package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2018/7/6.
 */
public class UserFuzzyDto {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * name
     */
    @ApiModelProperty(value = "用户名")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
