package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 张玉
 * @Date 2018/7/16.
 */
public class MsgListDto implements Serializable{
    @ApiModelProperty(value = "姓名",example = "李楚良")
    private String userName;
    @ApiModelProperty(value = "角色",example = "超级管理员")
    private String roleName;
    @ApiModelProperty(value = "手机号码",example = "18772326551")
    private String telephone;
    @ApiModelProperty(value = "短信状态(1:成功,0:失败)",example = "0")
    private Integer sendStatus;
    @ApiModelProperty(value = "消息时间")
    private Date createTime;
    @ApiModelProperty(value = "发送消息",hidden = true)
    private String sendMsg;

    @Override
    public String toString() {
        return "MsgListDto{" +
                "userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sendStatus=" + sendStatus +
                ", createTime=" + createTime +
                ", sendMsg='" + sendMsg + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }
}
