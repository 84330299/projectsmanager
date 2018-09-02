package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2018/7/6.
 */
public class ProductVersion {

    /**
     * id
     */
    @ApiModelProperty(value="id")
    private Integer id;
    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private String name;

    @Override
    public String toString() {
        return "ProductVersion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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

