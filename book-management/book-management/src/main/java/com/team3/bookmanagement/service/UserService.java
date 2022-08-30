package com.team3.bookmanagement.service;

import com.team3.bookmanagement.dto.UserDTO;

public interface UserService {
	public UserDTO getUser(String userName);
	public String saveUser(UserDTO dto);
	public UserDTO loginUser(UserDTO dto);
}
