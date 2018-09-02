package com.xxb.model.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xxb.model.entity.Dict;
import com.xxb.web.dto.ItemDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface DictMapper extends BaseMapper<Dict> {

    /**
     * 查询分组列表/职位列表
     *
     * @param type 类型
     * @return
     */
    List<ItemDto> getGroupOrPost(@Param("type") Integer type);

    /**
     * 批量更新
     * @param ids ids
     * @return
     */
    Integer deleteDict(@Param("list") List<Integer> ids);
}
