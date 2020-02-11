package com.metacube.springassignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.springassignment.mailsender.MailSender;
import com.metacube.springassignment.mailsender.MockMailSender;
import com.metacube.springassignment.mailsender.SMTPMailSender;

//Uncomment the @Configuration while using the @Component annotation.
@Configuration
public class AppConfig {

	@Bean("pqr")
	public MailSender mockMailSender() {
		return new MockMailSender();
	}

	@Bean("abc")
	public MailSender SMTPMailSender() {
		return new SMTPMailSender();
	}
}
