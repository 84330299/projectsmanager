package com.xxb.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("操作流水")
public class BugOperationDto {
    @ApiModelProperty(value = "发起者")
    private String assignId;
    @ApiModelProperty(value = "操作 0:创建 1:指派 2:暂缓 3:解决 4:删除 5:激活")
    private Integer operation;
    @ApiModelProperty(value = "解决方案/暂缓原因")
    private String txt;
    @ApiModelProperty(value = "操作时间")
    private Date date;

    public String getAssignId() {
        return assignId;
    }

    public void setAssignId(String assignId) {
        this.assignId = assignId;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BugOperationDto{" +
                "assignId='" + assignId + '\'' +
                ", operation=" + operation +
                ", txt='" + txt + '\'' +
                ", date=" + date +
                '}';
    }
}
