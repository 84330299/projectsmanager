package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xxb.model.entity.Role;
import com.xxb.web.dto.ItemDto;
import com.xxb.web.dto.RoleDownDto;
import com.xxb.web.dto.RoleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 获取角色下拉列表
     *
     * @return
     */
    List<RoleDownDto> getRoleDown();


    /**
     * 获取角色列表
     *
     * @return
     */
    List<RoleDto> selectRoleDtoList();

    /**
     * 获取用户下的角色
     *
     * @param uid 用户id
     * @return
     */
    List<Role> getByUid(@Param("uid") Integer uid);

    /**
     * 批量修改状态
     *
     * @param operate 操作 操作 0禁用，1启用，2删除
     * @param uids    用户ids串
     * @return
     */
    boolean changeStatus(@Param("operate") String operate, @Param("uids") String uids);

    /**
     * 获取用户下的角色
     *
     * @param uid 用户id
     * @return
     */
    List<ItemDto> getRoleByUid(Integer uid);


}
