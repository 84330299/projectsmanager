package com.xxb.model.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xxb.model.entity.Role;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.web.dto.ItemDto;
import com.xxb.web.dto.RoleDownDto;
import com.xxb.web.dto.RoleDto;
import com.xxb.web.param.RoleParam;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IRoleService extends IService<Role> {
    /**
     * 获取角色下拉列表
     */
    List<RoleDownDto> getRoleDown();


    /**
     * 修改角色状态
     * @param operate 操作 0禁用，1启用，2删除
     * @param rids 修改的ids
     * @return
     */
    boolean changeStatus(String operate,String rids);


    /**
     * 获取用户下的角色
     * @param uid 用户id
     * @return
     */
    List<Role> getByUid(Integer uid);

    /**
     * 获取用户下的角色
     * @param uid 用户id
     * @return
     */
    List<ItemDto> getRoleByUid(Integer uid);


}
