package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.model.entity.AdviceProgress;
import com.xxb.model.entity.Users;
import com.xxb.model.enums.AdviceDescriptionEnum;
import com.xxb.model.mapper.AdviceProgressMapper;
import com.xxb.model.service.IAdviceProgressService;
import com.xxb.web.dto.AdviceProcessDescription;
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
public class AdviceProgressServiceImpl extends ServiceImpl<AdviceProgressMapper, AdviceProgress> implements IAdviceProgressService {

    @Override
    public List<AdviceProgress> query(Pagination page) {
        return baseMapper.query(page);
    }

    /**
     * 根据反馈Id和状态查询反馈信息
     * @param adviceId 反馈Id
     * @param status 反馈进度状态
     */
    @Override
    public AdviceProcessDescription getAdviceByIdAndStatus(Integer adviceId, Integer status) {
        List<String> descriptions = this.getDescriptions(adviceId, status);
        AdviceProcessDescription apd = new AdviceProcessDescription();
        apd.setAdviceDescription(descriptions);
        apd.setStatus(status);
        apd.setAdviceId(adviceId);
        return apd;
    }

    /**
     *查询不同状态的反馈信息
     * @param adviceId 反馈Id
     * @param status 反馈进度状态
     */
    @Override
    public List<String> getDescriptions(Integer adviceId, Integer status){
        List<String> descriptions=baseMapper.getAdviceByIdAndStatus(adviceId,status);
        return descriptions;
    }

    /**
     *查询不同状态的反馈信息
     * @param adviceId 反馈Id
     */
    @Override
    public Users getUserByAdvice(Integer adviceId) {
        return baseMapper.getUserByAdvice(adviceId, AdviceDescriptionEnum.已解决.getCode());
    }

    @Override
    public Integer updateDeleteFlagById(Integer adviceId) {
        return baseMapper.updateDeleteFlagById(adviceId);
    }

    @Override
    public Integer updateDeleteFalegStatus(List<Integer> ids) {
        return baseMapper.updateDeleteFalegStatus(ids);
    }

}
