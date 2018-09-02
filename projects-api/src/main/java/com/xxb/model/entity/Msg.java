package com.xxb.model.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-09
 */
public class Msg extends Model<Msg> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 模板信息id
     */
    @ApiParam(value = "模板信息id")
    @TableField("template_id")
    private String templateId;
    /**
     * 消息类型（1.新增用户2.新增产品3.发应用）
     */
    @ApiParam(value = "消息类型（1.新增用户2.新增产品3.发应用）")
    private String type;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiParam(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;
    /**
     * 管理员id
     */
    @ApiParam(value = "管理员id")
    @TableField("user_id")
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        return "Msg{" +
        ", id=" + id +
        ", templateId=" + templateId +
        ", type=" + type +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", userId=" + userId +
        "}";
    }
}
