package com.xxb.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhenghe
 * @date 2018/7/5  15:09
 */
@ApiModel(value = "角色下拉列表")
public class RoleDownDto implements Serializable {
    @ApiModelProperty(value = "角色id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "角色名称", example = "管理员")
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
