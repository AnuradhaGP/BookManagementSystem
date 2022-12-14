package com.team3.bookmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.bookmanagement.dto.UserDTO;
import com.team3.bookmanagement.service.UserService;
import com.team3.bookmanagement.util.StandardResposeEntity;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/get-user/{name}",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<StandardResposeEntity> getUser(@PathVariable("name") String userName) {
		UserDTO dto = userService.getUser(userName);
		if(dto!=null) {
			return new ResponseEntity<StandardResposeEntity>(
					new StandardResposeEntity(200, "Success!",dto),
					HttpStatus.OK
					);
		}
		return new ResponseEntity<StandardResposeEntity>(
				new StandardResposeEntity(404, "User Not Found!",null),
				HttpStatus.NOT_FOUND
				);	
	}
	
	@PostMapping(path = "/save-user", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<StandardResposeEntity> saveUser(@RequestBody UserDTO dto) {
		try {
			return new ResponseEntity<StandardResposeEntity>(
					new StandardResposeEntity(200, "Success!",userService.saveUser(dto)),
					HttpStatus.OK
					);
		}catch(Exception e){
			return new ResponseEntity<StandardResposeEntity>(
					new StandardResposeEntity(500, "User Already exist","Username Already in use"),
					HttpStatus.NOT_ACCEPTABLE
					);
		}
		
	}
	@PostMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<StandardResposeEntity> loginUser(@RequestBody UserDTO dto) {
		
		UserDTO user = userService.loginUser(dto);
		if(user!=null) {
			return new ResponseEntity<StandardResposeEntity>(
					new StandardResposeEntity(200, "Success!",user),
					HttpStatus.OK
					);
		}
		
		return new ResponseEntity<StandardResposeEntity>(
				new StandardResposeEntity(402, "Invalid Credential!",user),
				HttpStatus.NOT_ACCEPTABLE
				);		
		
		
	}
}
