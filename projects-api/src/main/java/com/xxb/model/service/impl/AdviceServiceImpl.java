package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.exception.Assert;
import com.xxb.model.entity.Advice;
import com.xxb.model.entity.Users;
import com.xxb.model.enums.AdviceDescriptionEnum;
import com.xxb.model.mapper.AdviceMapper;
import com.xxb.model.service.*;
import com.xxb.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class AdviceServiceImpl extends ServiceImpl<AdviceMapper, Advice> implements IAdviceService {

    @Autowired
    private IAdviceProgressService iAdviceProgressService;

    @Autowired
    private IUsersService iUsersService;

    @Autowired
    private IProjectsService iProjectsService;

    @Autowired
    private IDictService iDictService;

    @Override
    public List<Advice> query(Pagination page) {
        return baseMapper.query(page);
    }

    /**
     * @param id     反馈id
     * @param status 反馈状态
     */
    @Override
    public AdviceStatusDescriptionDto getAdvice(Integer id, Integer status) {
        //查询状态为status的advice表中是否有信息
        Wrapper<Advice> ew = new EntityWrapper<Advice>();
        ew.eq("status", status).eq("id",id);
        List<Advice> adviceList = baseMapper.selectList(ew);
        //根据反馈的状态查询对应的信息
        AdviceStatusDescriptionDto asdd = null;
        if (adviceList.size() > 0) {
            asdd = baseMapper.getAdvice(id, status);
            Assert.notNull(asdd,"没有这个反馈信息");
            if (status.equals(AdviceDescriptionEnum.未解决.getCode())) {
                return asdd;
            } else {
                //查询不同状态的描述
                AdviceProcessDescription adviceByIdAndStatus = iAdviceProgressService.getAdviceByIdAndStatus(id, status);
                List<String> descriptions = adviceByIdAndStatus.getAdviceDescription();
                asdd.setStatusDescription(descriptions);
                asdd.setStatus(adviceByIdAndStatus.getStatus());
                //加入解决反馈的人
                Users user = iAdviceProgressService.getUserByAdvice(id);
                if (user != null) {
                    asdd.setResolveUserName(user.getName());
                }
            }
        }
        return asdd;
    }

//    /**
//     * 查询反馈信息
//     *
//     * @param page 分页信息
//     */
//    @Override
//    public List<AdviceManagerDto> selectAdvices(Pagination page, ConditionAdvice conditionAdvice) {
//        //根据输入的项目名查找当前对应的id
//        String projectName = conditionAdvice.getProjectName();
//        if (projectName != null && projectName != "") {
//            Wrapper<Projects> projectsEntityWrapper = new EntityWrapper<>();
//            projectsEntityWrapper.eq("product_name", projectName);
//            projectsEntityWrapper.eq("delete_flag", 0);
//            List<Projects> projects = iProjectsService.selectList(projectsEntityWrapper);
//            List<Integer> ids = projects.stream().map(e -> e.getId()).collect(Collectors.toList());
//            conditionAdvice.setIds(ids);
//        }
//        return baseMapper.selectAdvicePage(page, conditionAdvice);
//    }


    /**
     * 查询反馈信息
     *
     * @param page 分页信息
     */
    @Override
    public List<AdviceManagerDto> selectAdvices(Pagination page, ConditionAdvice conditionAdvice) {
        //根据输入的项目名查找当前对应的id
//        String projectName = conditionAdvice.getProjectName();
//        if (projectName != null && projectName != "") {
//            Wrapper<Projects> projectsEntityWrapper = new EntityWrapper<>();
//            projectsEntityWrapper.eq("product_name", projectName);
//            projectsEntityWrapper.eq("delete_flag", 0);
//            List<Projects> projects = iProjectsService.selectList(projectsEntityWrapper);
//            List<Integer> ids = projects.stream().map(e -> e.getId()).collect(Collectors.toList());
//            conditionAdvice.setIds(ids);
//        }
        return baseMapper.selectAdvicePage(page, conditionAdvice);
    }

    /**
     * 封装反馈信息数据
     *
     * @param list 分页信息
     */
//    @Override
//    public List<AdviceManagerDto> selectAdviceManager(Page<Advice> list) {
//        List<AdviceManagerDto> adviceManagerDtoList = list.getRecords().stream().map(e -> {
//            AdviceManagerDto managerDto = new AdviceManagerDto();
//            managerDto.setId(e.getId());
//            managerDto.setSystemType(e.getSystemType());
//            managerDto.setRemark(e.getRemark());
//            managerDto.setAdviceDescription(e.getAdviceDescription());
//            managerDto.setPicUrl(e.getPicUrl());
//            managerDto.setCreateTime(e.getCreateTime());
//            managerDto.setStatus(e.getStatus());
//            //反馈人
//            Users users = iUsersService.selectById(e.getUserId());
//            if (users != null) {
//                managerDto.setUserName(users.getName());
//            }
//            //项目信息
//            Projects projects = iProjectsService.selectProjectById(e.getProjectsId());
//            if (projects != null) {
//                managerDto.setProjectName(projects.getProductName());
//                managerDto.setVersion(projects.getVersion());
//            }
//            //反馈类型
//            Dict dict = iDictService.selectById(e.getProblemType());
//            if (dict != null) {
//                managerDto.setProbleType(dict.getValue());
//            }
//            //如果当前反馈进度是解决状态时需要到反馈进度表中查询
//            if (e.getStatus().equals(AdviceDescriptionEnum.已解决.getCode())) {
//                //解决人
//                Users user = iAdviceProgressService.getUserByAdvice(e.getId());
//                if (user != null) {
//                    managerDto.setResolveName(user.getName());
//                }
//                //解决方案，解决时间数据封装
//                AdviceProcessDescription apd = iAdviceProgressService.getAdviceByIdAndStatus(e.getId(), e.getStatus());
//                if (apd != null) {
//                    managerDto.setResolveDescription(apd.getAdviceDescription());
//                    managerDto.setResolveTime(e.getCreateTime());
//                }
//            }
//            return managerDto;
//        }).collect(Collectors.toList());
//        return adviceManagerDtoList;
//    }


    /**
     * 逻辑删除反馈
     *
     * @param id 反馈Id
     */
    @Override
    public Integer deleteAdviceById(Integer id) {
        //逻辑删除反馈进度表中的数据
        iAdviceProgressService.updateDeleteFlagById(id);

        //逻辑删除反馈表中的数据
        return baseMapper.updateDeleteFlagById(id);
    }

    /**
     * 批量更新删除状态
     *
     * @param ids
     */
    @Override
    public Integer updateDeleteFalegStatus(Integer[] ids) {
        //删除进度表中adviceId为ids的
        iAdviceProgressService.updateDeleteFalegStatus(Arrays.asList(ids));
        return baseMapper.updateDeleteFalegStatus(Arrays.asList(ids));
    }

    /**
     * 更新反馈状态
     *
     * @param status   反馈状态
     * @param adviceId 反馈id
     */
    @Override
    public void updataStatus(Integer status, Integer adviceId) {
        baseMapper.updataStatus(status, adviceId);
    }


    /**
     * 获取反馈类型
     */
    @Override
    public List<AdviceTypeDto> getAdviceType(Integer code) {
        return baseMapper.getAdviceType(code);
    }

    /**
     * 根据项目id和系统类型查询状态为code的反馈统计数量
     * @param projectId 项目id
     *@param  systemType 系统类型
    */
    @Override
    public Integer getAdviceCountInfo(Integer projectId, Integer systemType,Integer code) {
        Wrapper<Advice> ew = new EntityWrapper<Advice>().eq("projects_id", projectId).eq("system_type", systemType).eq(code!=null,"status", code);
        return baseMapper.selectCount(ew);
    }

    /**
     *根据项目id查找到反馈集合
     * @param projectIds 项目id
    */
    @Override
    public List<Advice> getAdvicesByProjects(Integer[] projectIds) {
        List<Advice> adviceList=baseMapper.getAdvicesByProjects(Arrays.asList(projectIds));
        return adviceList;
    }
}
