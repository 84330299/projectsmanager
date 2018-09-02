package com.xxb.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhenghe
 * @date 2018/7/16  9:56
 */
@ApiModel(value = "用户修改密码传入参数")
public class ChangePasswordParam implements Serializable{
    @ApiModelProperty(value = "用户名",required = true,example = "hehe")
    private String userName;
    @ApiModelProperty(value = "密码，加密后的",required = true,example = "dfvwafsdfbvd545e4r54s54dv5")
    private String userPassword;
    @ApiModelProperty(value = "新密码",required = true,example = "dfvwafsdfbvd545e4r54s54dv5")
    private String userNewPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNewPassword() {
        return userNewPassword;
    }

    public void setUserNewPassword(String userNewPassword) {
        this.userNewPassword = userNewPassword;
    }
}
