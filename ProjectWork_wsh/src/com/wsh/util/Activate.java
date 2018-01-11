package com.wsh.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Activate {
    private Properties properties = new Properties();
    public void sendEmail(String code,String email) throws UnsupportedEncodingException, MessagingException {
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", Constant.MY_EMAIL_SMTPHOST);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port","465");
        properties.setProperty("mail.smtp.ssl.enable","true");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Constant.MY_EMAIL_ACCOUNT, Constant.MY_EMAIL_PASSWORD);
            }
        };
        Session session = Session.getInstance(properties,authenticator);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(Constant.MY_EMAIL_ACCOUNT));
        message.setRecipients(Message.RecipientType.TO,email);
        message.setSubject("不二云");
        message.setContent("<html><head ><meta charset='utf-8'>"
                        + "</head><body>内容：为了保证您的 不二云 帐户的安全，请验证您的电子邮件地址。<br>"
                        + "<a href='http://192.168.20.194:8080/NotTwoCloud/user?method=active&&code="+code+"'>点击此处来验证您的电子邮件地址。</a><br>" +
                        "验证您的电子邮件地址让您能够：使用 不二云 令牌，更改您的不二云帐户凭据，" +
                        "使用交易与市场确认，以及在您无法访问帐户或是忘记密码时，找回您的 不二云 帐户。</body></html>",
                "text/html;charset=utf-8");
        Transport.send(message);
    }
}
