package com.xxb.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {
    private static PropertiesUtil pu = new PropertiesUtil("/email.properties");
    private static String smtp_host = pu.getProperty("smtp_host");  //腾讯
    private static String username = pu.getProperty("username");   //当前账户
    private static String password =pu.getProperty("password");   //授权码
    private static String from = pu.getProperty("from");  //使用当前账户

    public static void sendMail(String subject, String content, String to){
        //1.发送主体  2.发送内容  3.发送给给谁
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", smtp_host);
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.debug", "true");
        props.setProperty("mail.smtp.ssl.enable","true");
        Session session = Session.getInstance(props);//创建程序到邮件的路
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.setRecipient(RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=utf-8");
            Transport transport = session.getTransport();
            transport.connect(smtp_host, username, password);
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("邮件发送失败...");
        }
    }

    public static void main(String[] args) {
        sendMail("测试邮件", "你好", "2118710792@qq.com");
    }
}
