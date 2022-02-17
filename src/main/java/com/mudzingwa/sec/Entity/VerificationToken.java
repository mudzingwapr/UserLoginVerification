package com.mudzingwa.sec.Entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class VerificationToken {
	
private static final int EXP_TIME= 10;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String token;
 private Date expired;
 @OneToOne(fetch=FetchType.EAGER)
 @JoinColumn(name="user_id",nullable=false,foreignKey=@ForeignKey(name="FK_USR"))
 private User user;
public VerificationToken(String token,  User user) {
	super();
	this.token = token;
	this.expired = CalculateExpirationTime(EXP_TIME);
	this.user = user;
}

 public Date CalculateExpirationTime(int expired) {
	 Calendar cal = Calendar.getInstance();
	 cal.setTimeInMillis(new Date().getTime());
	 cal.add(Calendar.MINUTE, expired);
	 return new Date(cal.getTime().getTime());
 }

public VerificationToken(String token, Date expired) {
	super();
	this.token = token;
	this.expired =  CalculateExpirationTime(EXP_TIME);
}
 
 
}
