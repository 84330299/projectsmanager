package com.xxb.web.dto;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@ApiModel(value = "菜单树形列表输出模型")
public class MenuDto implements Serializable{

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "菜单编号")
    private String code;

    @ApiModelProperty(value = "父菜单id")
    private Integer pid;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "url地址")
    private String url;

    @ApiModelProperty(value = "菜单排序号")
    private Integer num;

    @ApiModelProperty(value = "备注")
    private String tips;

    @ApiModelProperty(value = "菜单状态 :  1:启用   0:不启用")
    private Integer status;

    @ApiModelProperty(value = "子菜单")
    private List<MenuDto> childrenMenu;


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

    public List<MenuDto> getChildrenMenu() {
        return childrenMenu;
    }

    public void setChildrenMenu(List<MenuDto> childrenMenu) {
        this.childrenMenu = childrenMenu;
    }
}
