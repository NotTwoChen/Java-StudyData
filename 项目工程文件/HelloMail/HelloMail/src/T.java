import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

/**
 * Created by zyf on 2017/6/28.
 */
public class T {

	private String sendAddr = "320828748";//这是发送方的邮箱
	private String receiveAddr = "3588501054";//接收方的邮箱

	//这个不是密码,是开启163邮箱第三方登录时候设置的授权码
	//如果不开启,那么是无法第三方登录163邮箱账号的
	private String pass = "tlmreejcmetxcafd";

	@Test
	public void t1() throws MessagingException {
		Properties prop = new Properties();
		//设置服务器主机名
		prop.setProperty("mail.host","smtp.qq.com");
		prop.setProperty("mail.smtp.auth","true");
//		prop.put("mail.transport.protocol", "smtp");

		//我们要登录一个账号,来给别人发邮件
		//现在先构建一个邮件账号，需要用邮件地址和密码
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendAddr+"@qq.com",pass);
			}
		};

		//与服务器连接,这时候就连上了163.com的服务器
		//实际上就是用java代码,登录了自己的163邮箱
		Session session = Session.getInstance(prop,auth);

		//创建一个邮件对象
		//这就是登录了邮箱之后,点击了发邮件,进入编辑邮件的窗口
		MimeMessage msg = new MimeMessage(session);

		//设置发件人
		msg.setFrom(new InternetAddress(sendAddr+"@qq.com"));

		//设置收件人
		msg.setRecipients(Message.RecipientType.TO,"3588501054@qq.com");

		//设置抄送
//		msg.setRecipients(Message.RecipientType.CC,"抄送人@163.com");

		//设置密送
		//一封邮件发给了a,b,c三个人,a是可以知道这封邮件也发给了b,c的
		//如果设置了密送给d,那么a,b,c是不知道这封邮件也发给了d的
//		msg.setRecipients(Message.RecipientType.BCC,"偷偷的发@163.com");

		//添加主题
		msg.setSubject("这是来自王先生的邮件");

		//添加内容,第二个参数表示这是html的内容
		msg.setContent("11你体验过衣柜门缝里透进的灯光吗<br/><a href=\"http:www.baidu.com\">慢点慢点</a>","text/html;charset=utf-8");

		Transport.send(msg);
	}

	@Test
	public void t2() throws Exception{

		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendAddr+"@163.com",pass);
			}
		};
		Session session = Session.getInstance(props, auth);

		MimeMessage msg = new MimeMessage(session);
		// 设置发件人
		msg.setFrom(new InternetAddress(sendAddr+"@163.com"));
		// 设置收件人
		msg.setRecipients(Message.RecipientType.TO, "3487232393@qq.com");
		msg.setSubject("带有附件的邮件");

    	/*当发送包含附件的邮件时, 邮件体就为多部件
    		1. 创建一个多部件的部件内容, MimeMultipart
			2. 我们需要创建两个主体部件, 一个是文本内容, 一个是附件的. 主体部件叫MimeBodyPart
			3. 把 MimeMultipart设置给MimeMessage
    	*/
		// 创建多部分内容
		MimeMultipart list = new MimeMultipart();
		// 创建MimeBodyPart 主体部件
		MimeBodyPart part1 = new MimeBodyPart();
		part1.setContent("这是一封包含附件的邮件", "text/html;charset=utf-8");
		list.addBodyPart(part1); // 把主体部件添加到多部件主体

		MimeBodyPart part2 = new MimeBodyPart();
		//使用File只能找到本机的内容
		//若想使用工程里的，需要使用getServletContext().get.....自己想
		part2.attachFile(new File("/Users/zyf/Desktop/图片/搞怪图片/girl.jpg")); // 设置附件内容
		// 显示在附件上的名称 . 会乱码.需要处理,使用 MimeUtility.encodeText处理
		part2.setFileName(MimeUtility.encodeText("女生.jpg"));
		list.addBodyPart(part2);

		msg.setContent(list); // 把多部件设置给邮件内容

		Transport.send(msg);
	}

}
