package com.capg.fms.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.login.exceptions.InvalidInputException;
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
	
	public boolean validatePhoneNo(long phoneNo) {
		String s=Long.toString(phoneNo);
		if(!(s.length()==10 && s.charAt(0)!=0)) {
			throw new InvalidInputException("Phone number should be of 10 digits");
		}
		return true;	
	}

	
	public boolean validateEmail(String email)  {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      if(email.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidInputException("Email Id NOT valid");
	   }


	public boolean validateId(long id) {
		int count=0;
		long d;
		while(id>0) {
			d=id % 10;
			count++;
			id=id/10;
		}
		if(count!=12)
			throw new InvalidInputException("ID should be of 12 digits");	
			
		else
			return true;
	}
	
	

}
