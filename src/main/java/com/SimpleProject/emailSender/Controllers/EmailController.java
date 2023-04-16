package com.SimpleProject.emailSender.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SimpleProject.emailSender.Entities.EmailDetails;
import com.SimpleProject.emailSender.services.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService service;
	
	/*
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {
		String status = service.sendSimpleMail(details);
		
		return status;
	}
	
	@PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails details){
        String status
            = service.sendMailWithAttachment(details);
 
        return status;
    }
    */
	
	@PostMapping("/mailTest")
	public void sendMailForTesting() {
		service.sendSimpleMailForTesting();
	}
	
	@PostMapping("/sendMail")
	public void sendSimpleMail(@RequestBody String sender, @RequestBody String senderPassword, @RequestBody String recipient) {
		service.sendSimpleMail(sender, senderPassword, recipient);
	}
	
	@PostMapping("/sendDummyMail")
	public void sendDummyMail() {
		service.dummyMail();
	}

}
