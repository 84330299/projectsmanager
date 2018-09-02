package com.xxb.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.annotation.Token;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.Dict;
import com.xxb.model.enums.DictEnum;
import com.xxb.model.service.IDictService;
import com.xxb.utils.DtoUtil;
import com.xxb.web.dto.AppStoresDto;
import com.xxb.web.dto.DictDto;
import com.xxb.web.dto.ItemDto;
import com.xxb.web.dto.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "dict(郑鹤) - Controller")
@RestController
@RequestMapping("/dict")
public class DictController {
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IDictService idictService;

    @ApiOperation(value = "添加 - dict")
    @PostMapping(value = "insert")
    @Token
    public ResultJson insert(@RequestBody DictDto model,@RequestHeader String token) {
        Dict entity = DtoUtil.convertObject(model, Dict.class);
        boolean flag = idictService.insert(entity);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "修改 - dict")
    @PutMapping(value = "up/{id}")
    @Token
    public ResultJson update(@RequestBody DictDto model,@RequestHeader String token) {
        Dict entity = DtoUtil.convertObject(model, Dict.class);
        boolean flag = idictService.update(entity, null);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "批量删除分组/职位/渠道 - dict")
    @PostMapping(value = "delete")
    public ResultJson delete(@RequestBody List<Integer> ids) {

        boolean flag = idictService.deleteDict(ids);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "查询所有 - dict")
    @GetMapping(value = "query")
    public ResultJson query() {
        Page<Dict> page = new Page<Dict>();
        Page<Dict> list = page.setRecords(idictService.selectList(null));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

    @ApiOperation(value = "查询所有应用商店")
    @GetMapping(value = "getStores")
    public ResultJson getAppStores() {
        EntityWrapper<Dict> dictEntityWrapper = new EntityWrapper<>();
        dictEntityWrapper.eq("type", DictEnum.应用商店.getCode());
        dictEntityWrapper.eq("delete_flag",1);
        List<Dict> dictList = idictService.selectList(dictEntityWrapper);
        List<AppStoresDto> storesDtoList = dictList.stream().map(e -> {
            AppStoresDto appStoresDto = new AppStoresDto();
            appStoresDto.setId(e.getId());
            appStoresDto.setName(e.getName());
            return appStoresDto;
        }).collect(Collectors.toList());
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(storesDtoList);
    }

    @ApiOperation(value = "查询分组列表/职位列表/渠道 | 已完成")
    @GetMapping(value = "getGroupOrPost/{flag}")
    public ResultJson<List<ItemDto>> getGroupOrPost(@PathVariable @ApiParam(value = "0分组列表，1职位列表,2渠道") Integer flag) {
        List<ItemDto> itemDtos = new ArrayList<>();
        if (flag == 0) {
            //分组
            itemDtos = idictService.getGroupOrPost(DictEnum.组别.getCode());
        } else if (flag == 1) {
            //职位
            itemDtos = idictService.getGroupOrPost(DictEnum.职位.getCode());
        } else if (flag == 2) {
            //渠道
            itemDtos = idictService.getGroupOrPost(DictEnum.应用商店.getCode());
        } else {
            //抛错误
            return resultJson.setCode(ResultCode.FAIL).setMsg("参数错误").setData(null);
        }

        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(itemDtos);
    }


    @ApiOperation(value = "新增渠道")
    @GetMapping(value = "insertSource/{name}")
    public ResultJson insertSource(@PathVariable String name) {
        Integer resultColumn=idictService.insertSource(name);
        if(resultColumn>0){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "新增反馈问题类型")
    @GetMapping(value = "insertProblem/{name}")
    public ResultJson insertProblemType(@PathVariable String name) {
        Integer resultColumn=idictService.insertProblemType(name);
        if(resultColumn>0){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }
}

