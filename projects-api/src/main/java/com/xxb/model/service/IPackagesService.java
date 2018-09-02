package com.xxb.model.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.Packages;
import com.xxb.web.dto.ApplicationDetailDto;
import com.xxb.web.dto.ApplicationManagerDto;
import com.xxb.web.dto.ConditionProjectDto;
import com.xxb.web.dto.PackageDownloadDto;
import com.xxb.web.param.CreateApplicationParam;
import com.xxb.web.param.PackageParam;

import java.util.List;

/**
 * @author 张玉
 * @Date 2018/7/17.
 */
public interface IPackagesService extends IService<Packages> {
    /**
     * 创建应用
     * @param param 创建应用参数
    */
    Integer insertPackage(CreateApplicationParam param);

    /**
     * 查看单个发包详情
     * @param id 发包记录Id
    */
    ApplicationDetailDto selectDetailPackage(Integer id);

    /**
     * 条件分页查询
     * @param page 分页参数
     * @param cpd 条件筛选查询
     */
    List<ApplicationManagerDto> selectPackageList(Pagination page, ConditionProjectDto cpd);

    /**
     *
     * @param param 校验版本是否是最新的参数
    */
    PackageDownloadDto updateCheck(PackageParam param);

    /**
     * @param param 增加下载量参数
    */
    Integer increaseDownloadNum(PackageParam param);
}
