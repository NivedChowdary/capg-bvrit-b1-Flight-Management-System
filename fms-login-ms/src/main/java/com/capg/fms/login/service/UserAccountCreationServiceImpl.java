package com.capg.fms.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.login.model.User;
import com.capg.fms.login.repository.IUserJpaRepo;

@Service
public class UserAccountCreationServiceImpl implements IUserAccountCreationService {
	
	@Autowired
	IUserJpaRepo repo;

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

}
