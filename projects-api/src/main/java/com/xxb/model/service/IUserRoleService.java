package com.xxb.model.service;

import com.xxb.model.entity.UserRole;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.Users;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 根据角色id查找对应的用户对象
     * @param ids 角色id
    */
    List<Users> getUsersByRole(String[] ids);

    /**
     * 批量插入用户角色关系
     * @param uid 用户id
     * @param rids 角色ids
     * @return
     */
    Integer insertUserRole(Integer uid,List<Integer> rids);

    /**
     * 更新用户角色关系，先删除再添加
     * @param uid 用户id
     * @param rids 角色id
     * @return
     */
    boolean updateUserRole(Integer uid,List<Integer> rids);

    /**
     * 根据用户id批量删除用户角色关系
     * @param ids 用户id
     * @return
     */
    boolean deleteUR(String ids);

    /**
     * 根据角色id查找用户角色关系
     * @param rids 角色id
     * @return
     */
    List<UserRole> selectByRids(String rids);
}
