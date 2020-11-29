package com.flygram.service;

import java.util.List;

import com.flygram.Domain.AccountPrivacy;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.EAccountPrivacy;

public interface IAccountPrivacyService {

	public AccountPrivacy createAccountPrivacy(AccountPrivacy privacy);

	public AccountPrivacy updateAccountPrivacy(AccountPrivacy privacy);

	public void deleteAccountPrivacy(AccountPrivacy privacy);

	public AccountPrivacy findAccountPrivacyById(long id);

	public AccountPrivacy findAccountPrivacyByAccount(AccountProfile account);

	public List<AccountPrivacy> findAccountPrivacyByPrivacy(EAccountPrivacy privacy);

	public List<AccountPrivacy> findAllAccountPrivacy();

}
