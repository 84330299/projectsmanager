package com.xxb.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-12
 */
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiParam(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 序号
     */
    @ApiParam(value = "序号")
    private Integer num;
    /**
     * 父角色id
     */
    @ApiParam(value = "父角色id")
    private Integer pid;
    /**
     * 角色名称
     */
    @ApiParam(value = "角色名称")
    private String name;
    /**
     * 提示
     */
    @ApiParam(value = "提示")
    private String tips;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 状态（0禁用，1启用）
     */
    @ApiParam(value = "状态（0禁用，1启用）")
    private Integer status;
    /**
     * 删除状态（0删除，1未删除）
     */
    @ApiParam(value = "删除状态（0删除，1未删除）")
    @TableField("delete_flag")
    private Integer deleteFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Role{" +
        ", id=" + id +
        ", num=" + num +
        ", pid=" + pid +
        ", name=" + name +
        ", tips=" + tips +
        ", createTime=" + createTime +
        ", status=" + status +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
