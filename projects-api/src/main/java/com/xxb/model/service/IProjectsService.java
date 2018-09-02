package com.xxb.model.service;

import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.Projects;
import com.xxb.web.dto.ProjectsDetailDto;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IProjectsService extends IService<Projects> {

    /**
     * 项目Id
     *
     * @param id
     */
    Projects selectProjectById(Integer id);

    /**
     * 获取项目的详情信息
     *
     * @param projects 项目信息
     */
    ProjectsDetailDto getDetail(Projects projects);

    /**
     * 根据项目名和版本号查询项目信息
     * @param projectName 项目名
     * @param version 版本号
    */
    Projects selectByProjectNameAndVersion(String projectName ,String version);

}
