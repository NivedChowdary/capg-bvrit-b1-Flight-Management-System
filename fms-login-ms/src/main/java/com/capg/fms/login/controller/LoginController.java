package com.capg.fms.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.login.model.User;
import com.capg.fms.login.service.ILoginService;


@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	ILoginService service;
	
	@PostMapping("{userType}/{userName}/{userPassword}")
	public String loginAsUser(@PathVariable("userType") String userType, @PathVariable("userName") String userName,@PathVariable("userPassword") String userPassword){
		if(userType.equals(service.getUser(userName).getUserType())) {
			if(service.checkUserCredentials(userName,userPassword)) {
				return userType.toUpperCase()+" PRESENT";
			}
		}
		return userType.toUpperCase()+" NOT_FOUND";
	}
	

	
}
