package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 反馈多条件筛选查询
 *
 * @Date 2018/7/11.
 */
public class ConditionAdvice {
    @ApiModelProperty(value = "当前页",required = true)
    private Integer current;
    @ApiModelProperty(value = "每页显示长度",required = true)
    private Integer size;
    @ApiModelProperty(value = "用户输入的内容",hidden = true)
    private String inputInfo;
    @ApiModelProperty(value = "App名称")
    private String projectName;
    @ApiModelProperty(value = "根据App名称查找到的项目id集合",hidden = true)
    private List<Integer> ids;
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 ,2:web)")
    private Integer systemType;
    @ApiModelProperty(value = "反馈类型")
    private Integer adviceType;
    @ApiModelProperty(value = "筛选的开始时间")
    private Date startTime;
    @ApiModelProperty(value = "筛选的结束时间")
    private Date endTime;
    @ApiModelProperty(value = "反馈状态(0:未解决, 1:已解决, 2:暂缓)")
    private Integer adviceStatus;

    @Override
    public String toString() {
        return "ConditionAdvice{" +
                "current=" + current +
                ", size=" + size +
                ", inputInfo='" + inputInfo + '\'' +
                ", projectName='" + projectName + '\'' +
                ", ids=" + ids +
                ", systemType=" + systemType +
                ", adviceType=" + adviceType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", adviceStatus=" + adviceStatus +
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
    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
    public String getInputInfo() {
        return inputInfo;
    }

    public void setInputInfo(String inputInfo) {
        this.inputInfo = inputInfo;
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

    public Integer getAdviceType() {
        return adviceType;
    }

    public void setAdviceType(Integer adviceType) {
        this.adviceType = adviceType;
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

    public Integer getAdviceStatus() {
        return adviceStatus;
    }

    public void setAdviceStatus(Integer adviceStatus) {
        this.adviceStatus = adviceStatus;
    }
}
