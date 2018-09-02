package com.xxb.model.service;

import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.Menu;
import com.xxb.web.dto.MenuDto;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据角色获取菜单权限
     *
     * @param rids
     * @return
     */
    public List<Menu> findByRids(List<Integer> rids);

    /**
     * 获取菜单树
     * @return
     */
    List<MenuDto> getMenuTree();

    /**
     * 禁用/启用
     * @param id 禁用启用id
     * @param flag 禁用还是启用
     * @return
     */
    boolean updateMenus(Integer id,Integer flag);

}
