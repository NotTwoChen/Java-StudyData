package com.wsh.user.service;

import com.wsh.user.dao.UserDao;
import com.wsh.user.domain.User;
import com.wsh.user.service.exception.*;
import com.wsh.util.Constant;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;

public class UserService{

    private UserDao ud = new UserDao();

    public String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public void register(User form) throws EmailHasBeenRegisteredException, UsernameHasBeenRegisteredException {
        User user1 = ud.findByUsername(form.getUsername());
        if (user1 == null){
            User user2 = ud.findByEmail(form.getUsername());
            if (user2 == null){
                ud.insert(form);
            }else {
                throw new EmailHasBeenRegisteredException();
            }
        }else {
            throw new UsernameHasBeenRegisteredException();
        }
    }
    public void checkFormat(User form) throws UsernameFormatErrorException, PasswordFormatErrorException, EmailFormatErrorException {

        if (Pattern.matches(Constant.REGEX_NAME,form.getUsername())){
            if (Pattern.matches(Constant.REGEX_PASSWORD,form.getPassword())){
                if (!Pattern.matches(Constant.REGEX_EMAIL,form.getEmail())) {
                    throw new EmailFormatErrorException();
                }
            }else {
                throw new PasswordFormatErrorException();
            }
        }else {
            throw new UsernameFormatErrorException();
        }
    }
//    @Test
    public void sendEmail(String code) throws UnsupportedEncodingException, MessagingException {
        String myEmailAccount = "320828748@qq.com";
        String myEmailPassword = "vwwedoaiswwhcaae";
        String myEmailSMTPHost = "smtp.qq.com";
        String receiveMailAccount = "3588501054@qq.com";
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", myEmailSMTPHost);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port","465");
        properties.setProperty("mail.smtp.ssl.enable","true");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmailAccount, myEmailPassword);
            }
        };
        Session session = Session.getInstance(properties,authenticator);
//        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myEmailAccount));
        message.setRecipients(Message.RecipientType.TO,receiveMailAccount);
        message.setSubject("不二云");
        message.setContent("<html><head ><meta charset='utf-8'>"
                        + "</head><body>内容：为了保证您的 不二云 帐户的安全，请验证您的电子邮件地址。<br>"
                        + "<a href='http://192.168.20.194:8080/NotTwoCloud/user?method=activate&&code="+code+"'>点击此处来验证您的电子邮件地址。</a><br>" +
                        "验证您的电子邮件地址让您能够：使用 不二云 令牌，更改您的不二云帐户凭据，" +
                        "使用交易与市场确认，以及在您无法访问帐户或是忘记密码时，找回您的 不二云 帐户。</body></html>",
                "text/html;charset=utf-8");
        Transport.send(message);
    }
}
