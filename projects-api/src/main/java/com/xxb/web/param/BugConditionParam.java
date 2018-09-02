package com.xxb.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("BUG查询的条件")
public class BugConditionParam extends BugPageParam implements Serializable {
    @ApiModelProperty(value = "APP名称(模糊)", example = "学")
    private String appName;
    @ApiModelProperty(value = "APP名称(点选)", example = "学训宝")
    private String applicationName;
    @ApiModelProperty(value = "创建人", example = "铁")
    private String createPerson;
    @ApiModelProperty(value = "指派人", example = "钢")
    private String appointPerson;
    @ApiModelProperty(value = "紧急性", example = "2")
    private Integer urgency;
    @ApiModelProperty(value = "系统类型", example = "ios")
    private String osType;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getAppointPerson() {
        return appointPerson;
    }

    public void setAppointPerson(String appointPerson) {
        this.appointPerson = appointPerson;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    @Override
    public String toString() {
        return "BugConditionParam{" +
                "appName='" + appName + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", createPerson='" + createPerson + '\'' +
                ", appointPerson='" + appointPerson + '\'' +
                ", urgency=" + urgency +
                ", osType='" + osType + '\'' +
                '}';
    }
}
