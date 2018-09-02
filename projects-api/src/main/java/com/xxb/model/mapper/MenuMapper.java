package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xxb.model.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据角色id列表及父ID获取权限列表
     *
     * @param pid  父id
     * @param rids 角色id列表
     */
    List<Menu> findByRids(@Param("pid") Integer pid, @Param("rids") List<Integer> rids);

}
