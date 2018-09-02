package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xxb.model.entity.LoginLog;
import com.xxb.model.mapper.LoginLogMapper;
import com.xxb.model.service.ILoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

    @Override
    public List<LoginLog> query(Pagination page) {
        return baseMapper.query(page);
    }
}
