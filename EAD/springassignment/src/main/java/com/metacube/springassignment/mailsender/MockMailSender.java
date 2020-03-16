package com.metacube.springassignment.mailsender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Uncomment @Component to make it component.
//@Component("mockmailsender")
public class MockMailSender implements MailSender {

	@Override
	public void send() {
		System.out.println("Mock mail sent...  :)");

	}

}
