package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xxb.model.entity.Packages;
import com.xxb.web.dto.ApplicationDetailDto;
import com.xxb.web.dto.ApplicationManagerDto;
import com.xxb.web.dto.ConditionProjectDto;
import com.xxb.web.dto.PackageDownloadDto;
import com.xxb.web.param.PackageParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张玉
 * @Date 2018/7/17.
 */
public interface PackagesMapper extends BaseMapper<Packages> {
    /**
     * 查询单个发包详情
     * @param id 发包记录Id
    */
    ApplicationDetailDto selectDetailPackage(@Param("id") Integer id);

    List<ApplicationManagerDto> selectPackageList(Pagination page,@Param("cpd") ConditionProjectDto cpd);

    Integer increaseDownloadNum(@Param("id") Integer id);

    /**
     * 查询最新版本号
     * @param param 查询新版本参数
    */
    PackageDownloadDto selectNewest(@Param("param") PackageParam param);

    /**
     * 查询最新包的信息
    */
    Packages selectPackageNew(@Param("param") PackageParam param);
}
