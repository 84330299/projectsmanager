package com.xxb.web.dto;

import com.xxb.model.entity.Role;
import com.xxb.model.entity.Users;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhenghe
 * @date 2018/7/10  14:22
 */
@ApiModel(value = "用户登录传出参数")
public class LoginDto implements Serializable{
    @ApiModelProperty(value = "登录成功返回的密匙",readOnly = true)
    private String token;

    @ApiModelProperty(value = "登录成功后，当前登录的用户",readOnly = true)
    private Users users;

    @ApiModelProperty(value = "该用户的角色",readOnly = true)
    private List<Role> roles;

    @ApiModelProperty(value = "该用户的菜单权限",readOnly = true)
    private List<String> perms;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<String> getPerms() {
        return perms;
    }

    public void setPerms(List<String> perms) {
        this.perms = perms;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
