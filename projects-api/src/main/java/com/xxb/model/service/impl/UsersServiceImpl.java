package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.exception.MyException;
import com.xxb.model.entity.*;
import com.xxb.model.enums.DeleteFlag;
import com.xxb.model.enums.LogOperation;
import com.xxb.model.enums.SuccessFlag;
import com.xxb.model.enums.UseStatus;
import com.xxb.model.mapper.UsersMapper;
import com.xxb.model.service.*;
import com.xxb.utils.DtoUtil;
import com.xxb.utils.JwtUtil;
import com.xxb.utils.MD5Util;
import com.xxb.web.dto.LoginDto;
import com.xxb.web.dto.UserExportDto;
import com.xxb.web.dto.UserListDto;
import com.xxb.web.dto.UsersDto;
import com.xxb.web.param.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private ILoginLogService loginLogService;

    /**
     * 注册用户
     *
     * @param usersDto 注册用户的参数
     * @return
     */

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean register(UsersDto usersDto) {
        //添加用户
        Users user = DtoUtil.convertObject(usersDto, Users.class);
        user.setCreateTime(new Date());
        user.setSalt(getRandomString(4));
        user.setUserPassword(MD5Util.getMD5ofStr(user.getUserPassword() + user.getSalt()));
        user.setDeleteFlag(DeleteFlag.未删除.getVal());
        baseMapper.insert(user);

        //添加用户角色关系
        userRoleService.insertUserRole(user.getId(), usersDto.getUserRole());

        //发送短信、邮件--2018/7/23 15:15 删

        return true;
    }

    /**
     * 用户登录
     *
     * @param param 登录参数
     * @return
     */
    @Override
    public LoginDto login(LoginParam param) {
        //验证密码
        Users users = checkPassword(param.getUserName(), param.getUserPassword());
        if (users == null) {
            return null;
        }

        //获取之前的token，如果有
        String  token = JwtUtil.generateToken(users.getId(),users.getLoginTime());
        System.out.println(users.getLoginTime());
        System.out.println(token);
        //删除之前的
        LoginDto loginDto = (LoginDto) redisTemplate.opsForValue().get(token);
        if (loginDto != null) {
            redisTemplate.delete(token);
        }
        //新的登录时间
        Date date = new Date();
        users.setLoginTime(date);
        //新的token
        token = JwtUtil.generateToken(users.getId(),users.getLoginTime());
        //修改最近登录时间
        baseMapper.updateById(users);

        loginDto = new LoginDto();

        //获取角色
        List<Role> roles = roleService.getByUid(users.getId());
        loginDto.setRoles(roles);
        //获取权限
        if (roles != null) {
            List<Menu> menus = menuService.findByRids(roles.stream().map(Role::getId).collect(Collectors.toList()));
            loginDto.setPerms(menus.stream().map(Menu::getCode).collect(Collectors.toList()));
        }
        //用户
        users.setUserPassword(null);
        users.setSalt(null);
        loginDto.setUsers(users);
        //新token生成
        loginDto.setToken(token);

        //写入登陆信息
        LoginLog loginLog = new LoginLog();
        loginLog.setLogName(LogOperation.登录.getVal());
        loginLog.setCreateTime(users.getLoginTime());
        loginLog.setUserId(users.getId());
        loginLog.setIp(param.getIp());
        loginLog.setSuccessFlag(SuccessFlag.成功.getVal());
        loginLogService.insert(loginLog);
        return loginDto;
    }

    /**
     * 修改密码
     *
     * @param param 修改密码的参数
     * @return
     */
    @Override
    public boolean changePassword(ChangePasswordParam param) {

        //检测密码是否正确
        Users users = checkPassword(param.getUserName(), param.getUserPassword());
        if (users == null) {
            return false;
        }
        //修改密码
        Users newUser = new Users();
        newUser.setId(users.getId());
        newUser.setSalt(getRandomString(4));
        newUser.setUserPassword(MD5Util.getMD5ofStr(param.getUserNewPassword() + newUser.getSalt()));
        baseMapper.updateById(newUser);
        return true;
    }

    private Users checkPassword(String userName, String userPassword) {
        Users users = new Users();
        users.setUserName(userName);
        users = baseMapper.selectOne(users);

        if (users == null) {
            //账号错误
            return null;
        }
        if (users.getStatus() != UseStatus.启用.getVal()) {
            //账号未启用
            return null;
        }
        if (users.getDeleteFlag() != DeleteFlag.未删除.getVal()) {
            //账号已删除
            return null;
        }
        if (!StringUtils.equalsIgnoreCase(MD5Util.getMD5ofStr(userPassword + users.getSalt()), users.getUserPassword())) {
            //密码错误
            System.out.println(MD5Util.getMD5ofStr(userPassword + users.getSalt()));
            System.out.println(users.getUserPassword());
            return null;
        }
        return users;
    }

    /**
     * 分页条件获取用户信息
     *
     * @param page  分页参数
     * @param param 查询参数
     * @return
     */
    @Override
    public List<UserListDto> getUserList(Page page, UserListParam param) {
        //条件查询
        List<UserListDto> userlist = baseMapper.getUserList(page, param);
        //获取角色权限
        for (UserListDto u : userlist) {
            u.setRoleIdName(roleService.getRoleByUid(u.getId()));
        }
        return userlist;
    }

    /**
     * 根据id查找用户
     *
     * @param id 用户id
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public UserIoParam getById(Integer id) {
        UserIoParam user = baseMapper.getById(id);
        if (user != null) {
            List<Role> roles = roleService.getByUid(user.getId());
            user.setRoles(roles);
            return user;
        } else {
            return null;
        }
    }

    /**
     * 更新用户信息
     *
     * @param userIoParam 用户信息
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public boolean updateUser(UserIoParam userIoParam) {
        //更新用户信息
        Users newUser = new Users();
        newUser = DtoUtil.convertObject(userIoParam, Users.class);
        //判断是否更密码
        if ((newUser.getUserPassword() != null) && (!newUser.getUserPassword().equals(""))) {
            newUser.setUserPassword(null);
        }
        baseMapper.updateById(newUser);
        //更新用户角色关系
        //删除
        Wrapper<UserRole> ew = new EntityWrapper<UserRole>();
        ew.eq("uid", newUser.getId());
        userRoleService.delete(ew);
        //新增
        userRoleService.insertUserRole(newUser.getId(), userIoParam.getUserRole());
        return true;
    }

    /**
     * 重置密码
     *
     * @param id id
     * @return
     */
    @Override
    public boolean resetPassword(Integer id) {
        if (id == null && id <= 0) {
            throw new MyException("id不正确");
        }
        Users user = new Users();
        user.setId(id);
        user.setSalt(getRandomString(4));
        user.setUserPassword(MD5Util.getMD5ofStr(MD5Util.getMD5ofStr("123456") + user.getSalt()));
        baseMapper.updateById(user);

        return true;
    }

    /**
     * 修改角色状态
     *
     * @param operate 操作 0禁用，1启用，2删除
     * @param ids     修改的ids
     * @return
     */
    @Override
    public boolean changeStatus(String operate, String ids) {
        baseMapper.changeStatus(operate, ids);
        //删除关系
        if(operate.equals("2")){
            //删除

            userRoleService.deleteUR(ids);
        }
        return true;
    }

    /**
     * 导出user资料
     *
     * @param param 参数
     * @return
     */
    @Override
    public void exportUsers(ExportParam param) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        //查找数据
        List<UserExportDto> list = baseMapper.getExportUserList(param.getIds(), param);
        //获取角色权限
        if (list == null || list.size() == 0) {
            return;
        }
        for (UserExportDto u : list) {
            List<Role> roles = roleService.getByUid(u.getId());
            u.setRoleName(roles.stream().map(Role::getName).collect(Collectors.toList()));
        }
        //添加列名
        List<String> colName = new ArrayList<>();
        colName.add("ID");
        colName.add("姓名");
        colName.add("用户名");
        colName.add("所属小组");
        colName.add("职位");
        colName.add("电话号码");
        colName.add("QQ邮箱");
        colName.add("权限");
        colName.add("创建时间");
        colName.add("最近登录时间");
        colName.add("访问次数");
        colName.add("状态");


        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("用户表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);// 创建一个居中格式

        //添加列名
        HSSFCell cell = row.createCell((short) 0);
        for (int i = 0; i < colName.size(); i++) {
            if (i != 0) {
                cell = row.createCell((short) i);
            }
            cell.setCellValue(colName.get(i));
            cell.setCellStyle(style);
        }

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            UserExportDto user = (UserExportDto) list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell((short) 0).setCellValue(user.getId());
            row.createCell((short) 1).setCellValue(user.getName());
            row.createCell((short) 2).setCellValue(user.getUserName());
            row.createCell((short) 3).setCellValue(user.getGroup());
            row.createCell((short) 4).setCellValue(user.getPost());
            row.createCell((short) 5).setCellValue(user.getTelephone());
            row.createCell((short) 6).setCellValue(user.getQqEmail());

            List<String> roles = user.getRoleName();
            String role = "";
            int j = 0;
            for (String r : roles) {
                if (j == 0) {
                    role = r;
                } else {
                    role = role + "," + r;
                }
                j++;
            }
            row.createCell((short) 7).setCellValue(role);
            //System.out.println(sdf.format(user.getCreateTime()));
            row.createCell((short) 8).setCellValue(sdf.format(user.getCreateTime()));
            if(user.getLoginTime() == null){
                row.createCell((short) 9).setCellValue("");
            }else{
                row.createCell((short) 9).setCellValue(sdf.format(user.getLoginTime()));
            }
            row.createCell((short) 10).setCellValue(user.getNumLogin());
            row.createCell((short) 11).setCellValue(user.getStatus());
        }
        // 第六步，将文件存到指定位置
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            String fileName = "用户表.xls";// 文件名
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    /**
     * 获取盐
     *
     * @param length 长度
     * @return
     */
    private static String getRandomString(int length) {
        return getRandomString(length, "abcdefghijklmnopqrstuvwxyz1234567890");
    }

    /**
     * 获取盐
     *
     * @param length 长度
     * @param base   基本字符
     * @return
     */
    public static String getRandomString(int length, String base) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }


//    @Override
//    public Users selectUserById(Integer id) {
//        return baseMapper.selectById(id);
//    }
}
