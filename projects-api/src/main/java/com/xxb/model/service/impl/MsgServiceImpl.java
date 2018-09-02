package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.model.entity.Msg;
import com.xxb.model.mapper.MsgMapper;
import com.xxb.model.service.IMsgService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-09
 */
@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, Msg> implements IMsgService {

    @Override
    public List<Msg> query(Page<Msg> page) {
        return baseMapper.query(page);
    }
}
