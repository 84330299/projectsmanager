package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xxb.model.entity.Projects;
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
public interface ProjectsMapper extends BaseMapper<Projects> {

    Integer batchDeleteProject(@Param("ids") List<Integer> ids);

}
