package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 应用商店
 * Created by Administrator on 2018/7/7.
 */
public class AppStoresDto {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;
    /**
     * 商店名称
     */
    @ApiModelProperty(value = "商店名称")
    private String name;

    @Override
    public String toString() {
        return "AppStoresDto{" +
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
