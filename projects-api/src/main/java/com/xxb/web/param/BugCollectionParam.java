package com.xxb.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 涂文宇
 * @date 2018/7/12 14:55
 */
@ApiModel("创建BUG的传入参数")

public class BugCollectionParam implements Serializable {
    @ApiModelProperty(value = "id", hidden = true)
    private Integer id;
    @ApiModelProperty(value = "所属产品,必填", example = "学训宝")
    private String appName;
    @ApiModelProperty(value = "运用版本,必填", example = "v4")
    private String appVersion;
    @ApiModelProperty(value = "系统类型,必填", example = "安卓")
    private String osType;
    @ApiModelProperty(value = "手机型号,必填", example = "oppo Find X")
    private String phoneModel;
    @ApiModelProperty(value = "指派人,必填", example = "2")
    private Integer appointPerson;
    @ApiModelProperty(value = "优先级(紧急性),必填", example = "1")
    private Integer urgency;
    @ApiModelProperty(value = "截止日期,必填")
    private Date deadline;
    @ApiModelProperty(value = "BUG描述,必填", example = "bug描述要求需要三十个字符,在路由层判断,如果符合就继续流程,如果长度少于三十个字符,返回错误信息")
    private String bugDescribe;
    @ApiModelProperty(value = "BUG详情", example = "http://www.xuexunbao.com.cn/xuexunbaojianjie/")
    private String bugInfo;
    @ApiModelProperty(value = "抄送给,部门主管们的id,逗号分隔", example = "1,2,3,4")
    private String forward;
    @ApiModelProperty(value = "创建人", hidden = true)
    private Integer createPerson;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public Integer getAppointPerson() {
        return appointPerson;
    }

    public void setAppointPerson(Integer appointPerson) {
        this.appointPerson = appointPerson;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
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

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }
}
