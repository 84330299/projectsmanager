package com.xxb.model.mapper;

import com.xxb.model.entity.UserRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    /**
     * 根据角色id找到用户的手机号
     * @param ids
     * @return
     */
    List<String> findUsersPhone(@Param("ids") List<Integer> ids);
    /**
     * 批量插入用户角色关系
     * @param uid 用户id
     * @param rids 角色id
     * @return
     */
    Integer insertUserRole(@Param("uid") Integer uid,
                           @Param("list") List<Integer> rids);


    /**
     * 根据用户id批量删除用户角色关系
     * @param uids 用户id
     * @return
     */
    Integer deleteUR(@Param("uids")String uids);

    /**
     * 根据角色id获取
     * @param rids 角色id
     * @return
     */
    List<UserRole> selectByRids(@Param("rids")String rids);
}
