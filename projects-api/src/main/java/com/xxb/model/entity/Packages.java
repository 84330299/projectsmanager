package com.xxb.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 张玉
 * @Date 2018/7/17.
 */
public class Packages extends Model<Packages> {
    @ApiParam(value = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiParam(value = "下载链接地址")
    @TableField("download_url")
    private String downloadUrl;
    @ApiParam(value = "下载总量")
    @TableField("download_total")
    private Integer downloadTotal;
    @ApiParam(value = "应用id")
    @TableField("application_id")
    private Integer applicationId;
    @ApiParam(value = "包的删除状态(0:未删除,1:已删除)")
    @TableField("delete_flag")
    private Integer deleteFlag;
    @ApiParam(value = "包的开启状态(0:未开启,1:已开启)，只有开启才能下载")
    @TableField("status")
    private Integer status;
    @ApiParam(value = "版本大小(M)")
    @TableField("sizes")
    private String sizes;
    @ApiParam(value = "应用商店(与字典表中的id对应,使用逗号拼接)")
    @TableField("dict_ids")
    private String dict_ids;
    @ApiParam(value = "已下载量")
    @TableField("download_complete")
    private Integer downloadComplete;
    @ApiParam(value = "更新描述")
    @TableField("update_description")
    private String updateDescription;
    @ApiParam(value = "是否强制更新(0:不强制,1:强制更新)")
    @TableField("force_update")
    private Integer forceUpdate;
    @ApiParam(value = "抄送的角色id")
    private String roleId;
    @ApiParam(value = "开始时间")
    @TableField("start_time")
    private Date startTime;
    @ApiParam(value = "结束时间")
    @TableField("end_time")
    private Date endTime;
    @ApiParam(value = "创建人id")
    @TableField("user_id")
    private Integer userId;
    @ApiParam(value = "包的code")
    @TableField("code")
    private Integer code;
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    @ApiParam(value = "更新简介")
    @TableField("update_brief")
    private String updateBrief;

    @Override
    public String toString() {
        return "Packages{" +
                "id=" + id +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", downloadTotal=" + downloadTotal +
                ", applicationId=" + applicationId +
                ", deleteFlag=" + deleteFlag +
                ", status=" + status +
                ", sizes='" + sizes + '\'' +
                ", dict_ids='" + dict_ids + '\'' +
                ", downloadComplete=" + downloadComplete +
                ", updateDescription='" + updateDescription + '\'' +
                ", forceUpdate=" + forceUpdate +
                ", roleId='" + roleId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", userId=" + userId +
                ", code=" + code +
                ", createTime=" + createTime +
                ", updateBrief='" + updateBrief + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getDownloadTotal() {
        return downloadTotal;
    }

    public void setDownloadTotal(Integer downloadTotal) {
        this.downloadTotal = downloadTotal;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getDict_ids() {
        return dict_ids;
    }

    public void setDict_ids(String dict_ids) {
        this.dict_ids = dict_ids;
    }

    public Integer getDownloadComplete() {
        return downloadComplete;
    }

    public void setDownloadComplete(Integer downloadComplete) {
        this.downloadComplete = downloadComplete;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public Integer getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Integer forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBrief() {
        return updateBrief;
    }

    public void setUpdateBrief(String updateBrief) {
        this.updateBrief = updateBrief;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
