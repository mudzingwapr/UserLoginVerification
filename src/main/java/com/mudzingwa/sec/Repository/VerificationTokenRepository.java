package com.mudzingwa.sec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mudzingwa.sec.Entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	

}
