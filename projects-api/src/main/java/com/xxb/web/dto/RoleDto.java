package com.xxb.web.dto;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class RoleDto {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String name;
    /**
     * 提示
     */
    @ApiModelProperty(value = "提示")
    private String tips;

    /**
     *
     */
    @ApiModelProperty(value = "菜单权限")
    private List<String> menuPrem;

    /**
     * 状态（0禁用，1启用）
     */
    @ApiModelProperty(value = "状态（0禁用，1启用）")
    private Integer status;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getMenuPrem() {
        return menuPrem;
    }

    public void setMenuPrem(List<String> menuPrem) {
        this.menuPrem = menuPrem;
    }
}
