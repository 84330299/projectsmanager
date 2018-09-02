package com.xxb.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhenghe
 * @date 2018/7/11  10:15
 */
@ApiModel(value = "条件查询user列表")
public class UserListDto implements Serializable {

    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "头像地址")
    private String img;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "所属小组id")
    private Integer groupId;
    @ApiModelProperty(value = "所属小组")
    private String group;
    @ApiModelProperty(value = "职位id")
    private Integer postId;
    @ApiModelProperty(value = "职位")
    private String post;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "电话号码")
    private String telephone;
    @ApiModelProperty(value = "qq邮箱")
    private String qqEmail;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "登录时间")
    private Date loginTime;
    @ApiModelProperty(value = "状态 0禁用，1启用")
    private Integer status;
    @ApiModelProperty(value = "角色权限")
    private List<String> roleName;
    @ApiModelProperty(value = "角色权限id+name")
    private List<ItemDto> roleIdName;
    @ApiModelProperty(value = "登录次数")
    private Integer numLogin;

    public List<ItemDto> getRoleIdName() {
        return roleIdName;
    }

    public void setRoleIdName(List<ItemDto> roleIdName) {
        this.roleIdName = roleIdName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQqEmail() {
        return qqEmail;
    }

    public void setQqEmail(String qqEmail) {
        this.qqEmail = qqEmail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getRoleName() {
        return roleName;
    }

    public void setRoleName(List<String> roleName) {
        this.roleName = roleName;
    }

    public Integer getNumLogin() {
        return numLogin;
    }

    public void setNumLogin(Integer numLogin) {
        this.numLogin = numLogin;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
