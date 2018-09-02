package com.xxb.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.xxb.dto.SmsInfo;
import com.xxb.model.entity.MsgSend;
import com.xxb.model.entity.Users;
import com.xxb.model.service.IMsgSendService;
import com.xxb.web.dto.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/9 14:50
 */
@Component
public class SmsUtil {
    private static ResultJson resultJson = new ResultJson();

    private static final String accessKeyId = "LTAIQLlnGdUrvpI9";
    private static final String accessKeySecret = "so1mhlNOSqhmCJvXIQbbAyOULwqxie";
    // 产品名称:云通信短信API产品,开发者无需替换
    private static final String product = "Dysmsapi";
    // 产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";

    @Autowired
    private IMsgSendService iMsgSendService;

    private static SmsUtil smsUtil;

    @PostConstruct
    public void init() {
        smsUtil = this;
        smsUtil.iMsgSendService = this.iMsgSendService;
    }


//    public static void main(String[] args) throws Exception {
//        SmsInfo smsInfo = new SmsInfo("陈亮", "学训宝", "5.0.1", "180000000000");
//        sendSms(smsInfo, SmsTemplate.APPLICATION_TEMPLATE);
//    }

    public static Boolean test(String phonenum, String bid, String times, IAcsClient acsClient) throws ClientException {
        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(phonenum);
        //可选-调用发送短信接口时返回的BizId
        request.setBizId(bid);
        //必填-短信发送的日期 支持30天内记录查询（可查其中一天的发送数据），格式yyyyMMdd
        request.setSendDate(times);
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);
        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
        List<QuerySendDetailsResponse.SmsSendDetailDTO> smsSendDetailDTOs = querySendDetailsResponse.getSmsSendDetailDTOs();
//        for(int i=0;i<smsSendDetailDTOs.size();i++){
//            System.out.println("执行状态码是:" +  smsSendDetailDTOs.get(i).getSendStatus()+"手机号是:"+phonenum+"流水号是"+bid);
//        }
//        Long sendStatus = smsSendDetailDTOs.get(0).getSendStatus();
        //获取返回结果
        if (querySendDetailsResponse.getSmsSendDetailDTOs() != null && querySendDetailsResponse.getSmsSendDetailDTOs().size()>0) {
            //代表请求成功
            if (querySendDetailsResponse.getSmsSendDetailDTOs().get(0).getSendStatus()==3) {
                //说明已经发送成功
                return true;
            }
        }
        return false;
    }

//    /* 发送短信
//     *
//     * @param templatecode 模板代码
//     * @param smsInfo      短信对象
//     **/
//    public static ResultJson sendSms(List<SmsInfo> smsInfos, String templatecode,Integer userId) throws Exception {
//        // 可自助调整超时时间
//        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
//        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
//        // 初始化acsClient,暂不支持region化
//        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
//        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
//        IAcsClient acsClient = new DefaultAcsClient(profile);
//
//        // 组装请求对象-具体描述见控制台-文档部分内容
//        SendSmsRequest request = new SendSmsRequest();
//
//        // 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
//        // request.setSmsUpExtendCode("90997");
//
//        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//        // request.setOutId("yourOutId");
//        try {
//            // hint 此处可能会抛出异常，注意catch
//            for(SmsInfo smsInfo:smsInfos){
//                // 必填:待发送手机号
//                request.setPhoneNumbers(smsInfo.getPhoneNumber());
//                // 必填:短信签名-可在短信控制台中找到
//                request.setSignName("学训宝");
//                // 必填:短信模板-可在短信控制台中找到
//                request.setTemplateCode(templatecode);
//                String smsTemplateContent = JSON.toJSONString(smsInfo);
//                // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
////        request.setTemplateParam("{\"devRoleName\":\"" + devRoleName + "\"}");
//                request.setTemplateParam(smsTemplateContent);
//                SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
//                smsInfo.setBizId(sendSmsResponse.getBizId());
//
//            }
//
//            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//            Thread.sleep(120000L);
//            for(SmsInfo smsInfo:smsInfos){
//                Boolean flag = test(smsInfo.getPhoneNumber(), smsInfo.getBizId(), format.format(new Date()), acsClient);
//                if (flag) {
//                    //发送成功
//                    //数据库操作
//                    MsgSend msgSend = new MsgSend();
//                    msgSend.setUserId(userId);
//                    msgSend.setPhone(smsInfo.getPhoneNumber());
//                    msgSend.setSendMsg("OK");
//                    smsUtil.iMsgSendService.insertMsg(msgSend);
//                    //return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
//                } else {
//                    //发送失败
//                    MsgSend msgSend = new MsgSend();
//                    msgSend.setPhone(smsInfo.getPhoneNumber());
//                    msgSend.setSendMsg("FAIL");
//                    msgSend.setUserId(userId);
//                    smsUtil.iMsgSendService.insertMsg(msgSend);
//                    //return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(sendSmsResponse.getCode());
//                }
//            }
//
//        } catch (ClientException e) {
//            // e.printStackTrace();
//            //发送失败
//            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(e.getErrMsg());
//        }
//        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
//    }


    /* 发送短信
     *
     * @param templatecode 模板代码
     * @param smsInfo      短信对象
     **/
    public static ResultJson sendSms(List<Users> users, String projectName, String version, String templatecode) throws Exception {
        // 可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        // 初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        List<SmsInfo> smsInfos = new ArrayList<>();
        //全部集体发送
        for(int i=0;i<users.size();i++){
            //封装数据
            SmsInfo smsInfo = new SmsInfo();
            smsInfo.setProductName(projectName);
            smsInfo.setPhoneNumber(users.get(i).getTelephone());
            smsInfo.setDevRoleName(users.get(i).getName());
            smsInfo.setProductVersion(version);
            smsInfo.setUserId(users.get(i).getId());
            SendSmsRequest request = new SendSmsRequest();
            request.setPhoneNumbers(users.get(i).getTelephone());
            request.setSignName("学训宝");
            request.setTemplateCode(templatecode);
            String smsTemplateContent = JSON.toJSONString(smsInfo);
            request.setTemplateParam(smsTemplateContent);
            try {
                SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
                //获取流水号
                String bizId = sendSmsResponse.getBizId();
                smsInfo.setBizId(bizId);
                smsInfos.add(smsInfo);
            } catch (ClientException e1) {
                continue;
            }
        }
        //查询
        Thread.sleep(120000);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        for (SmsInfo smsInfo : smsInfos) {
            Boolean flag = test(smsInfo.getPhoneNumber(), smsInfo.getBizId(), format.format(new Date()), acsClient);
            if (flag) {
                //发送成功
                //数据库操作
                MsgSend msgSend = new MsgSend();
                msgSend.setUserId(smsInfo.getUserId());
                msgSend.setPhone(smsInfo.getPhoneNumber());
                msgSend.setSendMsg("OK");
                smsUtil.iMsgSendService.insertMsg(msgSend);
                //return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
            } else {
                //发送失败
                MsgSend msgSend = new MsgSend();
                msgSend.setPhone(smsInfo.getPhoneNumber());
                msgSend.setSendMsg("FAIL");
                msgSend.setUserId(smsInfo.getUserId());
                smsUtil.iMsgSendService.insertMsg(msgSend);
                //return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(sendSmsResponse.getCode());
            }
        }
        return null;
    }
}
