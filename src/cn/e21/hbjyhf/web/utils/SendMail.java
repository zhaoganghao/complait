package cn.e21.hbjyhf.web.utils;  

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContext;

import cn.e21.hbjyhf.model.Information;
  
public class SendMail {  
      
    // 163邮箱  
    public static boolean send_163(String mail,ServletContext context,Information infor) {  
    	Properties pro= new Properties();
    	InputStream in2=context.getResourceAsStream("/WEB-INF/classes/mail.properties");
    	try {
			pro.load(in2);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 这个类主要是设置邮件  
        MailSenderInfo mailInfo = new MailSenderInfo();  
        mailInfo.setMailServerHost(pro.getProperty("mailServerHost"));  
        mailInfo.setMailServerPort(pro.getProperty("mailServerPort")); 
        mailInfo.setValidate(true);  
        mailInfo.setUserName(pro.getProperty("userName")); // 实际发送者  
        mailInfo.setPassword(pro.getProperty("password"));// 您的邮箱密码  
        mailInfo.setFromAddress(pro.getProperty("userName")); // 设置发送人邮箱地址  
        mailInfo.setToAddress(mail); // 设置接受者邮箱地址  
        mailInfo.setSubject(pro.getProperty("subject"));  
        mailInfo.setContent(pro.getProperty("content")+"时间"+new Date().toLocaleString()+infor.getContent());  
        // 这个类主要来发送邮件  
        SimpleMailSender sms = new SimpleMailSender(); 
       boolean flag= sms.sendTextMail(mailInfo);
        return flag; // 发送文体格式  
        
    }  
}  