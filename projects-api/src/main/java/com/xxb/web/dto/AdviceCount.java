package com.xxb.web.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 反馈统计参数封装
 * @Date 2018/7/12.
 */
public class AdviceCount {
    @ApiModelProperty(value = "应用id")
    private Integer applicationId;
    @ApiModelProperty(value = "反馈总数")
    private Integer adviceCount;
    @ApiModelProperty(value = "反馈未解决数")
    private Integer adviceUnsolveNum;
    @ApiModelProperty(value = "反馈解决数")
    private Integer adviceSolveNum;
    @ApiModelProperty(value = "反馈暂缓数")
    private Integer adviceDeferNum;

    @Override
    public String toString() {
        return "AdviceCount{" +
                "applicationId=" + applicationId +
                ", adviceCount=" + adviceCount +
                ", adviceUnsolveNum=" + adviceUnsolveNum +
                ", adviceSolveNum=" + adviceSolveNum +
                ", adviceDeferNum=" + adviceDeferNum +
                '}';
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getAdviceCount() {
        return adviceCount;
    }

    public void setAdviceCount(Integer adviceCount) {
        this.adviceCount = adviceCount;
    }

    public Integer getAdviceUnsolveNum() {
        return adviceUnsolveNum;
    }

    public void setAdviceUnsolveNum(Integer adviceUnsolveNum) {
        this.adviceUnsolveNum = adviceUnsolveNum;
    }

    public Integer getAdviceSolveNum() {
        return adviceSolveNum;
    }

    public void setAdviceSolveNum(Integer adviceSolveNum) {
        this.adviceSolveNum = adviceSolveNum;
    }

    public Integer getAdviceDeferNum() {
        return adviceDeferNum;
    }

    public void setAdviceDeferNum(Integer adviceDeferNum) {
        this.adviceDeferNum = adviceDeferNum;
    }
}
