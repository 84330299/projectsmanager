package com.xxb.web.param;

import io.swagger.annotations.ApiModelProperty;

public class BugAppointParam {
    @ApiModelProperty(value = "BUG的id", example = "35")
    private Integer id;
    @ApiModelProperty(value = "被指派的人", example = "500")
    private Integer appointPerson;
    @ApiModelProperty(value = "指派备注", example = "让你做是组长对你的信任")
    private String appointRemark;
    @ApiModelProperty(value = "指派的发起人", hidden = true)
    private Integer assignId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppointPerson() {
        return appointPerson;
    }

    public void setAppointPerson(Integer appointPerson) {
        this.appointPerson = appointPerson;
    }

    public String getAppointRemark() {
        return appointRemark;
    }

    public void setAppointRemark(String appointRemark) {
        this.appointRemark = appointRemark;
    }

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }
}
