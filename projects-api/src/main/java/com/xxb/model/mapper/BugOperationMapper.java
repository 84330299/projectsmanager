package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xxb.model.entity.BugOperation;
import com.xxb.web.dto.BugOperationDto;

import java.util.List;

/**
 * <p>
 * BUG操作流水表 Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-16
 */
public interface BugOperationMapper extends BaseMapper<BugOperation> {
    List<BugOperationDto> view(Integer id);
}
