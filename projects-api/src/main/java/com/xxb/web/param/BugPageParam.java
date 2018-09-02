package com.xxb.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 涂文宇
 * @date 2018/7/18 9:41
 */
@ApiModel("分页参数")
public class BugPageParam implements Serializable {
    @ApiModelProperty(value = "页码", example = "1")
    private Integer page = 1;
    @ApiModelProperty(value = "每页的条数", example = "10")
    private Integer pageSize = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
