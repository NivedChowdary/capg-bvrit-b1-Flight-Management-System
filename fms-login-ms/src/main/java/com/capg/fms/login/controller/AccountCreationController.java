package com.capg.fms.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.login.model.User;
import com.capg.fms.login.service.IUserAccountCreationService;

@RestController
public class AccountCreationController {
	
	@Autowired
	IUserAccountCreationService service;
	
	@PostMapping("/user/add")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

}
