package com.juvenxu.mvnbook.account.email;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AccountEmailServiceImpl implements AccountEmailService{

	
	private JavaMailSender javaMailSender;
	private String systemEmail;
	
	public void sendEmail(String to, String subject, String htmlText) throws Exception {
		
		
		try {
			
			MimeMessage msg=javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper=new MimeMessageHelper(msg);
			messageHelper.setFrom(systemEmail);
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(htmlText);
			javaMailSender.send(msg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}
	
	

}
