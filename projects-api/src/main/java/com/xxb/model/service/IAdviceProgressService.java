package com.xxb.model.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.AdviceProgress;
import com.xxb.model.entity.Users;
import com.xxb.web.dto.AdviceProcessDescription;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IAdviceProgressService extends IService<AdviceProgress> {

    List<AdviceProgress> query(Pagination page);

    /**
     * 根据反馈Id和状态查询反馈信息
     * @param adviceId 反馈Id
     * @param status 反馈进度状态
    */
    AdviceProcessDescription getAdviceByIdAndStatus(Integer adviceId, Integer status);

    /**
     *查询不同状态的反馈信息
     * @param adviceId 反馈Id
     * @param status 反馈进度状态
     */
    List<String> getDescriptions(Integer adviceId, Integer status);

    /**
     * 根据反馈id和状态为已解决的查询解决人
     * @param adviceId 反馈id
    */
    Users getUserByAdvice(Integer adviceId);

    Integer updateDeleteFlagById(Integer id);

    Integer updateDeleteFalegStatus(List<Integer> integers);
}
