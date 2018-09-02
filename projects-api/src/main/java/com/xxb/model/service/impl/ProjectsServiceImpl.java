package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.model.entity.Projects;
import com.xxb.model.entity.Users;
import com.xxb.model.mapper.ProjectsMapper;
import com.xxb.model.service.IProjectsService;
import com.xxb.model.service.IUsersService;
import com.xxb.web.dto.ProjectsDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class ProjectsServiceImpl extends ServiceImpl<ProjectsMapper, Projects> implements IProjectsService {
    @Autowired
    private IUsersService iUsersService;
    @Override
    public Projects selectProjectById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public ProjectsDetailDto getDetail(Projects projects) {
        ProjectsDetailDto pdd = new ProjectsDetailDto();
        //查询产品负责人名字
        Users product_principal = findUsersByPrincipalId("id", projects.getProductPrincipalId());
        if (product_principal != null) {
            pdd.setProductPrincipalName(product_principal.getName());
        }
        //查询项目负责人名字
        Users project_principal = findUsersByPrincipalId("id", projects.getProjectPrincipalId());
        if (project_principal != null) {
            pdd.setProjectPrincipalName(project_principal.getName());
        }
        //查询测试负责人名字
        Users test_principal = findUsersByPrincipalId("id", projects.getTestPrincipalId());
        if (test_principal != null) {
            pdd.setTestPrincipalName(test_principal.getName());
        }
        //查询研发负责人名字
        Users research_principal = findUsersByPrincipalId("id", projects.getResearchPrincipalId());
        if (research_principal != null) {
            pdd.setResearchPrincipalName(research_principal.getName());
        }
        pdd.setProductPrototype(projects.getProductPrototype());
        pdd.setProductDescription(projects.getProductDescription());
        pdd.setProductName(projects.getProductName());
        pdd.setVersion(projects.getVersion());
        return pdd;
    }

    @Override
    public Projects selectByProjectNameAndVersion(String projectName, String version) {
        Projects projects = new Projects();
        projects.setProductName(projectName);
        projects.setVersion(version);
        projects.setDeleteFlag(0);
        return baseMapper.selectOne(projects);
    }

    //根据负责人id查询人物对应信息
    private Users findUsersByPrincipalId(String column, Object object) {
        Wrapper<Users> usersEntityWrapper = new EntityWrapper<>();
        usersEntityWrapper.eq(column, object);
        Users users = iUsersService.selectOne(usersEntityWrapper);
        return users;
    }

}
