package com.xxb.model.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.LoginLog;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
public interface ILoginLogService extends IService<LoginLog> {

    List<LoginLog> query(Pagination page);
}
