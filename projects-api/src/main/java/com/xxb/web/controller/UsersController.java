package com.xxb.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.annotation.Token;
import com.xxb.constant.ResultCode;
import com.xxb.model.entity.Users;
import com.xxb.model.enums.DeleteFlag;
import com.xxb.model.enums.UserEnum;
import com.xxb.model.service.IUserRoleService;
import com.xxb.model.service.IUsersService;
import com.xxb.utils.IPUtil;
import com.xxb.web.dto.*;
import com.xxb.web.param.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "用户(郑鹤) - Controller")
@RestController
@RequestMapping("/users")
public class UsersController {

    ResultJson resultJson = new ResultJson();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    //Redis中有效期
    @Value("${jwt.expires}")
    private int redisExpires;

    @Autowired
    private IUsersService iusersService;

    @ApiOperation(value = "用户注册 - users | 已完成")
    @PostMapping(value = "insert")
    public ResultJson insert(@RequestBody UsersDto model) {
        // 数据校验
        if (model == null || StringUtils.isBlank(model.getUserName())) {
            //用户不能为空
            return resultJson.setCode(ResultCode.FAIL).setMsg("用户不能为空").setData(null);
        }
        if (StringUtils.isBlank(model.getUserPassword())) {
            //密码不能为空
            return resultJson.setCode(ResultCode.FAIL).setMsg("密码不能为空").setData(null);
        }
        if (StringUtils.isBlank(model.getImg())) {
            //头像不能为空
            return resultJson.setCode(ResultCode.FAIL).setMsg("头像不能为空").setData(null);
        }
        if (StringUtils.isBlank(model.getTelephone())) {
            //电话号码不能为空
            return resultJson.setCode(ResultCode.FAIL).setMsg("电话号码不能为空").setData(null);
        }
        //查看用户名是否被使用
        Wrapper<Users> ew1 = new EntityWrapper<>();
        ew1.eq("name", model.getName());
        List<Users> usersList1 = iusersService.selectList(ew1);
        if (usersList1.size() != 0) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("姓名已被使用").setData(null);
        }
        //查看用户名是否被使用
        Wrapper<Users> ew = new EntityWrapper<>();
        ew.eq("user_name", model.getUserName());
        List<Users> usersList = iusersService.selectList(ew);
        if (usersList.size() != 0) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("用户名已经被占用").setData(null);
        }
        //验证电话号码是多少位
        if (model.getTelephone().length() != 11 || !model.getTelephone().startsWith("1")) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("电话号码格式不对").setData(null);
        }


        boolean flag = iusersService.register(model);

        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "修改用户信息 - users | 已完成")
    @PutMapping(value = "update")
    public ResultJson update(@RequestBody UserIoParam user) {


        boolean flag = iusersService.updateUser(user);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "导出用户信息 - users | 已完成")
    @PostMapping(value = "export")
    public void exportUsers(@RequestBody ExportParam param) {
        if (param.getIds() == null && param.getStartTime() == null && param.getEndTime() == null) {
            //return resultJson.setCode(ResultCode.FAIL).setMsg("参数错误").setData(null);
            return;
        }
        iusersService.exportUsers(param);
//        if (flag != null) {
//            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(flag);
//        } else {
//            return resultJson.setCode(ResultCode.FAIL).setMsg("没有数据").setData(null);
//        }
    }


    @ApiOperation(value = "启用，禁用，删除 - user | 已完成")
    @PutMapping(value = "changeStatus/{operate}/{ids}")
    public ResultJson changeStatus(@ApiParam(required = true, value = "0禁用，1启用，2删除") @PathVariable String operate,
                                   @ApiParam(required = true, value = "id内容") @PathVariable String ids) {
        if (operate.matches("[012]")) {
            boolean flag = iusersService.changeStatus(operate, ids);
            if (flag) {
                return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
            } else {
                return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
            }
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "删除 - users  | 已完成", hidden = true)
    @DeleteMapping(value = "delete/{id}")
    public ResultJson delete(@PathVariable Integer id) {
        Users u = new Users();
        u.setId(id);
        u.setDeleteFlag(DeleteFlag.已删除.getVal());
        boolean flag = iusersService.insertOrUpdate(u);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "查询所有 - users")
    @GetMapping(value = "query")
    public ResultJson query() {
        Page<Users> page = new Page<Users>();
        Page<Users> list = page.setRecords(iusersService.selectList(null));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

    @ApiOperation(value = "通过名字模糊查询")
    @PostMapping(value = "fuzzy")
    public ResultJson<UserFuzzyDto> fuzzyQueryByName(String name) {
        Wrapper<Users> wrapper = new EntityWrapper<>();
        wrapper.like("name", name);
        wrapper.eq("delete_flag", UserEnum.未删除.getCode());
        List<Users> list = iusersService.selectList(wrapper);
        List<UserFuzzyDto> collect = list.stream().map(e -> {
            UserFuzzyDto uv = new UserFuzzyDto();
            uv.setId(e.getId());
            uv.setName(e.getName());
            return uv;
        }).collect(Collectors.toList());
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(collect);
    }

    @ApiOperation(value = "用户登出 | 已完成")
    @PostMapping(value = "logout")
    public ResultJson logout(@RequestHeader String token) {
        LoginDto loginDto = (LoginDto) redisTemplate.opsForValue().get(token);
        if (loginDto != null) {
            redisTemplate.delete(token);
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        }
    }

    @ApiOperation(value = "用户登录 | 已完成")
    @PostMapping(value = "login")
    public ResultJson<LoginDto> login(@ApiParam(value = "登录参数", required = true) @RequestBody LoginParam param) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        param.setIp(IPUtil.getIpAddr(request));
        if (StringUtils.isBlank(param.getUserName())) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("用户名不能为空").setData(null);
        }
        if (StringUtils.isBlank(param.getUserPassword())) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("密码不能为空").setData(null);
        }
        LoginDto loginDto = iusersService.login(param);
        if (loginDto == null) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("用户名或密码错误").setData(null);
        }
        //登录成功,存入缓存
        redisTemplate.opsForValue().set(loginDto.getToken(), loginDto, redisExpires, TimeUnit.SECONDS);

        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(loginDto);
    }

    @ApiOperation(value = "修改密码 | 已完成")
    @PostMapping(value = "changePassword")
    public ResultJson changePassword(@ApiParam(value = "登录参数", required = true) @RequestBody ChangePasswordParam param) {
        if (StringUtils.isBlank(param.getUserName())) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("用户名不能为空").setData(null);
        }
        if (StringUtils.isBlank(param.getUserPassword())) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("密码不能为空").setData(null);
        }
        if (StringUtils.isBlank(param.getUserNewPassword())) {
            return resultJson.setCode(ResultCode.FAIL).setMsg("新密码不能为空").setData(null);
        }
        boolean flag = iusersService.changePassword(param);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg("用户名或密码错误").setData(null);
        }

    }


    @Token
    @ApiOperation(value = "分页条件查询所有 - users | 已完成")
    @PostMapping(value = "getUserList")
    public ResultJson<Page<UserListDto>> getUserList(@RequestBody UserListParam param, @RequestHeader String token) {
        Page<UserListDto> page = new Page<UserListDto>(param.getPage(), param.getPageNum());
        Page<UserListDto> list = page.setRecords(iusersService.getUserList(page, param));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

    @ApiOperation(value = "根据id查询 - users | 已完成")
    @GetMapping(value = "getById/{id}")
    public ResultJson<UserIoParam> getById(@PathVariable Integer id) {
        UserIoParam user = iusersService.getById(id);
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(user);
    }

    @ApiOperation(value = "重置密码 - users | 已完成")
    @PutMapping(value = "resetPassword/{id}")
    public ResultJson resetPassword(@PathVariable Integer id) {
        boolean flag = iusersService.resetPassword(id);
        if (flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        } else {
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }


}

