package com.xxb.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.annotation.Token;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.MsgSend;
import com.xxb.model.service.IMsgSendService;
import com.xxb.utils.DtoUtil;
import com.xxb.web.dto.MsgListDto;
import com.xxb.web.dto.MsgSendDto;
import com.xxb.web.dto.ResultJson;
import com.xxb.web.param.MsgListParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 陈亮
 * @since 2018-07-09
 */
@Api(tags = "消息管理(张玉)")
@RestController
@RequestMapping("/msgSend")
    public class MsgSendController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IMsgSendService imsg_sendService;

    @ApiOperation(value = "添加 - msg_send")
    @PostMapping(value = "insert")
    @Token
    public ResultJson insert(@RequestBody MsgSendDto model,@RequestHeader String token){
        MsgSend entity=DtoUtil.convertObject(model,MsgSend.class);
        boolean flag=imsg_sendService.insertMsg(entity);
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "修改 - msg_send")
    @PutMapping(value = "up/{id}")
    @Token
    public ResultJson update(@RequestBody MsgSendDto model,@RequestHeader String token){
    MsgSend entity=DtoUtil.convertObject(model,MsgSend.class);
        boolean flag=imsg_sendService.update(entity,null);
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "删除 - msg_send")
    @DeleteMapping(value = "delete/{id}")
    @Token
    public ResultJson delete(@PathVariable Integer id,@RequestHeader String token){
        boolean flag=imsg_sendService.deleteById(id);
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询所有 - msg_send")
    @PostMapping(value = "query")
    @Token
    public ResultJson queryMsg(@RequestBody MsgListParam param,@RequestHeader String token){
        Page<MsgListDto> page=new Page<MsgListDto>(param.getCurrent(),param.getSize());
        Page<MsgListDto> list = page.setRecords(imsg_sendService.selectMsgList(page,param));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }
}

