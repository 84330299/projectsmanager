package com.xxb.web.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class AdviceProgressDto {

    /**
     * 反馈id
     */
    @ApiModelProperty(value = "反馈id",example = "1")
    private Integer adviceId;
    /**
     * (1:已解决,2:暂缓)
     */
    @ApiModelProperty(value = "(1:已解决,2:暂缓)",example = "1")
    private Integer status;
    /**
     * 状态描述(暂缓和解决描述)
     */
    @ApiModelProperty(value = "状态描述(暂缓和解决描述)",example = "这个问题没有解决，暂缓")
    @TableField("status_description")
    private String statusDescription;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",hidden = true)
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id",hidden = true)
    @TableField("user_id")
    private Integer userId;
    /**
     * 删除状态(0:未删除 1:已删除)
     */
    @ApiModelProperty(value = "删除状态(0:未删除 1:已删除)",hidden = true)
    @TableField("delete_flag")
    private Integer deleteFlag;

    @Override
    public String toString() {
        return "AdviceProgressDto{" +
                "adviceId=" + adviceId +
                ", status=" + status +
                ", statusDescription='" + statusDescription + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", deleteFlag=" + deleteFlag +
                '}';
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
}
