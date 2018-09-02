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
 * <p>
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-09
 */
@TableName("msg_send")
public class MsgSend extends Model<MsgSend> {

    private static final long serialVersionUID = 1L;

    @ApiParam(value = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 手机号
     */
    @ApiParam(value = "手机号")
    private String phone;
    /**
     * 发送信息的模板id
     */
    @ApiParam(value = "发送信息的模板id")
    @TableField("msg_id")
    private Integer msgId;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 发送信息之后的描述
     */
    @ApiParam(value = "发送信息之后的描述")
    @TableField("send_msg")
    private String sendMsg;
    /**
     * 接收人id
     */
    @ApiParam(value = "接收人id")
    @TableField("user_id")
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MsgSend{" +
                ", id=" + id +
                ", phone=" + phone +
                ", msgId=" + msgId +
                ", createTime=" + createTime +
                ", sendMsg=" + sendMsg +
                ", userId=" + userId +
                "}";
    }
}
