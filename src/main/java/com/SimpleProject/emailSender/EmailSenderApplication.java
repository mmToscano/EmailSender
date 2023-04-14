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

        JavaMailSender emailSender = new JavaMailSenderImpl();
        ((JavaMailSenderImpl) emailSender).setHost("smtp.gmail.com");
        ((JavaMailSenderImpl) emailSender).setPort(587);
        ((JavaMailSenderImpl) emailSender).setUsername("recebedorTestando@gmail.com");
        ((JavaMailSenderImpl) emailSender).setPassword("uhbedexcmwchcoqb");

        Properties props = ((JavaMailSenderImpl) emailSender).getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("recebedorTestando@gmail.com");
        message.setTo("m.moraes11@outlook.com");
        message.setSubject("Test Email");
        message.setText("This is a test email sent directly from the main class!");

        emailSender.send(message);
    }
}