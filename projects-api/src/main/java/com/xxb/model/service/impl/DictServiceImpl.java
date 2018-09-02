package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.exception.Assert;
import com.xxb.model.entity.Dict;
import com.xxb.model.enums.DictEnum;
import com.xxb.model.mapper.DictMapper;
import com.xxb.model.service.IDictService;
import com.xxb.web.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {


    /**
     * 查询分组列表/职位列表
     *
     * @param type 类型
     * @return
     */
    @Override
    public List<ItemDto> getGroupOrPost(Integer type) {
        return baseMapper.getGroupOrPost(type);
    }

    /**
     * 批量删除
     *
     * @param ids ids
     * @return
     */
    @Override
    public boolean deleteDict(List<Integer> ids) {
        if (ids != null && ids.size() >= 0) {
            baseMapper.deleteDict(ids);
        }
        return true;
    }

    /**
     * 新增渠道名称
     * @param name 渠道名称
    */
    @Override
    public Integer insertSource(String name) {
        //判断系统是否有这个渠道
        Dict newDict = new Dict();
        newDict.setName(name);
        newDict.setType(DictEnum.应用商店.getCode().toString());
        //查询未删除的
        newDict.setDeleteFlag(1);
        Dict resultDict = baseMapper.selectOne(newDict);
        Assert.isNull(resultDict,"此渠道已存在，不能创建");
        Dict dict = new Dict();
        dict.setName(name);
        dict.setType(DictEnum.应用商店.getCode().toString());
        dict.setDeleteFlag(1);
        return baseMapper.insert(dict);
    }

    /**
     * 新增问题类型
     * @param name 名字
    */
    @Override
    public Integer insertProblemType(String name) {
        //判断系统是否有这个问题类型
        Dict newDict = new Dict();
        newDict.setName(name);
        newDict.setType(DictEnum.反馈类型.getCode().toString());
        //查询未删除的
        newDict.setDeleteFlag(1);
        Dict resultDict = baseMapper.selectOne(newDict);
        Assert.notNull(resultDict,"已存在这个问题类型，不能再次创建");
        //插入数据
        Dict dict = new Dict();
        dict.setName(name);
        dict.setType(DictEnum.反馈类型.getCode().toString());
        return baseMapper.insert(dict);
    }

}
