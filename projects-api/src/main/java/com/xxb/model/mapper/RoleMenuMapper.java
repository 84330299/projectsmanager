package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xxb.model.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 批量插入角色菜单关系
     * @param rid 角色id
     * @param mids 菜单id
     * @return
     */
    Integer insertRoleMenu(@Param("rid") Integer rid,
                           @Param("list") List<Integer> mids);

}
