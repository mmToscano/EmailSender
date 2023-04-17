package com.SimpleProject.emailSender.services;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
	


	//Envia um email com remetente, senha do remetente, um destinatário que não existe
    // e uma mensagem padrão
	@Override
	public String dummyMail() {
		JavaMailSender emailSender = new JavaMailSenderImpl();
		try {
			//servidor
	        ((JavaMailSenderImpl) emailSender).setHost("smtp.gmail.com");
	        ((JavaMailSenderImpl) emailSender).setPort(587);
	        ((JavaMailSenderImpl) emailSender).setUsername("recebedorTestando@gmail.com");
	        ((JavaMailSenderImpl) emailSender).setPassword("uhbedexcmwchcoqb");
	
	        //segurança e autenticação
	        Properties props = ((JavaMailSenderImpl) emailSender).getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");
	
	        //construção do objeto mensagem
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("recebedorTestando@gmail.com");
	        message.setTo("testador123453562345@gmail.com");//Destinatário não existente
	        message.setSubject("Test Email");
	        message.setText("This is a test email sent directly from the main class!");
	
	        //envio
	        emailSender.send(message);
	        return "Message sent succesfully";
		}catch(Exception e) {
			return e.getMessage();
		}
	}



	
	
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
/*
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value //Pega o valor presente na variável spring.mail.username presente no arquivo application.properties
	("${spring.mail.username}") private String sender; //Eu mesmo
	
	public String sendSimpleMail(EmailDetails details) {
		
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());
			
			javaMailSender.send(mailMessage);
			return "Mail sent succesfully";
		}catch(Exception e) {
			return e.toString();
		}
	}
	
	
	
	public String
    sendMailWithAttachment(EmailDetails details){
        // Creating a mime message
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                details.getSubject());
 
            // Adding the attachment
            FileSystemResource file
                = new FileSystemResource(
                    new File(details.getAttachment()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }

    }
    
    @Override
	public String sendSimpleMailHardcode(EmailDetails details, String sender) {
		// TODO Auto-generated method stub
		return null;
	}
    */
}
