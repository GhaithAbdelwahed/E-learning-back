package com.example.elearning.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elearning.model.Mail;
import com.example.elearning.repository.MailRepository;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
@Service
@Transactional
public class SendMailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	MailRepository repository;
	
	public long sendMail(Mail mail) throws MailException{
		System.out.println("send email ....");
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo(mail.getDestinataire());
		msg.setFrom("abdelwahedghaith@gmail.com");
		msg.setSubject(mail.getObjet());
		msg.setText(mail.getMessage());
		javaMailSender.send(msg);
		return repository.save(mail).getId();
	}
	
	public void sendMailWithAttachements(Mail mail) throws MessagingException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg,true);
		helper.setTo(mail.getDestinataire());
		helper.setSubject(mail.getObjet());
		helper.setText(mail.getMessage(),true);
	}
	
	
	
}
