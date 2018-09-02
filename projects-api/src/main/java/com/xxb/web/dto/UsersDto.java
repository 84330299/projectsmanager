package com.xxb.web.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@ApiModel(value = "新增/注册 用户模型")
public class UsersDto implements Serializable{

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String img;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名",required = true)
    private String name;
    /**
     * 所属小组(部门)对应字典值
     */
    @ApiModelProperty(value = "所属小组(部门)对应字典值")
    private Integer group;
    /**
     * 职位(对应字典值)
     */
    @ApiModelProperty(value = "职位(对应字典值)")
    private Integer post;
    /**
     * 用户名(用于登录)
     */
    @ApiModelProperty(value = "用户名(用于登录)",required = true)
    @TableField("user_name")
    private String userName;
    /**
     * 用户登录密码
     */
    @ApiModelProperty(value = "用户登录密码",required = true)
    @TableField("user_password")
    private String userPassword;

    /**
     * 用户角色
     */
    @ApiModelProperty(value = "用户角色",required = true)
    private List<Integer> userRole;


    /**
     * 电话号码
     */
    @ApiParam(value = "电话号码",required = true)
    private String telephone;
    /**
     * qq邮箱
     */
    @ApiModelProperty(value = "qq邮箱",required = true)
    @TableField("qq_email")
    private String qqEmail;

    /**
     * 状态（0禁用，1未禁用）
     */
    @ApiModelProperty(value = "状态（0禁用，1未禁用）",required = true)
    private Integer status;

    /**
     * 抄送
     */
    @ApiModelProperty(value = "抄送")
    private String info;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Integer> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<Integer> userRole) {
        this.userRole = userRole;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
