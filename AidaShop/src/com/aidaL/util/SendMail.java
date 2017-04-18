package com.aidaL.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {
	public static final String HOST = "smtp.163.com";
	public static final String PROTOCOL = "smtp";
	public static final int PORT = 25;
	
	public static final String FROM = "18330180757@163.com"; //发件人
	public static final String PWD = "Family171213";		//服务密码非邮箱密码
	
	
	public static Session getSession(){
		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);
		props.put("mail.store.protocol" , PROTOCOL);//设置协议  
		props.put("mail.smtp.port", PORT);//设置端口  
		props.put("mail.smtp.auth", "true");
		
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(FROM, PWD);
			}
		};
		Session session = Session.getDefaultInstance(props, authenticator);
		
		return session;
	}
	
	public boolean send(String receiver,String content){
		Session session = getSession();
		boolean result = false;
		try{
			System.out.println("---------开始发送---------");
			Message msg = new MimeMessage(session);
			//设置Message属性
			
			msg.setFrom(new InternetAddress(FROM));
			InternetAddress[] addrs = {new InternetAddress(receiver)};
			msg.setRecipients(Message.RecipientType.TO, addrs);
			msg.setSubject("AidaShop-用户激活");
			msg.setSentDate(new Date());
			msg.setContent(content, "text/html;charset=utf-8");
			
			//开始发送
			Transport.send(msg);
			
			System.out.println("---------发送完成---------");
			result = true;
		}catch (AddressException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (MessagingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
