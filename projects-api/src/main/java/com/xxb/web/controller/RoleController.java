package com.xxb.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.Role;
import com.xxb.model.entity.UserRole;
import com.xxb.model.entity.Users;
import com.xxb.model.enums.DeleteFlag;
import com.xxb.model.enums.UseStatus;
import com.xxb.model.service.IRoleService;
import com.xxb.model.service.IUserRoleService;
import com.xxb.model.service.IUsersService;
import com.xxb.web.dto.ResultJson;
import com.xxb.web.dto.RoleDownDto;
import com.xxb.web.param.RoleListParam;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "角色管理(郑鹤) - role")
@RestController
@RequestMapping("/role")
public class RoleController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IRoleService iroleService;

    @Autowired
    private IUsersService iUsersService;

    @Autowired
    private IUserRoleService iUserRoleService;

    @ApiOperation(value = "添加 - role | 已完成")
    @PostMapping(value = "insert")
    public ResultJson insert(@RequestBody String name) {
        Role role = new Role();
        role.setName(name);
        role.setCreateTime(new Date());
        role.setStatus(UseStatus.启用.getVal());
        role.setDeleteFlag(DeleteFlag.未删除.getVal());
        boolean flag = iroleService.insert(role);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "修改 - role | 已完成")
    @PutMapping(value = "up/{id}")
    public ResultJson update(@RequestBody String name, @PathVariable Integer id) {
        Role entity = new Role();
        entity.setId(id);
        entity.setName(name);
        boolean flag = iroleService.updateById(entity);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "启用，禁用，删除 - role | 已完成")
    @PutMapping(value = "changeStatus/{operate}/{ids}")
    public ResultJson changeStatus(@ApiParam(required = true, value = "0禁用，1启用，2删除") @PathVariable String operate,
                                   @ApiParam(required = true, value = "id内容") @PathVariable String ids) {
        if (operate.matches("[012]")) {
            boolean flag = iroleService.changeStatus(operate, ids);
            if (flag) {
                return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
            } else {
                return resultJson.setCode(ResultCode.FAIL).setMsg("该角色下有用户，禁止删除").setData(null);
            }
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg("参数不正确").setData(null);
        }
    }

    @ApiOperation(value = "删除 - role", hidden = true)
    @DeleteMapping(value = "delete/{id}")
    public ResultJson delete(@PathVariable Integer id) {

        Wrapper<UserRole> ew = new EntityWrapper<>();
        ew.eq("rid",id);
        boolean flag = iroleService.deleteById(id);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "角色管理 - 角色列表 | 已完成")
    @PostMapping(value = "query")
    public ResultJson<Page<Role>> query(@ApiParam(required = false) @RequestBody RoleListParam param) {
        Wrapper<Role> ew = new EntityWrapper<Role>();
        ew.eq("delete_flag",DeleteFlag.未删除.getVal()).orderBy("id",true);
        if (param.getName() != null && !"".equals(param.getName())) {
            ew.like("name", param.getName());
        }
        Role role = new Role();
        Page<Role> page = role.selectPage(
                new Page<Role>(param.getPage(), param.getSize()),
                ew
        );
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(page);
    }

    @ApiOperation(value = "根据id查找角色详情 - role | 已完成")
    @GetMapping(value = "find/{id}")
    public Role find(@PathVariable Integer id) {
        Wrapper<Role> wrapper = new EntityWrapper<Role>();
        Role role = iroleService.selectOne(wrapper.eq("id", id).eq("deleteFlag", 1));
        return role;
    }

    @ApiOperation(value = "角色下拉列表 - role")
    @GetMapping(value = "getRoleDown")
    public ResultJson<RoleDownDto> getRoleDown() {

        List<RoleDownDto> list = iroleService.getRoleDown();
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

//    @ApiOperation(value = "角色下拉列表分页获取 - role")
//    @GetMapping(value = "getRoleDown/{current}/{size}")
//    public ResultJson<RoleDownDto> getRoleDown1(@PathVariable int current, @PathVariable int size) {
//        //page为分页类，设置当前页，以及每页大小
//        Page<RoleDownDto> page = new Page<RoleDownDto>(current, size);
//        Page<RoleDownDto> list = page.setRecords(iroleService.getRoleDown(page));
//        return resultJson().setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
//    }


}

