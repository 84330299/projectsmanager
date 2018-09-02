package com.xxb.web.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 张玉
 * @Date 2018/7/19.
 */
public class PackageParam implements Serializable{
    @ApiModelProperty(value = "项目名",required = true,example = "学训宝")
    private String projectName;
    @ApiModelProperty(value = "版本号",required = true,example = "v2.0")
    private String version;
//    @ApiModelProperty(value = "渠道编号",required = true,example = "1")
//    private Integer sourceNum;
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 )",required = true)
    private Integer systemType;
    @ApiModelProperty(value = "版本编号",required = true,example = "1")
    private Integer code;
    @ApiModelProperty(value = "系统类型(0:ios ,1:安卓 )",required = true)
    private String sourceName;

    @Override
    public String toString() {
        return "PackageParam{" +
                "projectName='" + projectName + '\'' +
                ", version='" + version + '\'' +
                ", systemType=" + systemType +
                ", code=" + code +
                ", sourceName='" + sourceName + '\'' +
                '}';
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
//    @Override
//    public String toString() {
//        return "PackageParam{" +
//                "projectName='" + projectName + '\'' +
//                ", version='" + version + '\'' +
//                ", sourceNum=" + sourceNum +
//                ", systemType=" + systemType +
//                ", code=" + code +
//                '}';
//    }
//
//    public String getProjectName() {
//        return projectName;
//    }
//
//    public void setProjectName(String projectName) {
//        this.projectName = projectName;
//    }
//
//    public String getVersion() {
//        return version;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }
//
//    public Integer getSourceNum() {
//        return sourceNum;
//    }
//
//    public void setSourceNum(Integer sourceNum) {
//        this.sourceNum = sourceNum;
//    }
//
//    public Integer getSystemType() {
//        return systemType;
//    }
//
//    public void setSystemType(Integer systemType) {
//        this.systemType = systemType;
//    }
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
}
