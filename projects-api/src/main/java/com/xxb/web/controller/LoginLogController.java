package com.xxb.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.LoginLog;
import com.xxb.model.service.ILoginLogService;
import com.xxb.utils.DtoUtil;
import com.xxb.web.dto.LoginLogDto;
import com.xxb.web.dto.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "login_log - Controller")
@RestController
@RequestMapping("/loginLog")
public class LoginLogController {
    private ResultJson resultJson = new ResultJson();
    @Autowired
    private ILoginLogService ilogin_logService;

    @ApiOperation(value = "添加 - login_log")
    @PostMapping(value = "insert")
    public ResultJson insert(@RequestBody LoginLogDto model) {
        LoginLog entity = DtoUtil.convertObject(model, LoginLog.class);
        boolean flag = ilogin_logService.insert(entity);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "修改 - login_log")
    @PutMapping(value = "up/{id}")
    public ResultJson update(@RequestBody LoginLogDto model) {
        LoginLog entity = DtoUtil.convertObject(model, LoginLog.class);
        boolean flag = ilogin_logService.update(entity, null);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "删除 - login_log")
    @DeleteMapping(value = "delete/{id}")
    public ResultJson delete(@PathVariable Integer id) {
        boolean flag = ilogin_logService.deleteById(id);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询所有 - login_log")
    @GetMapping(value = "query")
    public ResultJson<LoginLog> query() {
        Page<LoginLog> page = new Page<LoginLog>();
        Page<LoginLog> list = page.setRecords(ilogin_logService.query(page));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }


}

