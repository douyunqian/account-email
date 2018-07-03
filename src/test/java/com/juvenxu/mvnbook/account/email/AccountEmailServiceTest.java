package com.juvenxu.mvnbook.account.email;

import javax.mail.Message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest {
	
	private GreenMail greenMail;
	
	@Before
	public void beforeSend(){
		greenMail=new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("zhizhangyitest@sina.com", "4565892");
		greenMail.start();
	}
	
	@Test
	public void testSendMail(){
		ApplicationContext context=new ClassPathXmlApplicationContext("account-email.xml");
		
		AccountEmailServiceImpl serviceImpl=(AccountEmailServiceImpl)context.getBean("accountEmailService");
		String subJect="Test Subject";
		String textSub="<h3>Test</h3>";
		try {
			serviceImpl.sendEmail("douyunqian@zhizhangyi.com", subJect, textSub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			greenMail.waitForIncomingEmail(2000,1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Message[] messages=greenMail.getReceivedMessages();
		
		
	}

	@After
	public void stopEmail(){
		greenMail.stop();
	}
}
