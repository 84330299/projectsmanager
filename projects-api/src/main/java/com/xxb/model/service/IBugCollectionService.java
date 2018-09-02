package com.xxb.model.service;

import com.xxb.model.entity.BugCollection;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.web.dto.BugCollectionDto;
import com.xxb.web.dto.BugViewDto;
import com.xxb.web.param.BugAppointParam;
import com.xxb.web.param.BugCollectionParam;
import com.xxb.web.param.BugCollectionSolveParam;
import com.xxb.web.param.BugConditionParam;

import java.util.List;

/**
 * <p>
 * BUG搜集 服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-12
 */
public interface IBugCollectionService extends IService<BugCollection> {
    /**
     * 新建BUG
     *
     * @param bugCollectionParam 创建BUG的传入参数
     * @return 是否创建成功
     */
    boolean insertBug(BugCollectionParam bugCollectionParam, Integer createPerson);

    /**
     * 暂缓或者解决BUG
     *
     * @param bugCollectionSolveParam 暂缓或解决参数
     * @return 是否修改成功
     */
    boolean solveOrDelay(BugCollectionSolveParam bugCollectionSolveParam);

    /**
     * 指派BUG
     *
     * @param appointParam 指派参数
     * @return 是否修改成功
     */
    boolean appoint(BugAppointParam appointParam);

    /**
     * 查全部BUG
     *
     * @return 全部BUG列表
     */
    List<BugCollectionDto> selectAll();

    /**
     * 按当前的状态查询
     *
     * @param status 状态
     * @return BUG列表
     */
    List<BugCollectionDto> selectByFlag(Integer status);

    /**
     * 查询与我相关BUG列表
     *
     * @param type 角色类型
     * @return BUG列表
     */
    List<BugCollectionDto> selectMe(Integer type, Integer uid);

    /**
     * 条件查询BUG列表
     *
     * @param param 查询条件
     * @return BUG列表
     */
    List<BugCollectionDto> selectByCondition(BugConditionParam param);

    /**
     * 查看BUG
     *
     * @param id BUG的id
     * @return 查看参数
     */
    BugViewDto view(Integer id);

    /**
     * 要激活BUG的id
     *
     * @param id BUG主键
     * @return 是否激活成功
     */
    boolean active(Integer id, Integer uid);

    /**
     * 五分钟内可删除自己创建的BUG
     * @param createPerson 创建人
     * @param id BUG主键
     * @return 是否删除成功
     */
    boolean deleteCreateByMe(Integer createPerson, Integer id);
}
