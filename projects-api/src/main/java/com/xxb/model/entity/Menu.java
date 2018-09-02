package com.xxb.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiParam(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 菜单编号
     */
    @ApiParam(value = "菜单编号")
    private String code;
    /**
     * 父菜单id
     */
    @ApiParam(value = "父菜单id")
    private Integer pid;
    /**
     * 菜单名称
     */
    @ApiParam(value = "菜单名称")
    private String name;
    /**
     * 菜单图标
     */
    @ApiParam(value = "菜单图标")
    private String icon;
    /**
     * url地址
     */
    @ApiParam(value = "url地址")
    private String url;
    /**
     * 菜单排序号
     */
    @ApiParam(value = "菜单排序号")
    private Integer num;
    /**
     * 菜单层级
     */
    @ApiParam(value = "菜单层级")
    private Integer levels;
    /**
     * 是否是菜单（1：是  0：不是）
     */
    @ApiParam(value = "是否是菜单（1：是  0：不是）")
    private Integer ismenu;
    /**
     * 备注
     */
    @ApiParam(value = "备注")
    private String tips;
    /**
     * 菜单状态 :  1:启用   0:不启用
     */
    @ApiParam(value = "菜单状态 :  1:启用   0:不启用")
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Integer getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Menu{" +
        ", id=" + id +
        ", code=" + code +
        ", pid=" + pid +
        ", name=" + name +
        ", icon=" + icon +
        ", url=" + url +
        ", num=" + num +
        ", levels=" + levels +
        ", ismenu=" + ismenu +
        ", tips=" + tips +
        ", status=" + status +
        "}";
    }
}
