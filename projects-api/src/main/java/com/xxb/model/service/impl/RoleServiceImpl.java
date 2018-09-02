package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.model.entity.Role;
import com.xxb.model.entity.UserRole;
import com.xxb.model.mapper.RoleMapper;
import com.xxb.model.service.IRoleService;
import com.xxb.model.service.IUserRoleService;
import com.xxb.web.dto.ItemDto;
import com.xxb.web.dto.RoleDownDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMenuServiceImpl roleMenuService;

    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public List<RoleDownDto> getRoleDown() {
        return baseMapper.getRoleDown();
    }

    /**
     * 修改角色状态
     *
     * @param operate 操作 0禁用，1启用，2删除
     * @param rids    修改的ids
     * @return
     */
    @Override
    public boolean changeStatus(String operate, String rids) {
        //根据用户id批量查找
        if (operate.equals("2")) {
            List<UserRole> list = userRoleService.selectByRids(rids);
            if (list != null && list.size() != 0) {
                return false;
            }
        }
        baseMapper.changeStatus(operate, rids);

        return true;
    }

    /**
     * 获取用户下的角色
     *
     * @param uid 用户id
     * @return
     */
    @Override
    public List<Role> getByUid(Integer uid) {
        return baseMapper.getByUid(uid);
    }


    /**
     * 获取用户下的角色
     *
     * @param uid 用户id
     * @return
     */
    @Override
    public List<ItemDto> getRoleByUid(Integer uid) {
        return baseMapper.getRoleByUid(uid);
    }
}
