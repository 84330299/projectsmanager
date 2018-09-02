package com.xxb.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhenghe
 * @date 2018/7/11  16:23
 */
@ApiModel(value = "组织结构列表")
public class GroupListDto implements Serializable {
    @ApiModelProperty(value = "组织id")
    private Integer id;
    @ApiModelProperty(value = "父id")
    private Integer pid;
    @ApiModelProperty(value = "分类名称")
    private String name;
    @ApiModelProperty(value = "排序权重")
    private Integer ordered;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "子分类")
    private List<GroupListDto> childrenDroups;

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

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<GroupListDto> getChildrenDroups() {
        return childrenDroups;
    }

    public void setChildrenDroups(List<GroupListDto> childrenDroups) {
        this.childrenDroups = childrenDroups;
    }
}
