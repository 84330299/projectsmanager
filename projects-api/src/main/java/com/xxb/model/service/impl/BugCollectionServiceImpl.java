package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.model.entity.BugCollection;
import com.xxb.model.entity.BugOperation;
import com.xxb.model.enums.BugFlag;
import com.xxb.model.enums.BugOperate;
import com.xxb.model.mapper.BugCollectionMapper;
import com.xxb.model.mapper.BugOperationMapper;
import com.xxb.model.service.IBugCollectionService;
import com.xxb.utils.DtoUtil;
import com.xxb.web.dto.BugCollectionDto;
import com.xxb.web.dto.BugViewDto;
import com.xxb.web.param.BugAppointParam;
import com.xxb.web.param.BugCollectionParam;
import com.xxb.web.param.BugCollectionSolveParam;
import com.xxb.web.param.BugConditionParam;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * BUG收搜集 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-12
 */
@Service
public class BugCollectionServiceImpl extends ServiceImpl<BugCollectionMapper, BugCollection> implements IBugCollectionService {

    @Resource
    private BugCollectionMapper bugCollectionMapper;
    @Resource
    private BugOperationMapper bugOperationMapper;

    @Override
    public boolean insertBug(BugCollectionParam bugCollectionParam, Integer createPerson) {
        //断言必填项参数非空
        Assert.isTrue(bugCollectionParam.getBugDescribe().length() > 30, "BUG标题不足三十字!");
        Assert.notNull(bugCollectionParam.getAppName(), "所属产品不能为空!");
        Assert.notNull(bugCollectionParam.getAppointPerson(), "指派人不能位空!");
        Assert.notNull(bugCollectionParam.getAppVersion(), "运用版本不能为空!");
        Assert.notNull(bugCollectionParam.getBugDescribe(), "BUG描述不能为空!");
        Assert.notNull(bugCollectionParam.getDeadline(), "截止日期不能位空!");
        Assert.notNull(bugCollectionParam.getPhoneModel(), "手机型号不能为空!");
        Assert.notNull(bugCollectionParam.getOsType(), "系统类型不能为空!");
        Assert.notNull(bugCollectionParam.getUrgency(), "优先级不能为空!");
        BugCollection entity = new BugCollection();
        entity = DtoUtil.convertObject(bugCollectionParam, BugCollection.class);
        entity.setCreateTime(new Date());
        entity.setCreatePerson(createPerson);
        boolean flag = bugCollectionMapper.insertBug(entity) > 0;
        bugOperationMapper.insert(new BugOperation(entity.getId(), createPerson, BugOperate.创建.getCode(), new Date()));
        return flag;
    }

    @Override
    public boolean solveOrDelay(BugCollectionSolveParam param) {
        Assert.notNull(param.getId(), "id不为空!");
        Assert.notNull(param.getTxt(), "解决方案/暂缓原因不为空!");
        Assert.notNull(param.getOperateType(), "操作类型未设置!");
        Assert.notNull(param.getUid(), "操作类型未成功获取!");
        if (param.getOperateType() == BugOperate.暂缓.getCode()) {
            BugCollection entity = new BugCollection();
            entity.setId(param.getId());
            entity.setStatus(BugFlag.已暂缓.getCode());
            BugOperation operationEntity = new BugOperation(param.getId(), param.getUid(), BugOperate.暂缓.getCode(), param.getTxt(), param.getDate());
            bugOperationMapper.insert(operationEntity);
            return bugCollectionMapper.updateById(entity) > 0;
        } else if (param.getOperateType() == BugOperate.解决.getCode()) {
            BugCollection entity = new BugCollection();
            entity.setId(param.getId());
            entity.setStatus(BugFlag.已解决.getCode());
            entity.setSolution(param.getTxt());
            entity.setSolveTime(param.getDate());
            entity.setSolvePerson(param.getUid());
            BugOperation operationEntity = new BugOperation(param.getId(), param.getUid(), BugOperate.解决.getCode(), param.getTxt(), param.getDate());
            bugOperationMapper.insert(operationEntity);
            return bugCollectionMapper.updateById(entity) > 0;
        } else {
            return false;
        }

    }

    @Override
    public boolean appoint(BugAppointParam param) {
        BugCollection entity = new BugCollection();
        entity.setId(param.getId());
        entity.setAppointPerson(param.getAppointPerson());
        boolean flag = bugCollectionMapper.updateById(entity) > 0;
        if (flag) {
            BugOperation operationEntity = new BugOperation(param.getId(), param.getAssignId(), BugOperate.指派.getCode(), param.getAppointPerson(), param.getAppointRemark(), new Date());
            bugOperationMapper.insert(operationEntity);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public List<BugCollectionDto> selectAll() {
        return bugCollectionMapper.selectAll();


    }

    @Override
    public List<BugCollectionDto> selectByFlag(Integer status) {
        return bugCollectionMapper.selectByFlag(status);
    }

    @Override
    public List<BugCollectionDto> selectMe(Integer type, Integer uid) {
        return bugCollectionMapper.selectMe(type, uid);
    }

    @Override
    public List<BugCollectionDto> selectByCondition(BugConditionParam param) {
        return bugCollectionMapper.selectByCondition(param);
    }

    @Override
    public BugViewDto view(Integer id) {
        BugViewDto entity = DtoUtil.convertObject(bugCollectionMapper.view(id), BugViewDto.class);
        entity.setBugOperationDtos(bugOperationMapper.view(id));
        return entity;
    }

    @Override
    public boolean active(Integer id, Integer uid) {
        BugCollection entity = bugCollectionMapper.selectById(id);
        if (entity.getStatus() == BugFlag.已暂缓.getCode() || entity.getStatus() == BugFlag.已解决.getCode()) {
            BugCollection bugCollection = new BugCollection();
            bugCollection.setId(id);
            bugCollection.setStatus(BugFlag.未解决.getCode());
            bugCollection.setActiveFlag(1);
            BugOperation operationEntity = new BugOperation(id, uid, BugOperate.激活.getCode(), new Date());
            bugOperationMapper.insert(operationEntity);
            return bugCollectionMapper.updateById(bugCollection) > 0;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCreateByMe(Integer createPerson, Integer id) {
        BugCollection entity = bugCollectionMapper.selectById(id);
        //由本人创建
        if (entity.getCreatePerson().equals(createPerson)) {
            Date start = entity.getCreateTime();
            Date now = new Date();
            //时间在五分钟以内
            if (ChronoUnit.MINUTES.between(start.toInstant(), now.toInstant()) < 5) {
                return bugCollectionMapper.deleteById(id) > 0;
            } else {
                return false;
            }
        }
        return false;
    }



}
