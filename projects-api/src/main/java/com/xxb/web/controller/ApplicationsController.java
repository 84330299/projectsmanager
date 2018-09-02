package com.xxb.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.annotation.Token;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.Applications;
import com.xxb.model.entity.Packages;
import com.xxb.model.service.IApplicationsService;
import com.xxb.model.service.IPackagesService;
import com.xxb.utils.GetUserUtils;
import com.xxb.web.dto.ApplicationDetailDto;
import com.xxb.web.dto.ApplicationManagerDto;
import com.xxb.web.dto.ConditionProjectDto;
import com.xxb.web.dto.ResultJson;
import com.xxb.web.param.CreateApplicationParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "应用管理(张玉)")
@RestController
@RequestMapping("/applications")
public class ApplicationsController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IApplicationsService iapplicationsService;

    @Autowired
    private IPackagesService iPackagesService;


    /**
     *创建发包
    */
    @ApiOperation(value = "创建发包")
    @PostMapping(value = "packages")
    @Token
    public ResultJson createPackage(@RequestBody CreateApplicationParam param,@RequestHeader String token){
        //判断当前应用是否已创建,创建了则再插入到
        Wrapper<Applications> ew=new EntityWrapper<Applications>();
        ew.eq("project_id",param.getProjectId());
        ew.eq("system_type",param.getSystemType());
        ew.eq("delete_flag",0);
        Applications applications = iapplicationsService.selectOne(ew);
        if(applications==null){
            param.setUserId(GetUserUtils.getUser().getId());
            //创建一个应用
            iapplicationsService.insertApplication(param);
            applications=iapplicationsService.selectOne(ew);
        }else{
//            Assert.isTrue(applications.getStatus()==0,"当前应用没有开启发包功能，不能发包");
        }
        param.setApplicationId(applications.getId());
        //向发包表中插入数据
        param.setUserId(GetUserUtils.getUser().getId());
        Integer column = iPackagesService.insertPackage(param);
        if(column>0){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    /**
     * 查看发包详情
     * @param id 发包详情查看
    */
    @ApiOperation(value = "发包详情查看")
    @PostMapping(value = "getApp/{id}")
    @Token
    public ResultJson<ApplicationDetailDto> getAppById(@ApiParam(value = "发包记录Id", required = true) @PathVariable Integer id,@RequestHeader String token){
        ApplicationDetailDto app=iPackagesService.selectDetailPackage(id);

        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(app);
    }

    /**
     * 发包管理查看
     */
    @ApiOperation(value = "发包管理查看")
    @PostMapping(value = "getPackages")
    @Token
    public ResultJson<ApplicationManagerDto> getApps(@RequestBody ConditionProjectDto cpd,@RequestHeader String token){
        Page<ApplicationManagerDto> page = new Page<ApplicationManagerDto>(cpd.getCurrent(), cpd.getSize());
        //获取所有应用
        Page<ApplicationManagerDto> list = page.setRecords(iPackagesService.selectPackageList(page,cpd));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

    /**
     * 更新应用状态
     */
    @ApiOperation(value = "修改开启状态 - packages")
    @PutMapping(value = "ups/{id}/{status}")
    @Token
    public ResultJson upStatus(@ApiParam(value = "发包记录id", required = true) @PathVariable Integer id, @ApiParam(value = "状态,0:未开启,1:已开启", required = true) @PathVariable Integer status,@RequestHeader String token) {
        Packages packages = new Packages();
        packages.setStatus(status);
        packages.setId(id);
        Wrapper<Packages> ew=new EntityWrapper<>();
        ew.eq("id",id);
        boolean flag = iPackagesService.update(packages, ew);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "修改删除状态 - packages")
    @DeleteMapping(value = "delete/{id}")
    @Token
    public ResultJson upStatus(@ApiParam(value = "发包id", required = true) @PathVariable Integer id,@RequestHeader String token) {
        Wrapper<Packages>ew=new EntityWrapper<>();
        ew.eq("id",id);
        ew.eq("delete_flag",0);
        Packages packages = new Packages();
        packages.setDeleteFlag(1);
        boolean flag = iPackagesService.update(packages, ew);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "批量删除--已检查")
    @PostMapping(value = "delete/")
    @Token
    public ResultJson deleteBatch(@ApiParam(value = "发包id数组")@RequestBody Integer[] ids,@RequestHeader String token) {
        List<Packages> packagess = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            Packages packages = new Packages();
            packages.setId(ids[i]);
            packages.setDeleteFlag(1);
            packagess.add(packages);
        }
        boolean flag = iPackagesService.updateBatchById(packagess);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "导出应用 包信息")
    @PostMapping(value = "export")
    public void exportUsers(@RequestBody Integer[] ids) {
        iapplicationsService.exportPackage(ids);
    }
}

