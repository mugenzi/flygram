package com.flygram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flygram.Domain.AccountPrivacy;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.EAccountPrivacy;
import com.flygram.service.IAccountPrivacyService;
import com.flygram.service.IAccountProfileService;

@RestController
public class AccountPrivacyController {

	@Autowired
	IAccountPrivacyService service;

	@Autowired
	IAccountProfileService accountService;

	@PostMapping("/changeAccountPrivacy")
	public AccountPrivacy changeAccountPrivacy(@RequestBody AccountProfile account) {
		AccountPrivacy object = null;
		try {
			AccountProfile ap = accountService.findAccountProfileById(account.getAccountId());
			if (ap.getPrivacy().equals(EAccountPrivacy.PRIVATE))
				ap.setPrivacy(EAccountPrivacy.PUBLIC);
			if (ap.getPrivacy().equals(EAccountPrivacy.PUBLIC))
				ap.setPrivacy(EAccountPrivacy.PRIVATE);
			AccountProfile updatedAccount = accountService.updateAccountProfile(ap);
			AccountPrivacy objectToCreate = new AccountPrivacy();
			objectToCreate.setAccount(updatedAccount);
			objectToCreate.setPrivacy(updatedAccount.getPrivacy());
			object = service.createAccountPrivacy(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	@GetMapping("/findAccountPrivacy{id}")
	public EAccountPrivacy findAccountPrivacy(@PathVariable long id) {
		try {
			AccountProfile account = accountService.findAccountProfileById(id);
			return account.getPrivacy();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
