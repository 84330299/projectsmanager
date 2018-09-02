package com.xxb.model.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.model.entity.Msg;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-09
 */
public interface IMsgService extends IService<Msg> {

    List<Msg> query(Page<Msg> page);

}
