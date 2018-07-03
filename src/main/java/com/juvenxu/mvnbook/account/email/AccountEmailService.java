package com.juvenxu.mvnbook.account.email;

public interface AccountEmailService {
	
	void sendEmail(String to,String subject,String htmlText)throws Exception;
	

}
