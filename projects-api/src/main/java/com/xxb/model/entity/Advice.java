package com.xxb.model.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class Advice extends Model<Advice> {

    private static final long serialVersionUID = 1L;

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    /**
     * id
     */
    @ApiParam(value = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 产品id
     */
    @ApiParam(value = "产品id")
    @TableField("projects_id")
    private Integer projectsId;
    /**
     * 系统类型
     */
    @ApiParam(value = "系统类型")
    @TableField("system_type")
    private Integer systemType;
    /**
     * 备注
     */
    @ApiParam(value = "备注")
    private String remark;
    /**
     * 标题
     */
    @ApiParam(value = "标题")
    private String title;
    /**
     * 反馈描述
     */
    @ApiParam(value = "反馈描述")
    @TableField("advice_description")
    private String adviceDescription;
    /**
     * 截图链接地址(以逗号形式拼接)
     */
    @ApiParam(value = "截图链接地址(以逗号形式拼接)")
    @TableField("pic_url")
    private String picUrl;
    /**
     * 抄送的角色id(以逗号进行拼接)
     */
    @ApiParam(value = "抄送的角色id(以逗号进行拼接)")
    @TableField("role_id")
    private String roleId;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 解决时间
     */
    @ApiParam(value = "解决时间")
    @TableField("resolve_time")
    private Date resolveTime;
    /**
     * 创建者id
     */
    @ApiParam(value = "创建者id")
    @TableField("user_id")
    private Integer userId;
    /**
     * 反馈状态(0:未解决, 1:已解决, 2:暂缓)
     */
    @ApiParam(value = "反馈状态(0:未解决, 1:已解决, 2:暂缓)")
    private Integer status;
    /**
     * 删除状态(0:未删除, 1:已删除)
     */
    @ApiParam(value = "删除状态(0:未删除, 1:已删除)")
    @TableField("delete_flag")
    private Integer deleteFlag;

    /**
     * 问题类型
     */
    @ApiParam(value = "反馈问题类型(problemType与字典表中的Id对应)")
    @TableField("dict_id")
    private Integer problemType;

    /**
     * 建议来源(1:内部,2:客户)
     */
    @ApiParam(value = "建议来源(1:内部,2:客户)")
    @TableField("advice_source")
    private Integer adviceSource;
    /**
     * 建议来源(1:内部,2:客户)
     */
    @ApiParam(value = "手机号")
    @TableField("telephone")
    private String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", projectsId=" + projectsId +
                ", systemType='" + systemType + '\'' +
                ", remark='" + remark + '\'' +
                ", title='" + title + '\'' +
                ", adviceDescription='" + adviceDescription + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", roleId='" + roleId + '\'' +
                ", createTime=" + createTime +
                ", resolveTime=" + resolveTime +
                ", userId=" + userId +
                ", status=" + status +
                ", deleteFlag=" + deleteFlag +
                ", problemType=" + problemType +
                ", adviceSource=" + adviceSource +
                ", telephone=" + telephone +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(Integer projectsId) {
        this.projectsId = projectsId;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getProblemType() {
        return problemType;
    }

    public void setProblemType(Integer problemType) {
        this.problemType = problemType;
    }

    public Integer getAdviceSource() {
        return adviceSource;
    }

    public void setAdviceSource(Integer adviceSource) {
        this.adviceSource = adviceSource;
    }
}
