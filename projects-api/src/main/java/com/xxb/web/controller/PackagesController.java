package com.xxb.web.controller;

import com.xxb.constant.ResultCode;
import com.xxb.model.service.IPackagesService;
import com.xxb.web.dto.PackageDownloadDto;
import com.xxb.web.dto.ResultJson;
import com.xxb.web.param.PackageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张玉
 * @Date 2018/7/19.
 */
@Api(tags = "发包管理")
@RestController
@RequestMapping("/packages")
public class PackagesController {
    @Autowired
    private IPackagesService iPackagesService;

    private ResultJson resultJson = new ResultJson();
    /**
     * 增加下载量
     * @param param 用户下载后的新版本参数
    */
    @ApiOperation(value = "增加下载量")
    @PostMapping(value = "increase")
    public ResultJson increaseDownloadNum(@RequestBody PackageParam param){
        Integer column=iPackagesService.increaseDownloadNum(param);
        if(column!=null&&column>0){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "更新校验")
    @PostMapping(value = "updateCheck")
    public ResultJson<PackageDownloadDto> updateCheck(@RequestBody PackageParam param){
        PackageDownloadDto pdd=iPackagesService.updateCheck(param);
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(pdd);
    }
}
