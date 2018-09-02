package com.xxb.dto;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/10 17:54
 */
public class SmsInfo {


    private Integer userId;
    /**
     * 接收人姓名
     * */
    private String devRoleName;


    /**
     * 应用产品名称
     * */
    private String productName;

    /**
     * 应用产品版本号
     * */
    private String productVersion;

    /**
     * 接受手机号
     * */
    private String phoneNumber;

    private String bizId;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDevRoleName() {
        return devRoleName;
    }

    public void setDevRoleName(String devRoleName) {
        this.devRoleName = devRoleName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SmsInfo() {
    }

    public SmsInfo(String devRoleName, String productName, String productVersion, String phoneNumber) {
        this.devRoleName = devRoleName;
        this.productName = productName;
        this.productVersion = productVersion;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "SmsInfo{" +
                "devRoleName='" + devRoleName + '\'' +
                ", productName='" + productName + '\'' +
                ", productVersion='" + productVersion + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
