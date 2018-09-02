package com.xxb.model.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.xxb.model.entity.MsgSend;
import com.xxb.web.dto.MsgListDto;
import com.xxb.web.param.MsgListParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-09
 */
public interface IMsgSendService extends IService<MsgSend> {

    boolean insertMsg(MsgSend entity);

    boolean sendMsg(List<Integer> ids,Integer msgId);

    List<MsgSend> queryByPage(Page<MsgSend> page);

    /**
     * 查询消息列表
     * @param param 分页参数
    */
    List<MsgListDto> selectMsgList(Pagination page, MsgListParam param);
}
