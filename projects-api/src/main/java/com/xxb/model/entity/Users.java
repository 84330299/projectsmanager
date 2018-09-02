package com.xxb.model.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiParam(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 头像地址
     */
    @ApiParam(value = "头像地址")
    private String img;

    /**
     * 姓名
     */
    @ApiParam(value = "姓名")
    private String name;
    /**
     * 所属小组(部门)对应字典值
     */
    @ApiParam(value = "所属小组(部门)对应字典值")
    private Integer group;
    /**
     * 职位(对应字典值)
     */
    @ApiParam(value = "职位(对应字典值)")
    private Integer post;
    /**
     * 用户名(用于登录)
     */
    @ApiParam(value = "用户名(用于登录)")
    @TableField("user_name")
    private String userName;
    /**
     * 用户登录密码
     */
    @ApiParam(value = "用户登录密码")
    @TableField("user_password")
    private String userPassword;
    /**
     * 密码盐（4位）
     */
    @ApiParam(value = "密码盐（4位）")
    private String salt;
    /**
     * 电话号码
     */
    @ApiParam(value = "电话号码")
    private String telephone;
    @TableField("qq_email")
    private String qqEmail;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    @TableField("login_time")
    private Date loginTime;
    /**
     * 状态（0禁用，1未禁用）
     */
    @ApiParam(value = "状态（0禁用，1未禁用）")
    private Integer status;
    /**
     * 删除标志（0删除，1未删除）
     */
    @ApiParam(value = "删除标志（0删除，1未删除）")
    @TableField("delete_flag")
    private Integer deleteFlag;


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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Users{" +
        "id=" + id + ", img=" + img +
        ", name=" + name +
        ", group=" + group +
        ", post=" + post +
        ", userName=" + userName +
        ", userPassword=" + userPassword +
        ", salt=" + salt +
        ", telephone=" + telephone +
        ", qqEmail=" + qqEmail +
        ", createTime=" + createTime +
        ", loginTime=" + loginTime +
        ", status=" + status +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
