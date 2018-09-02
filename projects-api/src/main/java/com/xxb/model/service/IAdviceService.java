package com.xxb.model.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.Advice;
import com.xxb.web.dto.AdviceManagerDto;
import com.xxb.web.dto.AdviceStatusDescriptionDto;
import com.xxb.web.dto.AdviceTypeDto;
import com.xxb.web.dto.ConditionAdvice;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IAdviceService extends IService<Advice> {

    List<Advice> query(Pagination page);

    AdviceStatusDescriptionDto getAdvice(Integer id, Integer status);

    List<AdviceManagerDto> selectAdvices(Pagination page, ConditionAdvice conditionAdvice);

//    List<AdviceManagerDto> selectAdviceManager(Page<Advice> list);

    Integer deleteAdviceById(Integer id);

    Integer updateDeleteFalegStatus(Integer[] ids);

    void updataStatus(Integer status, Integer adviceId);

    List<AdviceTypeDto> getAdviceType(Integer code);

    Integer getAdviceCountInfo(Integer projectId,Integer systemType,Integer code);

    List<Advice> getAdvicesByProjects(Integer[] ids);
}
