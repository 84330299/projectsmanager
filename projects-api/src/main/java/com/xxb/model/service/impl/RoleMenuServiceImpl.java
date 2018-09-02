package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.xxb.model.entity.RoleMenu;
import com.xxb.model.mapper.RoleMenuMapper;
import com.xxb.model.service.IRoleMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    /**
     * 批量插入角色菜单关系
     * @param rid 角色id
     * @param mids 菜单ids
     * @return
     */
    @Override
    public Integer insertRoleMenu(Integer rid,List<Integer> mids){
        return baseMapper.insertRoleMenu(rid,mids);
    }


    /**
     * 更新关系
     * @param rid role id
     * @param mids 菜单ids
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public boolean updateRoleMenu(Integer rid, List<Integer> mids) {
        //删除关系
        Wrapper<RoleMenu> ew = new EntityWrapper<RoleMenu>();
        ew.eq("rid",rid);
        baseMapper.delete(ew);
        //新建关系
        if(mids != null){
            insertRoleMenu(rid,mids);
        }
        return true;
    }
}
