package com.xxb.model.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.model.entity.Users;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xxb.model.enums.UserEnum;
import com.xxb.web.dto.UserExportDto;
import com.xxb.web.dto.UserListDto;
import com.xxb.web.param.ExportParam;
import com.xxb.web.param.UserIoParam;
import com.xxb.web.param.UserListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 条件分页查询用户列表
     * @param page 分页参数
     * @param param 参数
     * @return
     */
    List<UserListDto> getUserList(Page page,@Param("param") UserListParam param);

    /**
     * 根据id查找用户
     * @param id 用户id
     * @return
     */
    UserIoParam getById(@Param("id") Integer id);


    /**
     * 修改角色状态
     * @param operate 操作 0禁用，1启用，2删除
     * @param uids 修改的ids
     * @return
     */
    boolean changeStatus(@Param("operate") String operate,@Param("uids") String uids);

    /**
     * 导出用户信息
     * @param param 参数
     * @return
     */
    List<UserExportDto> getExportUserList(@Param("list") List<Integer> ids,@Param("param") ExportParam param);

}
