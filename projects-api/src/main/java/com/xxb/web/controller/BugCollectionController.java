package com.xxb.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.annotation.Token;
import com.xxb.model.service.IBugCollectionService;
import com.xxb.model.service.IBugOperationService;
import com.xxb.utils.GetUserUtils;
import com.xxb.web.dto.BugCollectionDto;
import com.xxb.web.dto.BugViewDto;
import com.xxb.web.dto.ResultJson;
import com.xxb.web.param.*;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import com.xxb.constant.ResultCode;

import java.util.Date;


/**
 * @author 涂文宇
 * @date 2018/7/13 9:26
 */
@Api(tags = "BUG搜集(涂文宇)")
//@RestController
@RequestMapping("/bugCollection")
public class BugCollectionController {
    private ResultJson resultJson = new ResultJson();


    @Autowired
    private IBugCollectionService bugService;
    @Autowired
    private IBugOperationService operationService;

    @Token
    @ApiOperation(value = "创建-已完成")
    @PostMapping(value = "insert")
    public ResultJson insert(@ApiParam(value = "创建BUG参数") @RequestBody BugCollectionParam param, @RequestHeader String token) {
        //获取当前用户设置为创建人
        Integer createPerson = GetUserUtils.getUser().getId();
        boolean flag = bugService.insertBug(param, createPerson);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }

    }

    @Token
    @ApiOperation(value = "解决或暂缓-已完成")
    @PutMapping(value = "solve")
    public ResultJson update(@ApiParam(value = "解决或者暂缓的参数", required = true) @RequestBody BugCollectionSolveParam param, @RequestHeader String token) {
        param.setDate(new Date());
        param.setUid(GetUserUtils.getUser().getId());
        boolean flag = bugService.solveOrDelay(param);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "删除-已完成")
    @DeleteMapping(value = "delete/{id}")
    public ResultJson delete(@ApiParam(value = "待删除的BUG主键", required = true) @PathVariable Integer id, @RequestHeader String token) {
        Integer createPerson = GetUserUtils.getUser().getId();
        boolean flag = bugService.deleteCreateByMe(createPerson, id);
//        boolean flag = bugService.deleteById(id);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询全部-已完成")
    @PostMapping(value = "query")
    public ResultJson query(@ApiParam(value = "分页参数") @RequestBody BugPageParam param) {
        Page<BugCollectionDto> page = new Page<>(param.getPage(), param.getPageSize());
        Page<BugCollectionDto> list = page.setRecords(bugService.selectAll());
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);

    }

    @ApiOperation(value = "按状态查询 -已完成")
    @PostMapping(value = "flag/{bugFlag}")
    public ResultJson flag(@ApiParam(value = "0:未解决 1:已暂缓 2:已解决 3:激活过", required = true) @PathVariable Integer bugFlag,
                           @ApiParam(value = "分页参数") @RequestBody BugPageParam param) {
        Page<BugCollectionDto> page = new Page<BugCollectionDto>(param.getPage(), param.getPageSize());
        Page<BugCollectionDto> list = page.setRecords(bugService.selectByFlag(bugFlag));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

    @ApiOperation(value = "查询与我相关-已完成")
    @PostMapping(value = "me/{type}")
    public ResultJson me(@ApiParam(value = " 0:由我创建 1:由我解决 2:指派给我", required = true) @PathVariable Integer type,
                         @ApiParam(value = "分页参数") @RequestBody BugPageParam param,
                         @RequestHeader String token) {
        Page<BugCollectionDto> page = new Page<BugCollectionDto>(param.getPage(), param.getPageSize());
        Page<BugCollectionDto> list = page.setRecords(bugService.selectMe(type, GetUserUtils.getUser().getId()));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

    @ApiOperation(value = "条件查询-已完成")
    @PostMapping(value = "condition")
    public ResultJson condition(@ApiParam(value = "条件查询参数", required = true) @RequestBody BugConditionParam param) {
        Page<BugCollectionDto> page = new Page<BugCollectionDto>(param.getPage(), param.getPageSize());
        Page<BugCollectionDto> list = page.setRecords(bugService.selectByCondition(param));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);

    }

    @ApiOperation(value = "指派-已完成")
    @PutMapping(value = "appoint")
    public ResultJson appoint(@ApiParam(value = "指派参数", required = true) @RequestBody BugAppointParam param,
                              @RequestHeader String token) {
//        BugCollection entity = DtoUtil.convertObject(param, BugCollection.class);
        param.setAssignId(GetUserUtils.getUser().getId());
        Boolean flag = bugService.appoint(param);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }

    }

    @ApiOperation(value = "激活-已完成")
    @PutMapping(value = "active/{id}")
    public ResultJson active(@PathVariable Integer id,
                             @RequestHeader String token) {
        Integer uid = GetUserUtils.getUser().getId();
        boolean flag = bugService.active(id, uid);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查看-已完成")
    @GetMapping(value = "view/{id}")
    public ResultJson view(@PathVariable Integer id) {
        BugViewDto entity = bugService.view(id);
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(entity);
    }


}

