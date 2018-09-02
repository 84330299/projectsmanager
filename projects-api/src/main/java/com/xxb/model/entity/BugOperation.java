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
 * BUG操作流水表
 * </p>
 *
 * @author 涂文宇
 * @since 2018-07-16
 */
@TableName("bug_operation")
public class BugOperation extends Model<BugOperation> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiParam(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * BUG的id
     */
    @ApiParam(value = "BUG的id")
    @TableField("bug_id")
    private Integer bugId;
    /**
     * 发起者
     */
    @ApiParam(value = "发起者")
    @TableField("assign_id")
    private Integer assignId;
    /**
     * 操作 0:创建 1:指派 2:暂缓 3:解决 4:删除 5:激活
     */
    @ApiParam(value = "操作 0:创建 1:指派 2:暂缓 3:解决 4:删除 5:激活")
    private Integer operation;
    /**
     * 接受者
     */
    @ApiParam(value = "接受者")
    @TableField("accept_id")
    private Integer acceptId;
    /**
     * 解决方案/暂缓原因/指派备注
     */
    @ApiParam(value = "解决方案/暂缓原因/指派备注")
    private String txt;
    /**
     * 操作时间
     */
    @ApiParam(value = "操作时间")
    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Integer getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(Integer acceptId) {
        this.acceptId = acceptId;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BugOperation{" +
                "id=" + id +
                ", bugId=" + bugId +
                ", assignId=" + assignId +
                ", operation=" + operation +
                ", acceptId=" + acceptId +
                ", txt='" + txt + '\'' +
                ", date=" + date +
                '}';
    }

    /**
     * 指派操作
     * @param bugId bugId
     * @param assignId 发起者
     * @param operation 操作
     * @param acceptId 接受者
     * @param txt 指派备注
     * @param date 时间
     */
    public BugOperation( Integer bugId, Integer assignId, Integer operation, Integer acceptId, String txt, Date date) {
        this.bugId = bugId;
        this.assignId = assignId;
        this.operation = operation;
        this.acceptId = acceptId;
        this.txt = txt;
        this.date = date;
    }

    /**
     * 创建/删除操作
     * @param bugId bugId
     * @param assignId 发起者
     * @param operation 操作
     * @param date 时间
     */
    public BugOperation( Integer bugId, Integer assignId, Integer operation, Date date) {
        this.bugId = bugId;
        this.assignId = assignId;
        this.operation = operation;
        this.date = date;
    }

    /**
     * 解决/暂缓操作
     * @param bugId bugId
     * @param assignId 发起者
     * @param operation 操作
     * @param txt 解决方案/暂缓原因
     * @param date 时间
     */
    public BugOperation(Integer bugId, Integer assignId, Integer operation, String txt, Date date) {
        this.bugId = bugId;
        this.assignId = assignId;
        this.operation = operation;
        this.txt = txt;
        this.date = date;
    }
}
