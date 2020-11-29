package com.flygram.dao;

import org.springframework.data.repository.*;

import com.flygram.Domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.*;

public interface UserDaoc extends CrudRepository<User, Long> {
	User findByUserName(String userName);

	User findByEmail(String email);

	User findById(long id);
	
}