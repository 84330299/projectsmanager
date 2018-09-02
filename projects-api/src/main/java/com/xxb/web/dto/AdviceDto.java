package com.xxb.web.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class AdviceDto {

    /**
     * id
     */
    @ApiModelProperty(value = "id",hidden = true,example="1")
    private Integer id;
    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id",required = true,example="1")
    @TableField("projects_id")
    private Integer projectsId;
    /**
     * 系统类型
     */
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 ,2:web)",example="0")
    @TableField("system_type")
    private Integer systemType;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注",example="测试")
    private String remark;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题",example="解决测试")
    private String title;

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    /**

     * 反馈描述
     */
    @ApiModelProperty(value = "反馈描述",example="鹤鹤中了大招")
    @TableField("advice_description")
    private String adviceDescription;
    /**
     * 截图链接地址(以逗号形式拼接)
     */
    @ApiModelProperty(value = "截图链接地址(以逗号形式拼接)",required = true,example="http://www.baidu.com,http://www.baidu.com")
    @TableField("pic_url")
    private String picUrl;
    /**
     * 抄送的角色id(以逗号进行拼接)
     */
    @ApiModelProperty(value = "抄送的角色id(以逗号进行拼接)",required = true,example = "21,22")
    @TableField("role_id")
    private String roleId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",hidden = true)
    @TableField("create_time")
    private Date createTime;
    /**
     * 解决时间
     */
    @ApiModelProperty(value = "解决时间",hidden = true)
    @TableField("resolve_time")
    private Date resolveTime;
    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id",hidden = true,example = "2")
    @TableField("user_id")
    private Integer userId;
    /**
     * 反馈状态(0:未解决, 1:已解决, 2:暂缓)
     */
    @ApiModelProperty(value = "反馈状态(0:未解决, 1:已解决, 2:暂缓)",hidden = true,example = "0")
    private Integer status;
    /**
     * 删除状态(0:未删除, 1:已删除)
     */
    @ApiModelProperty(value = "删除状态(0:未删除, 1:已删除)",hidden = true,example = "0")
    @TableField("delete_flag")
    private Integer deleteFlag;

    /**
     * 问题类型
     */
    @ApiModelProperty(value = "反馈问题类型(problemType与字典表中的Id对应)",example = "4")
    private Integer problemType;

    /**
     * 建议来源(1:内部,2:客户)
     */
    @ApiModelProperty(value = "建议来源(1:内部,2:客户)",hidden = true,example = "1")
    private Integer adviceSource;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号",required = true,example = "18111111111",hidden = true)
    private String telephone;

    @Override
    public String toString() {
        return "AdviceDto{" +
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

}
