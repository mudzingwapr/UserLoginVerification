package com.mudzingwa.sec.event;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.mudzingwa.sec.Entity.User;
import com.mudzingwa.sec.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class RegistrationCompleteEventLister implements ApplicationListener<RegistrationCompleteEvent> {
	@Autowired
private UserService service;

	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		User ur = event.getUser();
		String token = UUID.randomUUID().toString();
		service.saveVerificationTokenForUser(token, ur);
		String url = event.getApplicationUrl()+"/verifyRegistration"+token;
		log.info("Click link given to verify ac created :{}"+url);
	}

}
