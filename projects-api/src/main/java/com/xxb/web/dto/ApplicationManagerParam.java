package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;

/**
 * @author 张玉
 * @Date 2018/7/12.
 */
public class ApplicationManagerParam {
    @ApiModelProperty(value = "当前页",required = true)
    private Integer current;
    @ApiModelProperty(value = "每页条数",required = true)
    private Integer size;
    @ApiModelProperty(value = "项目名")
    private String projectName;
    @ApiModelProperty(value = "系统类型")
    private Integer systemType;
    @ApiModelProperty(value = "开启状态")
    private Integer status;
    @ApiModelProperty(value = "通过项目名找到项目Id集合")
    private List<Integer> ids;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @Override
    public String toString() {
        return "ApplicationManagerParam{" +
                "current=" + current +
                ", size=" + size +
                ", projectName='" + projectName + '\'' +
                ", systemType=" + systemType +
                ", status=" + status +
                ", ids=" + ids +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
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
}
