package com.xxb.web.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * <p>
 * 
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class ApplicationsDto {

    /**
     * 产品id(产品id与产品版本号是对应的)
     */
    @ApiModelProperty(value = "产品id(产品id与产品版本号是对应的)",required = true)
    private Integer projectId;
    /**
     * 系统类型(0:ios ,1:安卓 ,2:web)
     */
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 ,2:web)")
    private Integer systemType;
    /**
     * 下载地址
     */
    @ApiModelProperty(value = "下载地址")
    private String downloadUrl;
    /**
     * 下载总量
     */
    @ApiModelProperty(value = "下载总量")
    private Integer downloadTotal;
    /**
     * 有效下载开始时间
     */
    @ApiModelProperty(value = "有效下载开始时间")
    private Date startTime;
    /**
     * 有效下载结束时间
     */
    @ApiModelProperty(value = "有效下载结束时间")
    private Date endTime;
    /**
     * 应用商店(用逗号的形式进行拼接)
     */
    @ApiModelProperty(value = "应用商店(用逗号的形式进行拼接)")
    private String applicationStoreId;
    /**
     * 更新内容描述
     */
    @ApiModelProperty(value = "更新内容描述")
    private String updateDescription;
    /**
     * 抄送角色id(以逗号拼接)
     */
    @ApiModelProperty(value = "抄送角色id(以逗号拼接)")
    @TableField("role_id")
    private String roleId;
    /**
     * 发包人id
     */
    @ApiModelProperty(value = "发包人id",hidden = true)
    private Integer userId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 是否强制更新(0:不强制更新 1:强制更新)
     */
    @ApiModelProperty(value = "是否强制更新(0:不强制更新 1:强制更新)")
    private Integer constraintUpdate;
    /**
     * 版本大小(MB)
     */
    @ApiModelProperty(value = "版本大小(MB)")
    private String size;
    /**
     * 删除状态(0:未删除, 1:已删除)
     */
    @ApiModelProperty(value = "删除状态(0:未删除, 1:已删除)",hidden = true)
    @TableField("delete_flag")
    private Integer deleteFlag;

    @Override
    public String toString() {
        return "ApplicationsDto{" +
                "projectId=" + projectId +
                ", systemType=" + systemType +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", downloadTotal=" + downloadTotal +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", applicationStoreId='" + applicationStoreId + '\'' +
                ", updateDescription='" + updateDescription + '\'' +
                ", roleId=" + roleId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", constraintUpdate=" + constraintUpdate +
                ", size='" + size + '\'' +
                ", deleteFlag=" + deleteFlag +
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

    public String getApplicationStoreId() {
        return applicationStoreId;
    }

    public void setApplicationStoreId(String applicationStoreId) {
        this.applicationStoreId = applicationStoreId;
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

    public Integer getConstraintUpdate() {
        return constraintUpdate;
    }

    public void setConstraintUpdate(Integer constraintUpdate) {
        this.constraintUpdate = constraintUpdate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
