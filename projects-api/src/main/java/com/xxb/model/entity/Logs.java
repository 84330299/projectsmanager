package com.xxb.model.entity;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

import io.swagger.annotations.ApiParam;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-11
 */
public class Logs extends Model<Logs> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 类名
     */
    @ApiParam(value = "类名")
    @TableField("class_name")
    private String className;
    /**
     * 方法名
     */
    @ApiParam(value = "方法名")
    @TableField("method_name")
    private String methodName;
    /**
     * 参数列表
     */
    @ApiParam(value = "参数列表")
    @TableField("params_args")
    private String paramsArgs;
    /**
     * IP地址
     */
    @ApiParam(value = "IP地址")
    @TableField("ip_address")
    private String ipAddress;
    /**
     * 消费时间
     */
    @ApiParam(value = "消费时间")
    @TableField("consumer_time")
    private Long consumerTime;
    /**
     * 创建时间
     */
    @ApiParam(value = "创建时间")
    @TableField("create_time")
    private Date createTime = new Date();
    /**
     * 异常信息
     */
    @ApiParam(value = "异常信息")
    @TableField("exp_info")
    private String expInfo;


    public Logs(String className, String methodName, String paramsArgs, String ipAddress) {
        this.className = className;
        this.methodName = methodName;
        this.paramsArgs = paramsArgs;
        this.ipAddress = ipAddress;
    }

    public Logs() {
    }

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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Logs{" +
                ", id=" + id +
                ", className=" + className +
                ", methodName=" + methodName +
                ", paramsArgs=" + paramsArgs +
                ", ipAddress=" + ipAddress +
                ", consumerTime=" + consumerTime +
                ", createTime=" + createTime +
                ", expInfo=" + expInfo +
                "}";
    }
}
