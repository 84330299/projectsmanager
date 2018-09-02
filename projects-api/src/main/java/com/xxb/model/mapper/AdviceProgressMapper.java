package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xxb.model.entity.AdviceProgress;
import com.xxb.model.entity.Users;
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
public interface AdviceProgressMapper extends BaseMapper<AdviceProgress> {

    List<AdviceProgress> query(Pagination page);

    List<String> getAdviceByIdAndStatus(@Param("adviceId") Integer adviceId,@Param("status") Integer status);

    Users getUserByAdvice(@Param("adviceId") Integer adviceId,@Param("status") Integer code);

    Integer updateDeleteFlagById(@Param("adviceId") Integer adviceId);

    void updStatus(@Param("adviceStatus") Integer status,@Param("adviceId") Integer adviceId);

    Integer updateDeleteFalegStatus(@Param("ids") List<Integer> ids);
}
