package com.SimpleProject.emailSender.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SimpleProject.emailSender.services.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService service;
	
	@PostMapping("/sendDummyMail")
	public void sendDummyMail() {
		service.dummyMail();
	}

}
