package com.team3.bookmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.bookmanagement.dto.UserDTO;
import com.team3.bookmanagement.entity.User;
import com.team3.bookmanagement.repository.UserRepo;
import com.team3.bookmanagement.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepo userRepo;

	public UserDTO getUser(String username) {
		User u = userRepo.findByUsername(username);
		return new UserDTO(u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getAvatarUrl());
	}
	public String saveUser(UserDTO dto) {
		User user = new User(dto.getId(),dto.getUsername(),dto.getPassword(),dto.getEmail(),dto.getAvatarUrl());
		return userRepo.save(user).getUsername()+ " Saved Successfully!";
	}
	@Override
	public UserDTO loginUser(UserDTO dto) {
		User u = userRepo.findByUsername(dto.getUsername());
		if(u!=null) {
			if(u.getPassword().equals(dto.getPassword())) {
				return new UserDTO(u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getAvatarUrl());
			}
			
		}
		return null;
	}
}
