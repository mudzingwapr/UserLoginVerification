package com.mudzingwa.sec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mudzingwa.sec.Entity.User;
import com.mudzingwa.sec.Entity.UserModel;
import com.mudzingwa.sec.Entity.VerificationToken;
import com.mudzingwa.sec.Repository.UserRepository;
import com.mudzingwa.sec.Repository.VerificationTokenRepository;
@Service
public class UserServiceImple implements UserService {
	@Autowired
	private PasswordEncoder encode;
	@Autowired
	private UserRepository userrepo;
	@Autowired 
	private VerificationTokenRepository verirepo;

	@Override
	public User registerUser(UserModel user) {
		User us = new User();
		us.setFirstname(user.getFirstname());
		us.setEmail(user.getEmail());
		us.setLastname(user.getLastname());
		us.setPassword(encode.encode(user.getPassword()));
		us.setRole("user");
		us.setPassword(user.getPassword());
		userrepo.save(us);
		return us;
	}

	@Override
	public void saveVerificationTokenForUser(String token, User user) {
		// TODO Auto-generated method stub
		VerificationToken vt = new VerificationToken(token ,user); 
		verirepo.save(vt);
	}

	@Override
	public VerificationToken generateNewVerificationToken(String oldToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateVerificationToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
