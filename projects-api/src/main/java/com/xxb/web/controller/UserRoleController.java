package com.xxb.web.controller;

import com.xxb.model.service.IUserRoleService;
import com.xxb.web.dto.ResultJson;
import com.xxb.web.param.ChangeURM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import com.xxb.utils.DtoUtil;
import com.xxb.constant.ResultCode;
import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.model.entity.UserRole;
import com.xxb.web.dto.UserRoleDto;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "用户角色(郑鹤) - Controller")
@RestController
@RequestMapping("/userRole")
    public class UserRoleController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IUserRoleService iUserRoleService;

    @ApiOperation(value = "添加 - user_role")
    @PostMapping(value = "insert")
    public ResultJson insert(@RequestBody UserRoleDto model){
        UserRole entity=DtoUtil.convertObject(model,UserRole.class);
        boolean flag=iUserRoleService.insert(entity);
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "修改用户角色对应 - user_role | 已完成")
    @PutMapping(value = "up")
    public ResultJson update(@RequestBody ChangeURM urm){
        boolean flag = iUserRoleService.updateUserRole(urm.getId(),urm.getIds());
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "删除 - user_role")
    @DeleteMapping(value = "delete/{id}")
    public ResultJson delete(@PathVariable Integer id){
        boolean flag=iUserRoleService.deleteById(id);
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询所有 - user_role")
    @GetMapping(value = "query")
    public ResultJson query(){
        Page<UserRole> page=new Page<UserRole>();
        Page<UserRole> list = page.setRecords(iUserRoleService.selectList(null));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }
}

