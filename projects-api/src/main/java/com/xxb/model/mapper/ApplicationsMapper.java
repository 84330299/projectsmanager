package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xxb.model.entity.Applications;
import com.xxb.web.dto.ApplicationManagerDto;
import com.xxb.web.dto.ProjectManagerDto;
import com.xxb.web.param.ApplicationsParam;
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
public interface ApplicationsMapper extends BaseMapper<Applications> {




    /**
     * 更新应用的状态
     * @param id 应用id
     *@param status 状态
    */
    Integer upStatus(@Param("id") Integer id,@Param("status") Integer status);

    /**
     * 增加下载量
     * @param appId 应用id
    */
    Integer updateCompleteNum(@Param("id") Integer appId);

    /**
     * 根据项目id查询应用集合
     * @param ids
    */
    List<Applications> getAppsByProjectIds(@Param("ids") List<Integer> ids);

    /**
     * 分页条件查询
     * @param page 分页参数
     * @param applicationsParam 分页条件
    */
    List<ProjectManagerDto> selectApplicationsList(Pagination page,@Param("app") ApplicationsParam applicationsParam);

    List<ApplicationManagerDto> selectExportPackage(@Param("ids") List<Integer> ids);
}
