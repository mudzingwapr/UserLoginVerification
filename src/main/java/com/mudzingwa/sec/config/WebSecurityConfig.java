package com.mudzingwa.sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {
	private static final String [] WHITE_LIST= {"/hellow","/register","/getlink"};
	@Bean
	public PasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder(10); 
			
		
	}
	
SecurityFilterChain securitfilterChain(HttpSecurity http) throws Exception {
	http
	.cors()
	.and()
	.csrf()
	.disable()
	.authorizeHttpRequests()
	.antMatchers(WHITE_LIST).permitAll();
return http.build();
}

}
