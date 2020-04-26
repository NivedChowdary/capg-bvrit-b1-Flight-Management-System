package com.capg.fms.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.fms.login.model.User;

@Repository
public interface IUserJpaRepo extends JpaRepository<User, Integer>{
	
	@Query(value = "from User where userName=:userName")
	public User getUserByUserName(String userName);

}
