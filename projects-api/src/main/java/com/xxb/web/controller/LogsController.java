package com.xxb.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.Logs;
import com.xxb.model.service.ILogsService;
import com.xxb.utils.DtoUtil;
import com.xxb.web.dto.LogsDto;
import com.xxb.web.dto.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 陈亮
 * @since 2018-07-11
 */
@Api(tags = "logs - Controller")
@RestController
@RequestMapping("/logs")
    public class LogsController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private ILogsService ilogsService;

    @ApiOperation(value = "添加 - logs")
    @PostMapping(value = "insert")
    public ResultJson insert(@RequestBody LogsDto model){
        Logs entity=DtoUtil.convertObject(model,Logs.class);
        boolean flag=ilogsService.insert(entity);
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "修改 - logs")
    @PutMapping(value = "up/{id}")
    public ResultJson update(@RequestBody LogsDto model){
    Logs entity=DtoUtil.convertObject(model,Logs.class);
        boolean flag=ilogsService.update(entity,null);
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "删除 - logs")
    @DeleteMapping(value = "delete/{id}")
    public ResultJson delete(@PathVariable Integer id){
        boolean flag=ilogsService.deleteById(id);
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询所有 - logs")
    @GetMapping(value = "query")
    public ResultJson query(){
        Page<Logs> page=new Page<Logs>();
        Page<Logs> list = page.setRecords(ilogsService.selectList(null));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }


}

