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
 * 字典表
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class Dict extends Model<Dict> {

    private static final long serialVersionUID = 1L;


    @ApiParam(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父id
     */
    @ApiParam(value = "父id")
    private Integer pid;
    /**
     * 字典名称
     */
    @ApiParam(value = "字典名称")
    private String name;
    /**
     * 字典类型(1应用商店，2组别，3职位)
     */
    @ApiParam(value = "字典类型(1应用商店，2组别，3职位)")
    private String type;
    /**
     * 字典码
     */
    @ApiParam(value = "字典码")
    private String code;
    /**
     * 字典值
     */
    @ApiParam(value = "字典值")
    private String value;
    /**
     * 排序
     */
    @ApiParam(value = "排序")
    private Integer ordered;
    /**
     * 权重(可以用来排序，或者表示子父关系,备用)
     */
    @ApiParam(value = "权重(可以用来排序，或者表示子父关系,备用)")
    private Integer weight;
    /**
     * 备注
     */
    @ApiParam(value = "备注")
    private String remark;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 删除标记（0删除，1未删除）
     */
    @ApiParam(value = "删除标记（0删除，1未删除）")
    @TableField("delete_flag")
    private Integer deleteFlag;

    @Override
    public String toString() {
        return "Dict{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                ", ordered=" + ordered +
                ", weight=" + weight +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
