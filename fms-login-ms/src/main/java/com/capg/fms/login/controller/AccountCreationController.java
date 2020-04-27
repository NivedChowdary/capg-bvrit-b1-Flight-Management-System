package com.capg.fms.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.login.model.User;
import com.capg.fms.login.service.IUserAccountCreationService;

@RestController
@RequestMapping("/account")
public class AccountCreationController {
	
	@Autowired
	IUserAccountCreationService service;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if(service.validatePhoneNo(user.getUserPhone()) && service.validateEmail(user.getUserEmail()) && service.validateId(user.getUserId()) && service.validatePassword(user.getUserPassword()) && service.validateUserType(user.getUserType()) && service.validateUserName(user.getUserName())) {
			return new ResponseEntity<User>(service.addUser(user),HttpStatus.CREATED);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		
	}

}
