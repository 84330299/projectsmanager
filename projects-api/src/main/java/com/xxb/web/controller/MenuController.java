package com.xxb.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.Menu;
import com.xxb.model.enums.UseStatus;
import com.xxb.model.service.IMenuService;
import com.xxb.utils.DtoUtil;
import com.xxb.web.dto.MenuDto;
import com.xxb.web.dto.ResultJson;
import com.xxb.web.param.MenuParam;
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
@Api(tags = "菜单(郑鹤) - Controller")
@RestController
@RequestMapping("/menu")
public class MenuController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IMenuService imenuService;

    @ApiOperation(value = "添加 - menu | 已完成")
    @PostMapping(value = "insert")
    public ResultJson insert(@RequestBody MenuParam model) {
        Wrapper<Menu> ew = new EntityWrapper<>();
        ew.eq("code", model.getCode());
        List<Menu> list = imenuService.selectList(ew);
        if (list != null || list.size() != 0) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("code码已被使用").setData(null);
        }
        Menu entity = DtoUtil.convertObject(model, Menu.class);
        entity.setId(null);
        entity.setIsmenu(1);
        entity.setStatus(UseStatus.启用.getVal());
        boolean flag = imenuService.insert(entity);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "修改 - menu")
    @PutMapping(value = "up")
    public ResultJson update(@RequestBody MenuParam model) {
        if(model.getId().equals(model.getPid())){
            return resultJson.setCode(ResultCode.FAIL).setMsg("父id不能是自身id").setData(null);
        }
        Menu entity = DtoUtil.convertObject(model, Menu.class);
        boolean flag = imenuService.updateById(entity);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "删除 - menu", hidden = true)
    @DeleteMapping(value = "delete/{id}")
    public ResultJson delete(@PathVariable Integer id) {
        boolean flag = imenuService.deleteById(id);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询所有(查询菜单树) - menu | 已完成")
    @GetMapping(value = "query")
    public ResultJson<MenuDto> query() {
        List<MenuDto> menus = imenuService.getMenuTree();
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(menus);
    }

    @ApiOperation(value = "禁用/启用 - menu | 已完成")
    @PostMapping(value = "inUse/{id}/{flag}")
    public ResultJson updateMenu(@PathVariable(value = "id") Integer id, @ApiParam(value = "0禁止，1启用") @PathVariable(value = "flag") Integer flag) {
        boolean f = UseStatus.isUseStatus(flag);
        if (!f) {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
        f = imenuService.updateMenus(id,flag);
        if (f) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

}

