package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目管理查看
 * @Date 2018/7/12.
 */
public class ProjectManagerDto implements Serializable{

    @ApiModelProperty(value = "应用id")
    private Integer id;
    @ApiModelProperty(value = "App名")
    private String projectName;
    @ApiModelProperty(value = "版本")
    private String version;
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 ,2:web)")
    private Integer systemType;
    @ApiModelProperty(value = "反馈总数")
    private Integer adviceCount;
    @ApiModelProperty(value = "反馈未解决数")
    private Integer adviceUnsolveNum;
    @ApiModelProperty(value = "反馈解决数")
    private Integer adviceSolveNum;
    @ApiModelProperty(value = "反馈暂缓数")
    private Integer adviceDeferNum;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "状态(0:关闭 ,1:开启)")
    private Integer status;
    @ApiModelProperty(value = "应用创建人")
    private String userName;

    @Override
    public String toString() {
        return "ProjectManagerDto{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", version='" + version + '\'' +
                ", systemType=" + systemType +
                ", adviceCount=" + adviceCount +
                ", adviceUnsolveNum=" + adviceUnsolveNum +
                ", adviceSolveNum=" + adviceSolveNum +
                ", adviceDeferNum=" + adviceDeferNum +
                ", createTime=" + createTime +
                ", status=" + status +
                ", userName='" + userName + '\'' +
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

    public Integer getAdviceCount() {
        return adviceCount;
    }

    public void setAdviceCount(Integer adviceCount) {
        this.adviceCount = adviceCount;
    }

    public Integer getAdviceUnsolveNum() {
        return adviceUnsolveNum;
    }

    public void setAdviceUnsolveNum(Integer adviceUnsolveNum) {
        this.adviceUnsolveNum = adviceUnsolveNum;
    }

    public Integer getAdviceSolveNum() {
        return adviceSolveNum;
    }

    public void setAdviceSolveNum(Integer adviceSolveNum) {
        this.adviceSolveNum = adviceSolveNum;
    }

    public Integer getAdviceDeferNum() {
        return adviceDeferNum;
    }

    public void setAdviceDeferNum(Integer adviceDeferNum) {
        this.adviceDeferNum = adviceDeferNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
