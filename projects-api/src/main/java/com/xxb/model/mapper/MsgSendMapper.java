package com.xxb.model.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xxb.model.entity.MsgSend;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xxb.web.dto.MsgListDto;
import com.xxb.web.param.MsgListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-09
 */
public interface MsgSendMapper extends BaseMapper<MsgSend> {

    List<MsgSend> queryByPage(Page<MsgSend> page);

    List<MsgListDto> selectMsgList(Pagination page, @Param("param") MsgListParam param);
}
