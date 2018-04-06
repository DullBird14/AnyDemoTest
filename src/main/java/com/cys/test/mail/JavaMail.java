package com.cys.test.mail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMail {
    public static void main(String[] args) throws MessagingException {
        // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        // 指定验证为true
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.timeout","1000");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        // 验证账号及密码，密码需要是第三方授权码
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("524318257@qq.com", "tcujwmzuzthkbhjh");
            }
        };
        Session session = Session.getInstance(props, auth);

// 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
// 设置发送者
        message.setFrom(new InternetAddress("524318257@qq.com"));
// 设置发送方式与接收者
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("475532944@qq.com"));
// 设置主题
        message.setSubject("邮件发送测试");
// 设置内容
        message.setContent("<font size='5' color='red'>附件测试成功！</font>", "text/html;charset=utf-8");

// 3.创建 Transport用于将邮件发送
        Transport.send(message);
    }
}
