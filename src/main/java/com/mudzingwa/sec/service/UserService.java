package com.mudzingwa.sec.service;

import com.mudzingwa.sec.Entity.User;
import com.mudzingwa.sec.Entity.UserModel;
import com.mudzingwa.sec.Entity.VerificationToken;

public interface UserService {
	
	public User registerUser(UserModel user);
	public void saveVerificationTokenForUser(String token,User user);
    public VerificationToken generateNewVerificationToken(String oldToken);
    public String validateVerificationToken(String token);
    
    }

