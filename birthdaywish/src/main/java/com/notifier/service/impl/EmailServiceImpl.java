package com.notifier.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.notifier.entity.EmailDetails;
import com.notifier.service.EmailSendingService;

@Service
public class EmailServiceImpl implements EmailSendingService  {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	
	String subject="Happy Birthday Dikshit Kumar!";
	
	String messageBody="""
			Dear Friend Freind_Name,
			Hope Your Are doing and Happy and Happiest
			Happy birthday! Your life is just about to pick up speed and blast off into the 
			stratosphere. Wear a seat belt and be sure to enjoy the journey. 
			Happy birthday!”		
			
			
			Best Regards,
			Dikshit Kumar
			""";
	
	final String CONST_PATH = "src\\main\\resources\\static\\Happy.png";
	
	@Override
	public String sendEmailWithsimple(EmailDetails details,String name) {
	
        try {
 
        	System.out.println(sender);
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(messageBody);
            mailMessage.setSubject(subject);
 
            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
        	e.printStackTrace();
            return "Error while Sending Mail";
        }
    }
 

	
	
	
	
	
	
	@Override
	public String sendEmailWithAttachment(String senderEmail,String name) {
		
		String subject="Happy Birthday "+name+"!";
		
		String messageBody="""
				Dear Friend,
				Hope Your Are doing well and Happy and Happiest
				Happy birthday! Your life is just about to pick up speed and blast off into the 
				stratosphere. Wear a seat belt and be sure to enjoy the journey. 
				Happy birthday!”		
				
				
				Best Regards,
				Dikshit Kumar
				""";



		
		
		
		
		
		 // Creating a mime message
        MimeMessage mimeMessage   = javaMailSender.createMimeMessage();
       
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
        	
            // be send
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(senderEmail);
            mimeMessageHelper.setText(messageBody);
            mimeMessageHelper.setSubject(subject);
 
            // Adding the attachment
            FileSystemResource file= new FileSystemResource(new File(CONST_PATH));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully to "+senderEmail;
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
	}

}
