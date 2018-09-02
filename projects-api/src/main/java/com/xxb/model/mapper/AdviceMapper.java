package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xxb.model.entity.Advice;
import com.xxb.web.dto.AdviceManagerDto;
import com.xxb.web.dto.AdviceStatusDescriptionDto;
import com.xxb.web.dto.AdviceTypeDto;
import com.xxb.web.dto.ConditionAdvice;
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
public interface AdviceMapper extends BaseMapper<Advice> {

    List<Advice> query(Pagination page);

    /**
     * 根据id和不同状态查询反馈
     * @param id 反馈id
    */
    AdviceStatusDescriptionDto getAdvice(@Param("id") Integer id,@Param("status") Integer status);

    List<AdviceManagerDto> selectAdvicePage(Pagination page, @Param("ca") ConditionAdvice conditionAdvice);

    Integer updateDeleteFlagById(@Param("id") Integer id);

    Integer updateDeleteFalegStatus(@Param("ids") List<Integer> ids);

    void updataStatus(@Param("adviceStatus") Integer status,@Param("id") Integer adviceId);

    List<AdviceTypeDto> getAdviceType(@Param("code") Integer code);

    List<Advice> getAdvicesByProjects(@Param("projectIds") List<Integer> projectIds);
}
