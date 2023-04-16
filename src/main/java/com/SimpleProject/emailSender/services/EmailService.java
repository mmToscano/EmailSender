package com.SimpleProject.emailSender.services;

import com.SimpleProject.emailSender.Entities.EmailDetails;

public interface EmailService {
	
	// Method
    // To send a simple email
    //String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    //String sendMailWithAttachment(EmailDetails details);
    
    //String sendSimpleMailHardcode(EmailDetails details, String sender);
	
	void sendSimpleMail(String sender, String senderPassword, String recipient);
    
    void sendSimpleMailForTesting();
    
    void dummyMail();

}
