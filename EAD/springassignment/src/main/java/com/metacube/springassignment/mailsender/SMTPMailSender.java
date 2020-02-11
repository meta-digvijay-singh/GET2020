package com.metacube.springassignment.mailsender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Uncomment @Component to make it component.
//@Component("smtpmailsender")
//@Primary
public class SMTPMailSender implements MailSender {

	@Override
	public void send() {
		System.out.println("SMTP Mail sent...  :)");

	}

}
