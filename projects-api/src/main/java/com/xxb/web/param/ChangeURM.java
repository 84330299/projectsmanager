package com.xxb.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhenghe
 * @date 2018/7/16  21:05
 */
@ApiModel(value = "修改用户角色，角色菜单的关系的模型")
public class ChangeURM implements Serializable{
    @ApiModelProperty(value = "id",example = "1")
    private Integer id;
    @ApiModelProperty(value = "ids")
    private List<Integer> ids;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
