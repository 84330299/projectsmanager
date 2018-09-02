package com.xxb.model.service.impl;

import com.xxb.model.entity.Logs;
import com.xxb.model.mapper.LogsMapper;
import com.xxb.model.service.ILogsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-11
 */
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements ILogsService {

}
