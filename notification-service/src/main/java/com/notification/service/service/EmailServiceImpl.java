package com.notification.service.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String to, String subject, String body) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);

		javaMailSender.send(message);
	}

	@Override
	public void sendEmailWithAttachment(
	        String to,
	        String subject,
	        String body,
	        String filePath) {

	    try {

	        System.out.println("Attachment Path Received : " + filePath);

	        File fileObj = new File(filePath);

	        if(!fileObj.exists()) {
	            throw new RuntimeException("Attachment File Not Found : " + filePath);
	        }

	        System.out.println("Attachment File Exists : " + fileObj.exists());
	        System.out.println("Attachment Absolute Path : " + fileObj.getAbsolutePath());

	        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(body, false);

	        FileSystemResource file = new FileSystemResource(fileObj);

	        helper.addAttachment(fileObj.getName(), file);

	        javaMailSender.send(mimeMessage);

	        System.out.println("Mail With Attachment Sent Successfully");

	    } catch(Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Mail With Attachment Failed : " + e.getMessage());
	    }
	}
}