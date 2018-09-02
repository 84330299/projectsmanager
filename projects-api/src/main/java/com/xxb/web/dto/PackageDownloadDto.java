package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 允许下载后返回数据
 * @author 张玉
 * @Date 2018/7/19.
 */
public class PackageDownloadDto implements Serializable {

    @ApiModelProperty(value = "下载地址")
    private String downloadUrl;
    @ApiModelProperty(value = "下载总量")
    private Integer downloadTotal;
    @ApiModelProperty(value = "版本大小")
    private String sizes;
    @ApiModelProperty(value = "已下载量")
    private Integer downloadComplete;
    @ApiModelProperty(value = "更新描述")
    private String updateDescription;
    @ApiModelProperty(value = "是否强制更新(0:不强制更新,1:强制更新,2:不更新)")
    private Integer forceUpdate;
    @ApiModelProperty(value = "应用code码")
    private Integer code;
    @ApiModelProperty(value = "版本号")
    private String version;

    @Override
    public String toString() {
        return "PackageDownloadDto{" +
                "downloadUrl='" + downloadUrl + '\'' +
                ", downloadTotal=" + downloadTotal +
                ", sizes='" + sizes + '\'' +
                ", downloadComplete=" + downloadComplete +
                ", updateDescription='" + updateDescription + '\'' +
                ", forceUpdate=" + forceUpdate +
                ", code=" + code +
                ", version='" + version + '\'' +
                '}';
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

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public Integer getDownloadComplete() {
        return downloadComplete;
    }

    public void setDownloadComplete(Integer downloadComplete) {
        this.downloadComplete = downloadComplete;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public Integer getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Integer forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
