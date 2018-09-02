package com.xxb.web.controller;

import com.xxb.annotation.Token;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.AdviceProgress;
import com.xxb.model.enums.AdviceDescriptionEnum;
import com.xxb.model.service.IAdviceProgressService;
import com.xxb.model.service.IAdviceService;
import com.xxb.utils.DtoUtil;
import com.xxb.utils.GetUserUtils;
import com.xxb.web.dto.AdviceProcessDescription;
import com.xxb.web.dto.AdviceProgressDto;
import com.xxb.web.dto.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "反馈进度(张玉)")
@RestController
@RequestMapping("/adviceProgress")
public class AdviceProgressController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IAdviceProgressService iadvice_progressService;

    @Autowired
    private IAdviceService iAdviceService;

    @ApiOperation(value = "添加 - advice_progress--已检查")
    @PostMapping(value = "insert")
    @Token
    public ResultJson insert(@RequestBody AdviceProgressDto model,@RequestHeader String token) {
        AdviceProgress entity = DtoUtil.convertObject(model, AdviceProgress.class);
        //判断当前是解决还是暂缓，更新对应的状态
        Integer status = model.getStatus();
        Integer adviceId = model.getAdviceId();
        if(status!=null&&status.equals(AdviceDescriptionEnum.已解决.getCode())){
            //更新advice表中的状态为已解决
            iAdviceService.updataStatus(status,adviceId);
        }
        if(status!=null&& status.equals(AdviceDescriptionEnum.暂缓.getCode())){
            //更新advice和中的状态为暂缓
            iAdviceService.updataStatus(status,adviceId);
        }
        entity.setUserId(GetUserUtils.getUser().getId());
        boolean flag = iadvice_progressService.insert(entity);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "根据id和状态查询反馈进度--已检查")
    @GetMapping(value = "getAdvice/{adviceId}/{status}")
    @Token
    public ResultJson<AdviceProcessDescription> getAdviceByIdAndStatus(@ApiParam(value = "反馈id",required = true)@PathVariable Integer adviceId,@ApiParam(value = "反馈状态(1:已解决,2:暂缓)",required = true) @PathVariable Integer status,@RequestHeader String token) {
        AdviceProcessDescription ap=iadvice_progressService.getAdviceByIdAndStatus(adviceId,status);
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(ap);
    }
}

