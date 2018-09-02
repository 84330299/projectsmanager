package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.model.entity.MsgSend;
import com.xxb.model.entity.Users;
import com.xxb.model.mapper.MsgSendMapper;
import com.xxb.model.mapper.UserRoleMapper;
import com.xxb.model.mapper.UsersMapper;
import com.xxb.model.service.IMsgSendService;
import com.xxb.web.dto.MsgListDto;
import com.xxb.web.param.MsgListParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MsgSendServiceImpl extends ServiceImpl<MsgSendMapper, MsgSend> implements IMsgSendService {
    @Autowired
    private MsgSendMapper msgSendMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 发送信息
     * @param entity
     * @return
     */
    @Override
    public boolean insertMsg(MsgSend entity){
        baseMapper.insert(entity);
        return true;
    }

    /**
     * 根据角色id发送消息
     * @param ids 角色id
     * @param msgId 消息模板id
     * @return
     */
    @Override
    public boolean sendMsg(List<Integer> ids,Integer msgId){
      List<String> phones = userRoleMapper.findUsersPhone(ids);
        for (String phone : phones) {
            MsgSend msgSend =new MsgSend();
            msgSend.setCreateTime(new Date());
            msgSend.setMsgId(msgId);
            Users user = new Users();
            user.setTelephone(phone);
            Users userNew =usersMapper.selectOne(user);
            msgSend.setUserId(userNew.getId());
            msgSendMapper.insert(msgSend);
        }
        return true;
    }

    @Override
    public List<MsgSend> queryByPage(Page<MsgSend> page) {
        return baseMapper.queryByPage(page);
    }

    /**
     * 查询分页列表
     * @param param 分页参数
    */
    @Override
    public List<MsgListDto> selectMsgList(Pagination page, MsgListParam param) {
//        if(param!=null&&param.getRoleId()!=null){
//            //判断角色id是否为空，查询对应的用户Id
//            Wrapper<UserRole> ew=new EntityWrapper<UserRole>();
//            ew.eq("rid",param.getRoleId());
//            List<UserRole> userRoles = userRoleMapper.selectList(ew);
//            List<Integer> uses = userRoles.stream().map(e -> e.getUid()).collect(Collectors.toList());
//            param.setUids(uses);
//        }
        List<MsgListDto> msgListDtos = baseMapper.selectMsgList(page, param);
        msgListDtos.forEach(e->{
            if(e!=null && e.getSendMsg()!=null){
                if(e.getSendMsg().equals("OK")){
                    e.setSendStatus(1);
                }else{
                    e.setSendStatus(0);
                }
            }
        });
        return msgListDtos;
    }

}
