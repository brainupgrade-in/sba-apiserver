package com.axess.smartbankapi.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EMailService {

	@Autowired
	private MailSender mailSender;

	@Async
	public String sendEmail(Email email) {
		return sendMessage(email);
	}

	public String sendMessage(Email email) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(email.getFrom());
		simpleMailMessage.setTo(email.getTo());
		simpleMailMessage.setSubject(email.getSubject());
		simpleMailMessage.setText(email.getBody());
		mailSender.send(simpleMailMessage);
		return "Email has been sent successfully.";
	}
}