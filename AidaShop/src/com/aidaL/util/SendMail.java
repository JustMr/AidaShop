package com.aidaL.util;

import java.io.IOException;
import java.io.InputStream;
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
	
	public static final String FROM = "justmrliu@163.com"; //发件人
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
		String msgText = "请点击下面的连接激活用户，如果不能点击请手动复制到地址栏中执行\n" + content;
		boolean result = false;
		try{
			System.out.println("---------开始发送---------");
			Message msg = new MimeMessage(session);
			//设置Message属性
			
			msg.setFrom(new InternetAddress(FROM));
			InternetAddress[] addrs = {new InternetAddress(receiver)};
			msg.setRecipients(Message.RecipientType.TO, addrs);
			//设置主题
			msg.setSubject("AidaShop-用户激活");	
			//设置发送时间
			msg.setSentDate(new Date());
//			msg.setContent(content, "text/html;charset=gb2312");
			msg.setText(msgText);
			
			//开始发送
//			Transport.send(msg);
			//协议
			Transport transport = session.getTransport("smtp");
			//发信人地址，用户名，密码
			transport.connect(HOST,FROM,PWD);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			
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
	
	 public void sendMail(String mail,String url) {
	    	
    	InputStream is = this.getClass().getResourceAsStream("/mailInfo.properties");
    	Properties prop = new Properties();
    	try {
			prop.load(is);//加载资源文件
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
        String msgText = "请点击下面的连接激活用户，如果不能点击请手动复制到地址栏中执行\n" + url;
        String smtpHost = prop.get("smtpHost").toString();//SMTP服务器名
        String from = prop.get("mailName").toString();//发信人地址
        String pwd = prop.get("pwd").toString();//密码
        String to = mail;//收信人地址
        // 创建properties对象
        Properties props = new Properties();
        //创建邮件服务器
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.auth", "true");

        //取得默认的Session
        Session session = Session.getDefaultInstance(props, null);

        // 创建一条信息，并定义发信人地址和收信人地址
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));

            InternetAddress[] address = {new InternetAddress(to)};

            message.setRecipients(Message.RecipientType.TO, address);

            message.setSubject("激活注册用户");//设定主题

            message.setSentDate(new Date());//设定发送时间

            message.setText(msgText);//把前面定义的msgText中的文字设定为邮件正文的内容

            message.saveChanges(); // implicit with send()
            //协意
            Transport transport = session.getTransport("smtp");
            //发信人地址，用户名，密码
            transport.connect(smtpHost, from, pwd);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
