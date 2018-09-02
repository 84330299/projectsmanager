package com.xxb.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class Applications extends Model<Applications> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiParam(value = "id")

    @TableId(type = IdType.AUTO)
    private Integer id;

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    /**
     * 产品id(产品id与产品版本号是对应的)
     */

    @ApiParam(value = "产品id(产品id与产品版本号是对应的)")
    @TableField("project_id")
    private Integer projectId;

    /**
     * 系统类型(0:ios ,1:安卓 ,2:web)
     */
    @ApiParam(value = "系统类型(0:ios ,1:安卓 ,2:web)")
    @TableField("system_type")
    private Integer systemType;
    /**
     * 下载地址
     */
    @ApiParam(value = "下载地址")
    @TableField("download_url")
    private String downloadUrl;
    /**
     * 下载总量
     */
    @ApiParam(value = "下载总量")
    @TableField("download_total")
    private Integer downloadTotal;

    /**
     * 已下载量
     */
    @ApiParam(value = "已下载量")
    @TableField("complete_num")
    private Integer completeNum;

    public Integer getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(Integer completeNum) {
        this.completeNum = completeNum;
    }

    /**
     * 有效下载开始时间
     */
    @ApiParam(value = "有效下载开始时间")
    @TableField("start_time")
    private Date startTime;
    /**
     * 有效下载结束时间
     */
    @ApiParam(value = "有效下载结束时间")
    @TableField("end_time")
    private Date endTime;
    /**
     * 应用商店(用逗号的形式进行拼接)
     */
    @ApiParam(value = "应用商店(用逗号的形式进行拼接)")
    @TableField("application_store_id")
    private String applicationStoreId;
    /**
     * 更新内容描述
     */
    @ApiParam(value = "更新内容描述")
    @TableField("update_description")
    private String updateDescription;
    /**
     * 抄送角色id(以逗号拼接)
     */
    @ApiParam(value = "抄送角色id(以逗号拼接)")
    @TableField("role_id")
    private String roleId;
    @ApiParam(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;
    /**
     * 发包人id
     */
    @ApiParam(value = "发包人id")
    @TableField("user_id")
    private Integer userId;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 是否强制更新(0:不强制更新 1:强制更新)
     */
    @ApiParam(value = "是否强制更新(0:不强制更新 1:强制更新)")
    @TableField("constraint_update")
    private Integer constraintUpdate;
    /**
     * 版本大小(MB)
     */
    @ApiParam(value = "版本大小(MB)")
    private String size;
    /**
     * 字典表id(用于查询对应的应用商店id)
     */
    @ApiParam(value = "字典表id(用于查询对应的应用商店id)")
    @TableField("dict_id")
    private Integer dictId;
    /**
     * 删除状态(0:未删除, 1:已删除)
     */
    @ApiParam(value = "删除状态(0:未删除, 1:已删除)")
    @TableField("delete_flag")
    private Integer deleteFlag;
    /**
     * 删除状态(0:未删除, 1:已删除)
     */
    @ApiParam(value = "关闭状态(0:启用, 1:关闭)")
    @TableField("status")
    private Integer status;

    @Override
    public String toString() {
        return "Applications{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", systemType=" + systemType +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", downloadTotal=" + downloadTotal +
                ", completeNum=" + completeNum +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", applicationStoreId='" + applicationStoreId + '\'' +
                ", updateDescription='" + updateDescription + '\'' +
                ", roleId='" + roleId + '\'' +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", constraintUpdate=" + constraintUpdate +
                ", size='" + size + '\'' +
                ", dictId=" + dictId +
                ", deleteFlag=" + deleteFlag +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getDownloadTotal() {
        return downloadTotal;
    }

    public void setDownloadTotal(Integer downloadTotal) {
        this.downloadTotal = downloadTotal;
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

    public String getApplicationStoreId() {
        return applicationStoreId;
    }

    public void setApplicationStoreId(String applicationStoreId) {
        this.applicationStoreId = applicationStoreId;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getConstraintUpdate() {
        return constraintUpdate;
    }

    public void setConstraintUpdate(Integer constraintUpdate) {
        this.constraintUpdate = constraintUpdate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
