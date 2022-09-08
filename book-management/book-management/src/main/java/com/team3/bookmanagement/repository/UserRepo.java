package com.team3.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team3.bookmanagement.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	User findByUsernameIgnoreCase(String username);
}
