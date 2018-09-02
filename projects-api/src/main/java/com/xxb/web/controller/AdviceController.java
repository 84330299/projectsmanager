package com.xxb.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.annotation.Token;
import com.xxb.constant.ResultCode;
import com.xxb.exception.Assert;
import com.xxb.model.entity.Advice;
import com.xxb.model.enums.DictEnum;
import com.xxb.model.service.IAdviceService;
import com.xxb.utils.DtoUtil;
import com.xxb.utils.GetUserUtils;
import com.xxb.web.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "反馈管理(张玉)")
@RestController
@RequestMapping("/advice")
public class AdviceController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IAdviceService iadviceService;

    @ApiOperation(value = "添加 - advice--已检查")
    @PostMapping(value = "insert")
    @Token
    public ResultJson insert(@RequestBody AdviceDto model,@RequestHeader String token) {
        //判断用户手机号是否正确
        String picUrl = model.getPicUrl();
        Assert.notNull(picUrl,"截图链接地址不能为空");
        Advice entity = DtoUtil.convertObject(model, Advice.class);
        entity.setUserId(GetUserUtils.getUser().getId());
        //查询产品信息
        boolean flag = iadviceService.insert(entity);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "删除 - advice--已检查")
    @DeleteMapping(value = "delete/{id}")
    @Token
    public ResultJson delete(@PathVariable Integer id,@RequestHeader String token) {
        Wrapper<Advice> ew=new EntityWrapper<>();
        ew.eq("delete_flag",0);
        ew.eq("id",id);
        Advice advice = iadviceService.selectOne(ew);
        Assert.notNull(advice,"没有当前这条反馈信息");
        Integer i=iadviceService.deleteAdviceById(id);
        if (i!=null&&i>=1) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询反馈各状态的详情信息--已检查")
    @GetMapping(value = "getAdvice/{adivceId}/{status}")
    @Token
    public ResultJson<AdviceStatusDescriptionDto> getAdvice(@ApiParam(value = "反馈id",required = true)@PathVariable Integer adivceId,@ApiParam(value = "反馈的状态0:未解决, 1:已解决, 2:暂缓",required = true)@PathVariable Integer status,@RequestHeader String token) {
        AdviceStatusDescriptionDto adu=iadviceService.getAdvice(adivceId,status);
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(adu);
    }

    @ApiOperation(value = "批量删除--已检查")
    @PutMapping(value = "delete/")
    @Token
    public ResultJson deleteBatch(@RequestBody Integer[] ids,@RequestHeader String token) {
        Assert.isTrue(ids.length>0,"至少选择一条建议");
        Integer i=iadviceService.updateDeleteFalegStatus(ids);
        if (i>=1) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "反馈类型下拉列表--已检查")
    @GetMapping(value = "getAdviceType/")
    @Token
    public ResultJson<List<AdviceTypeDto>> getAdviceType(@RequestHeader String token) {
        List<AdviceTypeDto> atd=iadviceService.getAdviceType(DictEnum.反馈类型.getCode());
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(atd);
    }


    @ApiOperation(value = "反馈管理查看以及多条件筛选",notes = "当没有条件时，请求体中的全部参数为null即可---已检查")
    @PostMapping(value = "getAdvices")
    @Token
    public ResultJson<Page<AdviceManagerDto>> getAdvicesManager(@RequestBody ConditionAdvice conditionAdvice,@RequestHeader String token) {
        Page<AdviceManagerDto> page = new Page<AdviceManagerDto>(conditionAdvice.getCurrent(),conditionAdvice.getSize());
        Page<AdviceManagerDto> list = page.setRecords(iadviceService.selectAdvices(page,conditionAdvice));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

}

