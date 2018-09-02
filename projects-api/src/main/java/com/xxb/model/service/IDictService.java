package com.xxb.model.service;

import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.Dict;
import com.xxb.web.dto.ItemDto;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface IDictService extends IService<Dict> {

    /**
     * 查询分组列表/职位列表
     * @param type 类型
     * @return
     */
    List<ItemDto> getGroupOrPost(Integer type);

    /**
     * 批量删除
     * @param ids ids
     * @return
     */
    boolean deleteDict(List<Integer> ids);

    /**
     * 新增渠道名称
     * @param name 渠道名称
    */
    Integer insertSource(String name);

    /**
     * 新增反馈问题类型
     * @param name 新增的名字
    */
    Integer insertProblemType(String name);
}
