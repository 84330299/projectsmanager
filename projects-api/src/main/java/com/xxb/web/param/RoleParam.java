package com.xxb.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhenghe
 * @date 2018/7/5  17:21
 */
@ApiModel(value = "创建角色传入参数")
public class RoleParam implements Serializable{
    @ApiModelProperty(value = "角色id，创建不必填，修改必填",example = "2")
    private Integer id;
    @ApiModelProperty(value = "角色名字",required = true,example = "超级管理员")
    private String name;
    @ApiModelProperty(value = "父id，没有传0",required = true,example = "1")
    private Integer pid;
    @ApiModelProperty(value = "权限ids",example = "2,3,4")
    private String perms;
    @ApiModelProperty(value = "角色提示",example = "超级管理员可以管理所有用户")
    private String tips;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
