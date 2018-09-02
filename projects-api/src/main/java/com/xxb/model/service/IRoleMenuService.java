package com.xxb.model.service;

import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.RoleMenu;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IRoleMenuService extends IService<RoleMenu> {
    /**
     * 批量插入角色菜单关系
     * @param rid 角色id
     * @param mids 菜单id
     * @return
     */
    Integer insertRoleMenu(Integer rid,List<Integer> mids);

    /**
     * 更新关系
     * @param rid role id
     * @param mids 菜单ids
     * @return
     */
    boolean updateRoleMenu(Integer rid,List<Integer> mids);

}
