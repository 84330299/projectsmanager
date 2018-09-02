package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 建议（解决，暂缓）描述
 * @Date 2018/7/10.
 */
public class AdviceProcessDescription {
    @ApiModelProperty(value = "反馈id",example = "1")
    private Integer adviceId;

    @ApiModelProperty(value = "建议描述",example = "第一个解决描述")
    private List<String> adviceDescription;

    @ApiModelProperty(value = "状态(1:已解决,2:暂缓)",example = "1")
    private Integer status;

    @Override
    public String toString() {
        return "AdviceProcessDescription{" +
                "adviceId=" + adviceId +
                ", adviceDescription=" + adviceDescription +
                ", status=" + status +
                '}';
    }

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public List<String> getAdviceDescription() {
        return adviceDescription;
    }

    public void setAdviceDescription(List<String> adviceDescription) {
        this.adviceDescription = adviceDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
