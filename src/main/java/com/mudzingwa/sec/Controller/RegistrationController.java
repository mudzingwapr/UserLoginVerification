package com.mudzingwa.sec.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mudzingwa.sec.Entity.User;
import com.mudzingwa.sec.Entity.UserModel;
import com.mudzingwa.sec.event.RegistrationCompleteEvent;
import com.mudzingwa.sec.service.UserService;

@RestController
public class RegistrationController {
	@Autowired
	private UserService uservice;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	@GetMapping("/hellow")
	public String hellowMudzingwa() {
		return "The seeds of success is comming";
	}
	
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserModel userModel,final HttpServletRequest request) {
		User user = uservice.registerUser(userModel);
		publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
		  return "Success";
		
	}

@GetMapping("/getlink")
	private String applicationUrl(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "/https"+request.getServerName()+":"+
				request.getServerPort()+ ":"+request.getContextPath();
	}
	
		
	

}
