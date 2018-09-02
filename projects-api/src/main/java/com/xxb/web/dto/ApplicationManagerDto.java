package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;

/**
 * 应用管理查看返回实体类
 * @author 张玉
 * @Date 2018/7/9.
 */
public class ApplicationManagerDto {
    @ApiParam(value = "应用id")
    private Integer id;
    @ApiParam(value = "项目名")
    private String projectName;
    @ApiParam(value = "更新内容描述")
    private String updateDescription;
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 ,2:web)")
    private Integer systemType;
    @ApiModelProperty(value = "发包人名字")
    private String userName;
    @ApiModelProperty(value = "发包人时间")
    private Date createTime;
    @ApiModelProperty(value = "下载地址")
    private String downloadUrl;
    @ApiModelProperty(value = "应用商店")
    private List<String> appNames;
    @ApiModelProperty(value = "下载总量")
    private Integer downloadTotal;
    @ApiModelProperty(value = "已下载量")
    private Integer completeNum;
    @ApiModelProperty(value = "是否强制更新(0:不强制更新 1:强制更新)")
    private Integer constraintUpdate;
    @ApiModelProperty(value = "有效下载开始时间")
    private Date startTime;
    @ApiModelProperty(value = "有效下载结束时间")
    private Date endTime;
    @ApiModelProperty(value = "版本大小(MB)")
    private String size;
    @ApiParam(value = "关闭状态(0:关闭, 1:启用)")
    private Integer status;
    @ApiParam(value = "版本号")
    private String version;
    @ApiParam(value = "拼接的app商店id")
    private String dictId;
    @ApiParam(value = "更新简介")
    private String updateBrief;

    @Override
    public String toString() {
        return "ApplicationManagerDto{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", updateDescription='" + updateDescription + '\'' +
                ", systemType=" + systemType +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", appNames=" + appNames +
                ", downloadTotal=" + downloadTotal +
                ", completeNum=" + completeNum +
                ", constraintUpdate=" + constraintUpdate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", size='" + size + '\'' +
                ", status=" + status +
                ", version='" + version + '\'' +
                ", dictId='" + dictId + '\'' +
                ", updateBrief='" + updateBrief + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public List<String> getAppNames() {
        return appNames;
    }

    public void setAppNames(List<String> appNames) {
        this.appNames = appNames;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getUpdateBrief() {
        return updateBrief;
    }

    public void setUpdateBrief(String updateBrief) {
        this.updateBrief = updateBrief;
    }
}
