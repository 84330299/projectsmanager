package com.xxb.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.Msg;
import com.xxb.model.service.IMsgService;
import com.xxb.utils.DtoUtil;
import com.xxb.web.dto.MsgDto;
import com.xxb.web.dto.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 陈亮
 * @since 2018-07-09
 */
@Api(tags = "msg - Controller")
@RestController
@RequestMapping("/msg")
public class MsgController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IMsgService imsgService;

    @ApiOperation(value = "添加 - msg")
    @PostMapping(value = "insert")
    public ResultJson insert(@RequestBody MsgDto model) {
        Msg entity = DtoUtil.convertObject(model, Msg.class);
        boolean flag = imsgService.insert(entity);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "修改 - msg")
    @PutMapping(value = "up/{id}")
    public ResultJson update(@RequestBody MsgDto model) {
        Msg entity = DtoUtil.convertObject(model, Msg.class);
        boolean flag = imsgService.update(entity, null);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "删除 - msg")
    @DeleteMapping(value = "delete/{id}")
    public ResultJson delete(@PathVariable Integer id) {
        boolean flag = imsgService.deleteById(id);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询所有 - msg")
    @GetMapping(value = "query/{current}/{size}")
    public ResultJson query(@PathVariable int current, @PathVariable int size) {
        Page<Msg> page = new Page<>(current, size);
        Page<Msg> list = page.setRecords(imsgService.query(page));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }


}

