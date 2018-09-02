package com.xxb.web.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date 2018/7/17.
 */
public class CreateApplicationParam implements Serializable {

    @ApiModelProperty(value = "项目id",required = true)
    private Integer projectId;
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 ,2:web)",required = true)
    private Integer systemType;
    @ApiModelProperty(value = "下载地址")
    private String downloadUrl;
    @ApiModelProperty(value = "下载总量")
    private Integer downloadTotal;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    @ApiModelProperty(value = "应用商店id(以逗号拼接)")
    private String appStoreIds;
    @ApiModelProperty(value = "更新描述")
    private String updateDescription;
    @ApiModelProperty(value = "抄送给的角色id,以逗号拼接")
    private String roleId;
    @ApiModelProperty(value = "应用id",hidden = true)
    private Integer applicationId;
    @ApiModelProperty(value = "版本大小")
    private String sizes;
    @ApiModelProperty(value = "是否强制更新(0:不强制,1:强制更新,2:不更新)")
    private Integer forceUpdate;
    @ApiModelProperty(value = "创建人用户id",hidden = true)
    private Integer userId;
    @ApiModelProperty(value = "包的code码")
    private Integer code;
    @ApiModelProperty(value = "更新简介")
    private String updateBrief;

    @Override
    public String toString() {
        return "CreateApplicationParam{" +
                "projectId=" + projectId +
                ", systemType=" + systemType +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", downloadTotal=" + downloadTotal +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", appStoreIds='" + appStoreIds + '\'' +
                ", updateDescription='" + updateDescription + '\'' +
                ", roleId='" + roleId + '\'' +
                ", applicationId=" + applicationId +
                ", sizes='" + sizes + '\'' +
                ", forceUpdate=" + forceUpdate +
                ", userId=" + userId +
                ", code=" + code +
                ", updateBrief='" + updateBrief + '\'' +
                '}';
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
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

    public String getAppStoreIds() {
        return appStoreIds;
    }

    public void setAppStoreIds(String appStoreIds) {
        this.appStoreIds = appStoreIds;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public Integer getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Integer forceUpdate) {
        this.forceUpdate = forceUpdate;
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

    public String getUpdateBrief() {
        return updateBrief;
    }

    public void setUpdateBrief(String updateBrief) {
        this.updateBrief = updateBrief;
    }
}
