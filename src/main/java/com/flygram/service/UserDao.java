package com.flygram.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flygram.Domain.User;

public interface UserDao extends CrudRepository<User, Integer> {
	
	User findByUserName(String userName);
	
}