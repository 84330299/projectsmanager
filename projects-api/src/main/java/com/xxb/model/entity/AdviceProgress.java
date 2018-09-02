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
@TableName("advice_progress")
public class AdviceProgress extends Model<AdviceProgress> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiParam(value = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 反馈id
     */
    @ApiParam(value = "反馈id")
    @TableField("advice_id")
    private Integer adviceId;
    /**
     * (1:已解决,2:暂缓)
     */
    @ApiParam(value = "(1:已解决,2:暂缓)")
    private Integer status;
    /**
     * 状态描述(暂缓和解决描述)
     */
    @ApiParam(value = "状态描述(暂缓和解决描述)")
    @TableField("status_description")
    private String statusDescription;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建者id
     */
    @ApiParam(value = "创建者id")
    @TableField("user_id")
    private Integer userId;
    /**
     * 删除状态(0:未删除 1:已删除)
     */
    @ApiParam(value = "删除状态(0:未删除 1:已删除)")
    @TableField("delete_flag")
    private Integer deleteFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AdviceProgress{" +
        ", id=" + id +
        ", adviceId=" + adviceId +
        ", status=" + status +
        ", statusDescription=" + statusDescription +
        ", createTime=" + createTime +
        ", userId=" + userId +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
