package com.metacube.springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.springassignment.mailsender.MailSender;

@RestController
public class SendingController {

	// Uncomment @Autowired to perform name injection.
	// @Autowired
	// Uncomment @Qualifier to solve the multiple bean problem.
	// @Qualifier("smtpmailsender")
	private MailSender mailSender;

	// Uncomment below lines and comment the setter to apply constructor injection.
	/*
	 * @Autowired public SendingController(MailSender mailSender) { this.mailSender
	 * = mailSender; }
	 */

	@Autowired
	public void setMailSender(MailSender abc) {
		this.mailSender = abc;
	}

	@GetMapping("/send")
	public String sendMail() {

		mailSender.send();

		return "Mail sent successfully...";
	}
}
