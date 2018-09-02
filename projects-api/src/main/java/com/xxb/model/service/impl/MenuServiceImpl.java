package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.model.entity.Menu;
import com.xxb.model.enums.UseStatus;
import com.xxb.model.mapper.MenuMapper;
import com.xxb.model.service.IMenuService;
import com.xxb.utils.DtoUtil;
import com.xxb.web.dto.MenuDto;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    /**
     * 根据角色获取菜单权限
     *
     * @param rids
     * @return
     */
    @Override
    public List<Menu> findByRids(List<Integer> rids) {
        String key = rids == null ? "-2" : ArrayUtils.toString(rids.toArray(), "0");
        //先从缓存中取
        // List<Menu> menus = redis.hgetList(MENU_KEY, key, Menu.class);
        List<Menu> menus = new ArrayList<>();
        //if (menus.size() == 0) {
        menus = baseMapper.findByRids(null, rids);
        //存入缓存
        //redis.hset(MENU_KEY, key, menus);
        //}
        return menus;

    }

    /**
     * 获取菜单树
     *
     * @return
     */
    @Override
    public List<MenuDto> getMenuTree() {
        Wrapper<Menu> ew = new EntityWrapper<Menu>().eq("ismenu", 1).orderBy("num", true);
        List<Menu> menus = baseMapper.selectList(ew);
        List<MenuDto> menuts = new ArrayList<MenuDto>();
        for (Menu menu : menus) {
            menuts.add(DtoUtil.convertObject(menu, MenuDto.class));
        }
        List<MenuDto> resultmt = findChildren(0, menuts);
        System.out.println();
        return resultmt;
    }

    //根据
    private List<MenuDto> findChildren(Integer pid, List<MenuDto> menuDtos) {
        List<MenuDto> resultDtos = new ArrayList<MenuDto>();
        for (MenuDto menuDto : menuDtos) {
            if (menuDto.getPid().equals(pid)) {
                //找到孩子，继续找孩子
                menuDto.setChildrenMenu(findChildren(menuDto.getId(), menuDtos));
                resultDtos.add(menuDto);
            }
        }

        return resultDtos;
    }

    /**
     * 禁用/启用
     *
     * @param id   禁用启用id
     * @param flag 禁用还是启用
     * @return
     */
    @Override
    public boolean updateMenus(Integer id, Integer flag) {
        Menu menu = new Menu();
        menu.setId(id);
        menu = baseMapper.selectOne(menu);
        if (menu == null) {
            return false;
        }
        Wrapper<Menu> ew = new EntityWrapper<>();
        if (flag == UseStatus.禁用.getVal()) {
            //禁用他自己
            Menu m = new Menu();
            m.setId(id);
            m.setStatus(flag);
            baseMapper.updateById(m);
            //查找他的子孙
            ew.eq("pid",id);
            List<Menu> list = baseMapper.selectList(ew);
            //禁用他自己以及他的子孙
            for(Menu mm : list){
                updateMenus(mm.getId(),flag);
            }
        }else{
            //启用
            //启用他自己
            Menu m = new Menu();
            m.setId(id);
            m.setStatus(flag);
            baseMapper.updateById(m);
            //启用他的父
            updateMenus(menu.getPid(),flag);
        }
        return true;
    }

}

