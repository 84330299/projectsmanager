package com.xxb.web.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 消息筛选列表入参
 * @author 张玉
 * @Date 2018/7/16.
 */
public class MsgListParam implements Serializable{
    @ApiModelProperty(value = "当前页",example ="1",required = true)
    private Integer current;
    @ApiModelProperty(value = "每页显示条数",example = "10",required = true)
    private Integer size;
    @ApiModelProperty(value = "发送状态 失败(0),成功(1)",example = "1")
    private Integer code;
    @ApiModelProperty(value = "发送短信后返回的信息",hidden = true)
    private String sendMsg;
    @ApiModelProperty(value = "开始时间",hidden = true)
    private Date startTime;
    @ApiModelProperty(value = "结束时间",hidden = true)
    private Date endTime;
    @ApiModelProperty(value = "角色id")
    private Integer roleId;
    @ApiModelProperty(value = "用户名查询")
    private String userName;
    @ApiModelProperty(value = "通过角色查询出来的用户id",hidden = true)
    private List<Integer> uids;
    @ApiModelProperty(value = "手机号")
    private String telephone;

    @Override
    public String toString() {
        return "MsgListParam{" +
                "current=" + current +
                ", size=" + size +
                ", code=" + code +
                ", sendMsg='" + sendMsg + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", roleId=" + roleId +
                ", userName='" + userName + '\'' +
                ", uids=" + uids +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getUids() {
        return uids;
    }

    public void setUids(List<Integer> uids) {
        this.uids = uids;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
