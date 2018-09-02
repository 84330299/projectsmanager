package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.exception.Assert;
import com.xxb.model.entity.UserRole;
import com.xxb.model.entity.Users;
import com.xxb.model.mapper.UserRoleMapper;
import com.xxb.model.service.IUserRoleService;
import com.xxb.model.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {


    @Autowired
    private IUsersService iUsersService;

    /**
     * @param roleIds 角色id
    */
    @Override
    public List<Users> getUsersByRole(String[] roleIds) {
        Assert.notNull(roleIds,"id不能为空");
        Wrapper<UserRole> ew=new EntityWrapper<UserRole>();
            ew.in("rid",roleIds);
        //查询出对应的user对象
        List<UserRole> userRoles = baseMapper.selectList(ew);
        List<Users> usersList=null;
        if(userRoles!=null &&userRoles.size()>0){
            //用户的id
            List<Integer> userIds = userRoles.stream().map(e -> e.getUid()).collect(Collectors.toList());
            //根据用户id查找用户信息
            Wrapper<Users> us=new EntityWrapper<>();
            us.in("id",userIds);
            usersList = iUsersService.selectList(us);
        }
        return usersList;
    }


    /**
     * 批量插入用户角色关系
     * @param uid 用户id
     * @param rids 角色ids
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Integer insertUserRole(Integer uid, List<Integer> rids) {

        return baseMapper.insertUserRole(uid,rids);
    }

    /**
     * 更新用户角色关系，先删除再添加
     * @param uid 用户id
     * @param rids 角色id
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public boolean updateUserRole(Integer uid,List<Integer> rids) {
        Wrapper<UserRole> ew = new EntityWrapper<UserRole>().eq("uid",uid);
        baseMapper.delete(ew);
        insertUserRole(uid,rids);
        return true;
    }

    /**
     * 根据用户id批量删除用户角色关系
     * @param ids 用户id
     * @return
     */
    @Override
    public boolean deleteUR(String ids){
        baseMapper.deleteUR(ids);
        return true;
    }

    /**
     * 根据角色id查找用户角色关系
     * @param rids 角色id
     * @return
     */
    @Override
    public List<UserRole> selectByRids(String rids){

        return baseMapper.selectByRids(rids);
    }
}
