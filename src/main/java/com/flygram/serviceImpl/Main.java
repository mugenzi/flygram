package com.flygram.serviceImpl;

import com.flygram.Domain.AccountProfile;

public class Main {

	public static void main(String[] args) {
		AccountProfileServiceImpl a = new AccountProfileServiceImpl();
		AccountProfile account = new AccountProfile();
		account.setBiography("ddddd");
		a.createAccountProfile(account);

	}

}
