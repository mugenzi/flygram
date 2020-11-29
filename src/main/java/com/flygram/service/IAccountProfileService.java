package com.flygram.service;

import java.util.List;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.User;

public interface IAccountProfileService {

	public AccountProfile createAccountProfile(AccountProfile account);

	public List<AccountProfile> viewAccountProfile();

	public AccountProfile findAccountProfileById(long id);

	public AccountProfile findAccountProfileByUser(User user);

	public AccountProfile updateAccountProfile(AccountProfile account);

	public void deleteAccountProfile(AccountProfile account);
	
	public AccountProfile getLoggedAccountProfile();

}
