package com.xxb.web.dto;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-11
 */
public class LogsDto {

    private Integer id;
    /**
     * 类名
     */
    @ApiModelProperty(value = "类名")
    @TableField("class_name")
    private String className;
    /**
     * 方法名
     */
    @ApiModelProperty(value = "方法名")
    @TableField("method_name")
    private String methodName;
    /**
     * 参数列表
     */
    @ApiModelProperty(value = "参数列表")
    @TableField("params_args")
    private String paramsArgs;
    /**
     * IP地址
     */
    @ApiModelProperty(value = "IP地址")
    @TableField("ip_address")
    private String ipAddress;
    /**
     * 消费时间
     */
    @ApiModelProperty(value = "消费时间")
    @TableField("consumer_time")
    private Long consumerTime;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 异常信息
     */
    @ApiModelProperty(value = "异常信息")
    @TableField("exp_info")
    private String expInfo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParamsArgs() {
        return paramsArgs;
    }

    public void setParamsArgs(String paramsArgs) {
        this.paramsArgs = paramsArgs;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Long getConsumerTime() {
        return consumerTime;
    }

    public void setConsumerTime(Long consumerTime) {
        this.consumerTime = consumerTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExpInfo() {
        return expInfo;
    }

    public void setExpInfo(String expInfo) {
        this.expInfo = expInfo;
    }

}
