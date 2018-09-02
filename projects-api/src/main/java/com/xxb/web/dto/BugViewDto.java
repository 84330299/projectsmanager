package com.xxb.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel("BUG查看参数")
public class BugViewDto {
    /**
     * APP名称
     */
    @ApiModelProperty(value = "APP名称")
    private String appName;
    /**
     * APP版本
     */
    @ApiModelProperty(value = "APP版本")
    private String appVersion;
    /**
     * 系统类型
     */
    @ApiModelProperty(value = "系统和类型")
    private String osType;
    /**
     * 紧急性 1~5 1:最紧急
     */
    @ApiModelProperty(value = "紧急性 1~5 1:最紧急")
    private Integer urgency;
    /**
     * 手机型号
     */
    @ApiModelProperty(value = "手机型号")
    private String phoneModel;
    /**
     * 指派人
     */
    @ApiModelProperty(value = "指派人")
    private String appointPerson;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createPerson;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 截至时间
     */
    @ApiModelProperty(value = "截至时间")
    private Date deadline;
    /**
     * BUG描述
     */
    @ApiModelProperty(value = "BUG描述")
    private String bugDescribe;
    /**
     * BUG详情
     */
    @ApiModelProperty(value = "BUG详情")
    private String bugInfo;
    /**
     * BUG流水
     */
    @ApiModelProperty(value = "BUG操作流水")
    private List<BugOperationDto> bugOperationDtos;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getAppointPerson() {
        return appointPerson;
    }

    public void setAppointPerson(String appointPerson) {
        this.appointPerson = appointPerson;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getBugDescribe() {
        return bugDescribe;
    }

    public void setBugDescribe(String bugDescribe) {
        this.bugDescribe = bugDescribe;
    }

    public String getBugInfo() {
        return bugInfo;
    }

    public void setBugInfo(String bugInfo) {
        this.bugInfo = bugInfo;
    }

    public List<BugOperationDto> getBugOperationDtos() {
        return bugOperationDtos;
    }

    public void setBugOperationDtos(List<BugOperationDto> bugOperationDtos) {
        this.bugOperationDtos = bugOperationDtos;
    }

    @Override
    public String toString() {
        return "BugViewDto{" +
                "appName='" + appName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", osType='" + osType + '\'' +
                ", urgency=" + urgency +
                ", phoneModel='" + phoneModel + '\'' +
                ", appointPerson='" + appointPerson + '\'' +
                ", createPerson='" + createPerson + '\'' +
                ", createTime=" + createTime +
                ", deadline=" + deadline +
                ", bugDescribe='" + bugDescribe + '\'' +
                ", bugInfo='" + bugInfo + '\'' +
                ", bugOperationDtos=" + bugOperationDtos +
                '}';
    }
}
