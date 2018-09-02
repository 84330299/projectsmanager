package com.xxb.model.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

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
@TableName("login_log")
public class LoginLog extends Model<LoginLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiParam(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 登录操作（0登录，1登出）
     */
    @ApiParam(value = "登录操作（0登录，1登出）")
    @TableField("log_name")
    private Integer logName;
    /**
     * 管理员id
     */
    @ApiParam(value = "管理员id")
    @TableField("user_id")
    private Integer userId;
    @TableField("create_time")
    private Date createTime;
    /**
     * 成功标志（0不成功，1成功）
     */
    @ApiParam(value = "成功标志（0不成功，1成功）")
    @TableField("success_flag")
    private Integer successFlag;
    /**
     * ip地址
     */
    @ApiParam(value = "ip地址")
    private String ip;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogName() {
        return logName;
    }

    public void setLogName(Integer logName) {
        this.logName = logName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(Integer successFlag) {
        this.successFlag = successFlag;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
        ", id=" + id +
        ", logName=" + logName +
        ", userId=" + userId +
        ", createTime=" + createTime +
        ", successFlag=" + successFlag +
        ", ip=" + ip +
        "}";
    }
}
