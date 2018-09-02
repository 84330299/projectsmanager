package com.xxb.web.param;

import com.xxb.model.entity.Role;
import com.xxb.web.dto.UsersDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhenghe
 * @date 2018/7/12  15:50
 */
@ApiModel(value = "根据用户id复现用户/修改用户 模型")
public class UserIoParam extends UsersDto{
    @ApiModelProperty(value = "id",required = true)
    private Integer id;
    @ApiModelProperty(value = "组名")
    private String groupName;
    @ApiModelProperty(value = "职位名")
    private String postName;
    @ApiModelProperty(value = "角色，复现时用")
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
