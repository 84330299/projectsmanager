package com.xxb.web.dto;

import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 张玉
 * @Date 2018/7/9.
 */
public class ApplicationDetailDto implements Serializable{

    @ApiParam(value = "应用Id")
    private Integer id;
    @ApiParam(value = "项目名字")
    private String productName;
    @ApiParam(value = "版本")
    private String version;
    @ApiParam(value = "系统类型")
    private Integer systemType;
    @ApiParam(value = "应用商店")
    private List<String> apps;
    @ApiParam(value = "下载地址")
    private String downloadUrl;
    @ApiParam(value = "下载总量")
    private Integer downloadTotal;
    @ApiParam(value = "已下载量")
    private Integer completeNum;

    /**
     * 是否强制更新(0:不强制更新 1:强制更新)
     */
    @ApiParam(value = "是否强制更新(0:不强制更新 1:强制更新,2:不更新)")
    private Integer constraintUpdate;

    /**
     * 版本大小(MB)
     */
    @ApiParam(value = "版本大小(MB)")
    private String size;
    /**
     * 发包人名字
     */
    @ApiParam(value = "发包人名字")
    private String userName;

    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    private Date createTime;

    /**
     * 创建时间
     */
    @ApiParam(value = "开始时间")
    private Date startTime;

    /**
     * 创建时间
     */
    @ApiParam(value = "结束时间")
    private Date endTime;

    @ApiParam(value = "更新内容描述")
    private String updateDescription;

    @ApiParam(value = "更新简介")
    private String updateBrief;

    @Override
    public String toString() {
        return "ApplicationDetailDto{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", version='" + version + '\'' +
                ", systemType=" + systemType +
                ", apps=" + apps +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", downloadTotal=" + downloadTotal +
                ", completeNum=" + completeNum +
                ", constraintUpdate=" + constraintUpdate +
                ", size='" + size + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", updateDescription='" + updateDescription + '\'' +
                ", updateBrief='" + updateBrief + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    public List<String> getApps() {
        return apps;
    }

    public void setApps(List<String> apps) {
        this.apps = apps;
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

    public Integer getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(Integer completeNum) {
        this.completeNum = completeNum;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public String getUpdateBrief() {
        return updateBrief;
    }

    public void setUpdateBrief(String updateBrief) {
        this.updateBrief = updateBrief;
    }
}
