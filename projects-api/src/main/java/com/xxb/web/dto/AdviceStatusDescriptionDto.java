package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author 张玉
 * @Date 2018/7/10.
 */
public class AdviceStatusDescriptionDto {

    @ApiModelProperty(value = "id",example = "1")
    private Integer id;
    @ApiModelProperty(value = "项目名",example = "学训宝")
    private String projectName;

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    @ApiModelProperty(value = "版本号",example = "v4.0")
    private String version;
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 ,2:web)",example="0")
    private Integer systemType;
    @ApiModelProperty(value = "创建人",example = "张三")
    private String userName;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "备注",example = "鹤鹤今天开荤了")
    private String remark;
    @ApiModelProperty(value = "标题",example = "鹤鹤大标题")
    private String title;

    @Override
    public String toString() {
        return "AdviceStatusDescriptionDto{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", version='" + version + '\'' +
                ", systemType='" + systemType + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                ", title='" + title + '\'' +
                ", adviceDescription='" + adviceDescription + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", status=" + status +
                ", statusDescription=" + statusDescription +
                ", resolveUserName='" + resolveUserName + '\'' +
                ", dictId=" + dictId +
                '}';
    }

    @ApiModelProperty(value = "反馈详情描述",example = "有个Bug")
    private String adviceDescription;
    @ApiModelProperty(value = "截图url(以逗号拼接)",example="http://www.baidu.com,http://www.baidu.com")
    private String picUrl;
    @ApiModelProperty(value = "反馈状态(0:未解决, 1:已解决, 2:暂缓)",example = "0")
    private Integer status;
    @ApiModelProperty(value = "状态描述(未解决，已解决，暂缓的描述",example = "未解决")
    private List<String> statusDescription;;
    @ApiModelProperty(value = "解决人名字",example = "张三")
    private String resolveUserName;
    @ApiModelProperty(value = "反馈类型(与字典表中的Id对应)",example = "1")
    private Integer dictId;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(List<String> statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getResolveUserName() {
        return resolveUserName;
    }

    public void setResolveUserName(String resolveUserName) {
        this.resolveUserName = resolveUserName;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }
}
