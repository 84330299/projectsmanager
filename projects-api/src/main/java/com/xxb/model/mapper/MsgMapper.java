package com.xxb.model.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.model.entity.Msg;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-09
 */
public interface MsgMapper extends BaseMapper<Msg> {

    List<Msg> query(Page<Msg> page);
}
