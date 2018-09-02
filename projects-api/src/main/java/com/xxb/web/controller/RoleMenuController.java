package com.xxb.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.RoleMenu;
import com.xxb.model.service.IRoleMenuService;
import com.xxb.utils.DtoUtil;
import com.xxb.web.dto.ResultJson;
import com.xxb.web.dto.RoleMenuDto;
import com.xxb.web.param.ChangeURM;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "角色-菜单(郑鹤) - Controller")
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IRoleMenuService iRoleMenuService;

    @ApiOperation(value = "添加 - role_menu", hidden = true)
    @PostMapping(value = "insert")
    public ResultJson insert(@RequestBody RoleMenuDto model) {
        RoleMenu entity = DtoUtil.convertObject(model, RoleMenu.class);
        boolean flag = iRoleMenuService.insert(entity);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "修改角色菜单关系 - role_menu | 已完成")
    @PutMapping(value = "up")
    public ResultJson updateRoleMenu(@RequestBody ChangeURM param) {

        boolean flag = iRoleMenuService.updateRoleMenu(param.getId(), param.getIds());
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "删除 - role_menu", hidden = true)
    @DeleteMapping(value = "delete/{id}")
    public ResultJson delete(@PathVariable Integer id) {
        boolean flag = iRoleMenuService.deleteById(id);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询所有 - role_menu", hidden = true)
    @GetMapping(value = "query")
    public ResultJson query() {
        Page<RoleMenu> page = new Page<RoleMenu>();
        Page<RoleMenu> list = page.setRecords(iRoleMenuService.selectList(null));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

    @ApiOperation(value = "根据角色id获取权限id - role | 已完成")
    @PostMapping(value = "getMenuByRid/{rid}")
    public ResultJson<RoleMenu> query(@ApiParam(required = true) @PathVariable Integer rid) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRid(rid);
        Wrapper<RoleMenu> ew = new EntityWrapper<RoleMenu>();
        ew.eq("rid", rid);
        List<RoleMenu> roleMenus = iRoleMenuService.selectList(ew);
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(roleMenus);
    }


}

