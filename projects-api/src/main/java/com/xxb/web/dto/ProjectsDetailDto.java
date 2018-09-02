package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2018/7/6.
 */
public class ProjectsDetailDto {

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;
    /**
     * 产品版本
     */
    @ApiModelProperty(value = "产品版本")
    private String version;
    /**
     * 产品负责人名字
     */
    @ApiModelProperty(value = "产品负责人名字")
    private String productPrincipalName;
    /**
     * 测试负责人名字
     */
    @ApiModelProperty(value = "测试负责人名字")
    private String testPrincipalName;
    /**
     * 研发负责人名字
     */
    @ApiModelProperty(value = "研发负责人名字")
    private String researchPrincipalName;
    /**
     * 项目负责人名字
     */
    @ApiModelProperty(value = "项目负责人名字")
    private String projectPrincipalName;
    /**
     * 产品原型
     */
    @ApiModelProperty(value = "产品原型")
    private String productPrototype;
    /**
     * 产品描述
     */
    @ApiModelProperty(value = "产品描述")
    private String productDescription;;

    @Override
    public String toString() {
        return "ProjectsDetailDto{" +
                "productName='" + productName + '\'' +
                ", version='" + version + '\'' +
                ", productPrincipalName='" + productPrincipalName + '\'' +
                ", testPrincipalName='" + testPrincipalName + '\'' +
                ", researchPrincipalName='" + researchPrincipalName + '\'' +
                ", projectPrincipalName='" + projectPrincipalName + '\'' +
                ", productPrototype='" + productPrototype + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
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

    public String getProductPrincipalName() {
        return productPrincipalName;
    }

    public void setProductPrincipalName(String productPrincipalName) {
        this.productPrincipalName = productPrincipalName;
    }

    public String getTestPrincipalName() {
        return testPrincipalName;
    }

    public void setTestPrincipalName(String testPrincipalName) {
        this.testPrincipalName = testPrincipalName;
    }

    public String getResearchPrincipalName() {
        return researchPrincipalName;
    }

    public void setResearchPrincipalName(String researchPrincipalName) {
        this.researchPrincipalName = researchPrincipalName;
    }

    public String getProjectPrincipalName() {
        return projectPrincipalName;
    }

    public void setProjectPrincipalName(String projectPrincipalName) {
        this.projectPrincipalName = projectPrincipalName;
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
}
