package com.xxb.model.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.Users;
import com.xxb.web.dto.LoginDto;
import com.xxb.web.dto.UserListDto;
import com.xxb.web.dto.UsersDto;
import com.xxb.web.param.*;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IUsersService extends IService<Users> {

    /**
     * 注册用户
     *
     * @param usersDto 注册用户的参数
     * @return
     */
    boolean register(UsersDto usersDto);

    /**
     * 用户登录
     *
     * @param param 登录参数
     * @return
     */
    LoginDto login(LoginParam param);

    /**
     * 修改角色状态
     *
     * @param operate 操作 0禁用，1启用，2删除
     * @param ids     修改的ids
     * @return
     */
    boolean changeStatus(String operate, String ids);

    /**
     * 修改密码
     *
     * @param param 修改密码的参数
     * @return
     */
    boolean changePassword(ChangePasswordParam param);

    /**
     * 分页条件获取用户信息
     *
     * @param page  分页参数
     * @param param 查询参数
     * @return
     */
    List<UserListDto> getUserList(Page page, UserListParam param);

    /**
     * 根据id查找用户
     *
     * @param id 用户id
     * @return
     */
    UserIoParam getById(Integer id);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return
     */
    boolean updateUser(UserIoParam user);

    /**
     * 重置密码
     *
     * @param id id
     * @return
     */
    boolean resetPassword(Integer id);

    /**
     * 导出user资料
     *
     * @param param 参数
     * @return
     */
    void exportUsers(ExportParam param);

    //Users selectUserById(Integer id);
}
