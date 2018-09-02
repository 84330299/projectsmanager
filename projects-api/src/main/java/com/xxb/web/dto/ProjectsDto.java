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
public class ProjectsDto {

    /**
     * id
     */
    @ApiModelProperty(value = "id",hidden = true)
    private Integer id;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    @TableField("product_name")
    private String productName;
    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private String version;
    /**
     * 产品负责人id
     */
    @ApiModelProperty(value = "产品负责人id")
    @TableField("product_principal_id")
    private Integer productPrincipalId;
    /**
     * 测试负责人id
     */
    @ApiModelProperty(value = "测试负责人id")
    @TableField("test_principal_id")
    private Integer testPrincipalId;
    /**
     * 研发负责人id
     */
    @ApiModelProperty(value = "研发负责人id")
    @TableField("research_principal_id")
    private Integer researchPrincipalId;
    /**
     * 项目负责人id
     */
    @ApiModelProperty(value = "项目负责人id")
    @TableField("project_principal_id")
    private Integer projectPrincipalId;
    /**
     * 产品原型
     */
    @ApiModelProperty(value = "产品原型")
    @TableField("product_prototype")
    private String productPrototype;
    /**
     * 产品描述
     */
    @ApiModelProperty(value = "产品描述")
    @TableField("product_description")
    private String productDescription;
    /**
     * 状态(0:关闭 ,1:开启)
     */
    @ApiModelProperty(value = "状态(0:关闭 ,1:开启)",hidden = true)
    private Integer status;
    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id",hidden = true)
    @TableField("user_id")
    private Integer userId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",hidden = true)
    @TableField("create_time")
    private Date createTime;
    /**
     * 抄送角色的id(以逗号拼接)
     */
    @ApiModelProperty(value = "抄送角色的id(以逗号拼接)")
    @TableField("role_id")
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 删除状态(0:未删除 ,1:已删除)
     */
    @ApiModelProperty(value = "删除状态(0:未删除 ,1:已删除)")
    @TableField("delete_flag")
    private Integer deleteFlag;

    @Override
    public String toString() {
        return "ProjectsDto{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", version='" + version + '\'' +
                ", productPrincipalId=" + productPrincipalId +
                ", testPrincipalId=" + testPrincipalId +
                ", researchPrincipalId=" + researchPrincipalId +
                ", projectPrincipalId=" + projectPrincipalId +
                ", productPrototype='" + productPrototype + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", status=" + status +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", roleId='" + roleId + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getProductPrincipalId() {
        return productPrincipalId;
    }

    public void setProductPrincipalId(Integer productPrincipalId) {
        this.productPrincipalId = productPrincipalId;
    }

    public Integer getTestPrincipalId() {
        return testPrincipalId;
    }

    public void setTestPrincipalId(Integer testPrincipalId) {
        this.testPrincipalId = testPrincipalId;
    }

    public Integer getResearchPrincipalId() {
        return researchPrincipalId;
    }

    public void setResearchPrincipalId(Integer researchPrincipalId) {
        this.researchPrincipalId = researchPrincipalId;
    }

    public Integer getProjectPrincipalId() {
        return projectPrincipalId;
    }

    public void setProjectPrincipalId(Integer projectPrincipalId) {
        this.projectPrincipalId = projectPrincipalId;
    }

    public String getProductPrototype() {
        return productPrototype;
    }

    public void setProductPrototype(String productPrototype) {
        this.productPrototype = productPrototype;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
