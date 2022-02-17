package com.mudzingwa.sec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mudzingwa.sec.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
