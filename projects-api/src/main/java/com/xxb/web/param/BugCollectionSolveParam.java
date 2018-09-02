package com.xxb.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 涂文宇
 * @date 2018/7/16 10:10
 */

@ApiModel("解决或暂缓BUG传入数据")
public class BugCollectionSolveParam implements Serializable {
    @ApiModelProperty(value = "BUG的id,必填", example = "1")
    private Integer id;
    @ApiModelProperty(value = "解决/暂缓,2:暂缓,3:解决,必填", example = "3")
    private Integer operateType;
    @ApiModelProperty(value = "解决方案/暂缓原因,必填", example = "根据用户的描述,兼容的浏览器新增ie")
    private String txt;
    @ApiModelProperty(value = "操作人", hidden = true)
    private Integer uid;
    @ApiModelProperty(value = "操作的时间", hidden = true)
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
