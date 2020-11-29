package com.flygram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.User;

public interface AccountProfileDao extends CrudRepository<AccountProfile, Long> {

	public AccountProfile findById(long id);

	public AccountProfile findByUser(User user);

	public List<AccountProfile> findAll();

}
