package com.xxb.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * BUG搜集
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-18
 */
@TableName("bug_collection")
public class BugCollection extends Model<BugCollection> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiParam(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * APP名称
     */
    @ApiParam(value = "APP名称")
    @TableField("app_name")
    private String appName;
    /**
     * APP版本
     */
    @ApiParam(value = "APP版本")
    @TableField("app_version")
    private String appVersion;
    /**
     * 紧急性 1~5 1:最紧急
     */
    @ApiParam(value = "紧急性 1~5 1:最紧急")
    private Integer urgency;
    /**
     * 系统类型
     */
    @ApiParam(value = "系统类型")
    @TableField("os_type")
    private String osType;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @ApiParam(value = "创建人")
    @TableField("create_person")
    private Integer createPerson;
    /**
     * 指派人
     */
    @ApiParam(value = "指派人")
    @TableField("appoint_person")
    private Integer appointPerson;
    /**
     * BUG描述
     */
    @ApiParam(value = "BUG描述")
    @TableField("bug_describe")
    private String bugDescribe;
    /**
     * BUG详情
     */
    @ApiParam(value = "BUG详情")
    @TableField("bug_info")
    private String bugInfo;
    /**
     * 截止时间
     */
    @ApiParam(value = "截止时间")
    private Date deadline;
    /**
     * 手机型号
     */
    @ApiParam(value = "手机型号")
    @TableField("phone_model")
    private String phoneModel;
    /**
     * 解决方案
     */
    @ApiParam(value = "解决方案")
    private String solution;
    /**
     * 解决时间
     */
    @ApiParam(value = "解决时间")
    @TableField("solve_time")
    private Date solveTime;
    /**
     * 当前状态 0:未解决 1:已暂缓 2:已解决
     */
    @ApiParam(value = "当前状态 0:未解决 1:已暂缓 2:已解决")
    private Integer status;
    /**
     * 解决人
     */
    @ApiParam(value = "解决人")
    @TableField("solve_person")
    private Integer solvePerson;
    /**
     * 激活状态 0:未激活过 1:激活过
     */
    @ApiParam(value = "激活状态 0:未激活过 1:激活过")
    @TableField("active_flag")
    private Integer activeFlag;


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

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
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

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Integer getAppointPerson() {
        return appointPerson;
    }

    public void setAppointPerson(Integer appointPerson) {
        this.appointPerson = appointPerson;
    }

    public String getBugDescribe() {
        return bugDescribe;
    }

    public void setBugDescribe(String bugDescribe) {
        this.bugDescribe = bugDescribe;
    }

    public String getBugInfo() {
        return bugInfo;
    }

    public void setBugInfo(String bugInfo) {
        this.bugInfo = bugInfo;
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

    public Integer getSolvePerson() {
        return solvePerson;
    }

    public void setSolvePerson(Integer solvePerson) {
        this.solvePerson = solvePerson;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BugCollection{" +
        ", id=" + id +
        ", appName=" + appName +
        ", appVersion=" + appVersion +
        ", urgency=" + urgency +
        ", osType=" + osType +
        ", createTime=" + createTime +
        ", createPerson=" + createPerson +
        ", appointPerson=" + appointPerson +
        ", bugDescribe=" + bugDescribe +
        ", bugInfo=" + bugInfo +
        ", deadline=" + deadline +
        ", phoneModel=" + phoneModel +
        ", solution=" + solution +
        ", solveTime=" + solveTime +
        ", status=" + status +
        ", solvePerson=" + solvePerson +
        ", activeFlag=" + activeFlag +
        "}";
    }
}
