package com.xxb.model.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.Applications;
import com.xxb.web.dto.ProjectManagerDto;
import com.xxb.web.param.ApplicationsParam;
import com.xxb.web.param.CreateApplicationParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IApplicationsService extends IService<Applications> {

    /**
     * @param id
    */
    Integer upDeleteFlag(Integer id);

    /**
     * @param appId 应用id
    */
    Integer updateCompleteNum(Integer appId);

    /**
     * 创建一个应用
     * @param param 应用参数
    */
    void insertApplication(CreateApplicationParam param);

    /**
     * 分页条件查询
     * @param applicationsParam 分页条件查询
     * @param page 分页参数
    */
    List<ProjectManagerDto> selectApplicationsList(Pagination page,ApplicationsParam applicationsParam);

    /**
     * 根据项目id和系统类型查询应用信息
     * @param projectId 项目id
     *@param systemType 系统类型
   */
    Applications getAppByProjectIdAndSystemType(Integer projectId,Integer systemType);

    void exportPackage(Integer[] ids);
}
