package com.xxb.model.mapper;

import com.xxb.model.entity.BugCollection;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xxb.web.dto.BugCollectionDto;
import com.xxb.web.dto.BugViewDto;
import com.xxb.web.param.BugConditionParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * BUG收集 Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-12
 */
public interface BugCollectionMapper extends BaseMapper<BugCollection> {


    List<BugCollectionDto> selectAll();

    List<BugCollectionDto> selectByFlag(Integer status);

    List<BugCollectionDto> selectMe(@Param("type") Integer type,
                                    @Param("uid") Integer uid);

    List<BugCollectionDto> selectByCondition(@Param("bugCondition") BugConditionParam bugCondition);

    BugViewDto view(Integer id);

    Integer insertBug(@Param("param") BugCollection param);


}
