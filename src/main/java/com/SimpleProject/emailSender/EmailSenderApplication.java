package com.SimpleProject.emailSender;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class EmailSenderApplication {
	
    public static void main(String[] args) {
    	SpringApplication.run(EmailSenderApplication.class, args);
    	
    	//sendSimpleEmail("recebedorTestando@gmail.com", "uhbedexcmwchcoqb", "m.moraes11@outlook.com");
        

        
    }
    
    public static String sendSimpleEmail(String sender, String senderPassword, String recipient) {
    	
    	try {
	    	JavaMailSender emailSender = new JavaMailSenderImpl();
	        ((JavaMailSenderImpl) emailSender).setHost("smtp.gmail.com");
	        ((JavaMailSenderImpl) emailSender).setPort(587);
	        ((JavaMailSenderImpl) emailSender).setUsername(sender);
	        ((JavaMailSenderImpl) emailSender).setPassword(senderPassword);
	
	        Properties props = ((JavaMailSenderImpl) emailSender).getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");
	
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(sender);
	        message.setTo(recipient);
	        message.setSubject("Test Email");
	        message.setText("This is a test email sent directly from the main class!");
	
	        emailSender.send(message);
	        return "Message sent succesfully";
    	}catch(Exception e) {
    		return e.getMessage();
    	}
    }
    
    
}