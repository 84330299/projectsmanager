package com.xxb.web.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 字典表
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class DictDto {

    private Integer id;
    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Integer pid;
    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    private String name;
    /**
     * 字典类型(1应用商店，2组别，3职位)
     */
    @ApiModelProperty(value = "字典类型(1应用商店，2组别，3职位)")
    private String type;
    /**
     * 字典码
     */
    @ApiModelProperty(value = "字典码")
    private String code;
    /**
     * 字典值
     */
    @ApiModelProperty(value = "字典值")
    private String value;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer ordered;
    /**
     * 权重(可以用来排序，或者表示子父关系,备用)
     */
    @ApiModelProperty(value = "权重(可以用来排序，或者表示子父关系,备用)")
    private Integer weight;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 删除标记（0删除，1未删除）
     */
    @ApiModelProperty(value = "删除标记（0删除，1未删除）")
    @TableField("delete_flag")
    private Boolean deleteFlag;


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

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
