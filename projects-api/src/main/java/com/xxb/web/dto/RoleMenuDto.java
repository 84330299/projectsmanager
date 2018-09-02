package com.xxb.web.dto;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public class RoleMenuDto {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Integer rid;
    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    private Integer mid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

}
