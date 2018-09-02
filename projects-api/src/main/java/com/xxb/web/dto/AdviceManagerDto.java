package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 反馈管理查看数据
 * @Date 2018/7/10.
 */
public class AdviceManagerDto implements Serializable{

    @ApiModelProperty(value = "反馈id",example = "1")
    private Integer id;
    @ApiModelProperty(value = "项目名",example = "学训宝")
    private String projectName;
    @ApiModelProperty(value = "项目版本号",example = "v4.0")
    private String version;
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 ,2:web)",example = "0")
    private Integer systemType;
    @ApiModelProperty(value = "反馈描述",example = "鹤鹤中了大招")
    private String adviceDescription;
    @ApiModelProperty(value = "图片地址以逗号进行拼接",example="http://www.baidu.com,http://www.baidu.com")
    private String picUrl;
    @ApiModelProperty(value = "备注",example = "测试")
    private String remark;
    @ApiModelProperty(value = "反馈人姓名",example = "鹤鹤")
    private String userName;
    @ApiModelProperty(value = "反馈时间")
    private Date createTime;
    @ApiModelProperty(value = "解决时间")
    private Date resolveTime;
    @ApiModelProperty(value = "解决描述",example = "第一次解决")
    private String resolveDescription;
    @ApiModelProperty(value = "解决人",example = "张三")
    private String resolveName;
    @ApiModelProperty(value = "状态(0:未解决, 1:已解决, 2:暂缓)",example = "0")
    private Integer status;
    @ApiModelProperty(value = "反馈问题类型",example = "4")
    private String probleType;
    @ApiModelProperty(value = "反馈标题")
    private String title;

    @Override
    public String toString() {
        return "AdviceManagerDto{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", version='" + version + '\'' +
                ", systemType=" + systemType +
                ", adviceDescription='" + adviceDescription + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", remark='" + remark + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", resolveTime=" + resolveTime +
                ", resolveDescription='" + resolveDescription + '\'' +
                ", resolveName='" + resolveName + '\'' +
                ", status=" + status +
                ", probleType='" + probleType + '\'' +
                ", title='" + title + '\'' +
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

    public String getAdviceDescription() {
        return adviceDescription;
    }

    public void setAdviceDescription(String adviceDescription) {
        this.adviceDescription = adviceDescription;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(Date resolveTime) {
        this.resolveTime = resolveTime;
    }

    public String getResolveDescription() {
        return resolveDescription;
    }

    public void setResolveDescription(String resolveDescription) {
        this.resolveDescription = resolveDescription;
    }

    public String getResolveName() {
        return resolveName;
    }

    public void setResolveName(String resolveName) {
        this.resolveName = resolveName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProbleType() {
        return probleType;
    }

    public void setProbleType(String probleType) {
        this.probleType = probleType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
