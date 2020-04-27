package com.capg.fms.login.service;

import com.capg.fms.login.model.User;

public interface IUserAccountCreationService {
	
	public User addUser(User user);
	public boolean validatePhoneNo(long phoneNo);
	public boolean validateEmail(String email) ;
	public boolean validateId(long id);

}
