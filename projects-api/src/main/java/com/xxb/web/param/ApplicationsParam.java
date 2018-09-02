package com.xxb.web.param;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;

/**
 * @author 张玉
 * @Date 2018/7/12.
 */
public class ApplicationsParam{

    @ApiModelProperty(value = "当前页",required = true)
    @ApiParam(defaultValue = "1")
    private Integer current;
    @ApiModelProperty(value = "每页显示条数",required = true)
    @ApiParam(defaultValue = "10")
    private Integer size;
    @ApiModelProperty(value = "应用ID")
    private Integer applicationId;
    @ApiModelProperty(value = "app名称",hidden = true)
    private String projectName;
    @ApiModelProperty(value = "通过项目名找到的Ids",hidden = true)
    private List<Integer> ids;
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 ,2:web)")
    private Integer systemType;
    @ApiModelProperty(value = "是否开启状态(0:启用,1:关闭)")
    private Integer status;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "创建人名字")
    private String userName;
    @ApiModelProperty(value = "搜索的key")
    private String key;
    @ApiModelProperty(value = "搜索类型(0:名称搜索,1:创建人搜索)")
    private Integer type;

    @Override
    public String toString() {
        return "ApplicationsParam{" +
                "current=" + current +
                ", size=" + size +
                ", applicationId=" + applicationId +
                ", projectName='" + projectName + '\'' +
                ", ids=" + ids +
                ", systemType=" + systemType +
                ", status=" + status +
                ", endTime=" + endTime +
                ", startTime=" + startTime +
                ", userName='" + userName + '\'' +
                ", key='" + key + '\'' +
                ", type=" + type +
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

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
