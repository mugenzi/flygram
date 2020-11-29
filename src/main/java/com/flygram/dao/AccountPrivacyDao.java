package com.flygram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.flygram.Domain.AccountPrivacy;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.EAccountPrivacy;

public interface AccountPrivacyDao  extends CrudRepository<AccountPrivacy, Long> {

	public AccountPrivacy findById(long id);

	public AccountPrivacy findByAccount(AccountProfile account);
	
	public List<AccountPrivacy> findByPrivacy(EAccountPrivacy privacy);
	
	public List<AccountPrivacy> findAll();
	
}
