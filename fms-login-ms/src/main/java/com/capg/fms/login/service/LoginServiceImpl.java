package com.capg.fms.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.login.exceptions.InvalidUserNameAndPasswordException;
import com.capg.fms.login.model.User;
import com.capg.fms.login.repository.IUserJpaRepo;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	IUserJpaRepo repo;

	@Override
	public boolean checkUserCredentials(String userName,String userPassword) {
		
		if(!repo.findAll().contains(repo.getUserByUserName(userName)))  {
			throw new InvalidUserNameAndPasswordException("user with userName ["+userName+"] NOT Found");
		}
		else if(repo.findAll().contains(repo.getUserByUserName(userName))) {
			if(!userPassword.equals(repo.getUserByUserName(userName).getUserPassword())) {
				throw new InvalidUserNameAndPasswordException("Password mismatch");
			}
		}
		return true;
	}

	@Override
	public User getUser(String userName) {
		return repo.getUserByUserName(userName);
	}

	
	
}
