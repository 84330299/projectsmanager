package com.xxb.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;

/**
 * @author zhenghe
 * @date 2018/7/12  9:36
 */
@ApiModel(value = "角色列表条件分页查询")
public class RoleListParam implements Serializable{
    @ApiModelProperty(value = "当前页",required = true)
    private Integer page;
    @ApiModelProperty(value = "每页条数",required = true)
    private Integer size;
    @ApiModelProperty(value = "角色名",required = false)
    private String name;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
