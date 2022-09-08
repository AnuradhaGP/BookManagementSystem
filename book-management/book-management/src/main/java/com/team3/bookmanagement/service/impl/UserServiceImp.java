package com.team3.bookmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team3.bookmanagement.dto.UserDTO;
import com.team3.bookmanagement.entity.User;
import com.team3.bookmanagement.repository.UserRepo;
import com.team3.bookmanagement.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepo userRepo;

	PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();


	public UserDTO getUser(String username) {
		User u = userRepo.findByUsernameIgnoreCase(username);
		return new UserDTO(u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getAvatarUrl());
	}
	public String saveUser(UserDTO dto) {
		String enPassword = this.passwordEncoder.encode(dto.getPassword());
		User user = new User(dto.getId(),dto.getUsername(),enPassword,dto.getEmail(),dto.getAvatarUrl());
		return userRepo.save(user).getUsername()+ " Saved Successfully!";
	}
	@Override
	public UserDTO loginUser(UserDTO dto) {
		User u = userRepo.findByUsernameIgnoreCase(dto.getUsername());
		if(u!=null) {
			if(passwordEncoder.matches(dto.getPassword(),u.getPassword())) {
				return new UserDTO(u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getAvatarUrl());
			}
			
		}
		return null;
	}
}
