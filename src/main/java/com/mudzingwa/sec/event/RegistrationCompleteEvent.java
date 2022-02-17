package com.mudzingwa.sec.event;

import org.springframework.context.ApplicationEvent;

import com.mudzingwa.sec.Entity.User;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent{
	private User user;
	private String applicationUrl;

	public RegistrationCompleteEvent(User user,String applicationUrl) {
	super(user);
		this.applicationUrl=applicationUrl;
		this.user=user;
	}

}
