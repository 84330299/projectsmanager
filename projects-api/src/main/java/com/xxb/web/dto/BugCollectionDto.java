package com.xxb.web.dto;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * BUG搜集页面列表展示参数
 * </p>
 *
 * @author 涂文宇
 * @since 2018-07-16
 */
public class BugCollectionDto {

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Integer id;
    /**
     * APP名称版本
     */
    @ApiModelProperty(value = "APP名称版本")
    @TableField("app_name")
    private String appName;
    /**
     * 紧急性 1~5 1:最紧急
     */
    @ApiModelProperty(value = "紧急性 1~5 1:最紧急")
    private Integer urgency;
    /**
     * 系统类型
     */
    @ApiModelProperty(value = "系统和类型")
    @TableField("os_type")
    private String osType;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @TableField("create_person")
    private String createPerson;
    /**
     * 指派人
     */
    @ApiModelProperty(value = "指派人")
    @TableField("appoint_person")
    private String appointPerson;
    /**
     * BUG描述
     */
    @ApiModelProperty(value = "BUG描述")
    @TableField("bug_describe")
    private String bugDescribe;
    /**
     * 截至时间
     */
    @ApiModelProperty(value = "截至时间")
    private Date deadline;
    /**
     * 手机型号
     */
    @ApiModelProperty(value = "手机型号")
    @TableField("phone_model")
    private String phoneModel;
    /**
     * 解决方案
     */
    @ApiModelProperty(value = "解决方案")
    private String solution;
    /**
     * 解决时间
     */
    @ApiModelProperty(value = "解决时间")
    @TableField("solve_time")
    private Date solveTime;
    /**
     * 当前状态 0:未解决 1:暂缓 2:已解决
     */
    @ApiModelProperty(value = "当前状态 0:未解决 1:暂缓 2:已解决")
    private Integer status;




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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getBugDescribe() {
        return bugDescribe;
    }

    public void setBugDescribe(String bugDescribe) {
        this.bugDescribe = bugDescribe;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Date getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(Date solveTime) {
        this.solveTime = solveTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "BugCollectionDto{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", urgency=" + urgency +
                ", osType='" + osType + '\'' +
                ", createTime=" + createTime +
                ", createPerson='" + createPerson + '\'' +
                ", appointPerson='" + appointPerson + '\'' +
                ", bugDescribe='" + bugDescribe + '\'' +
                ", deadline=" + deadline +
                ", phoneModel='" + phoneModel + '\'' +
                ", solution='" + solution + '\'' +
                ", solveTime=" + solveTime +
                ", status=" + status +
                '}';
    }
}
