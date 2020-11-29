package com.flygram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;
import com.flygram.service.IAccountFollowshipService;
import com.flygram.service.IAccountProfileService;

@RestController
public class AccountFollowshipController {

	@Autowired
	IAccountFollowshipService service;

	@Autowired
	IAccountProfileService profileService;

	@PostMapping("/follow")
	public AccountFollowship follow(@RequestBody AccountFollowship accountFollowship) {
		AccountFollowship object = null;
		try {
			AccountProfile follower = profileService
					.findAccountProfileById(accountFollowship.getFollower().getAccountId());
			AccountProfile following = profileService
					.findAccountProfileById(accountFollowship.getFollowing().getAccountId());
			object = service.follow(follower, following);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	@PostMapping("/unFollow")
	public AccountFollowship unFollow(@RequestBody AccountFollowship accountFollowship) {
		AccountFollowship object = null;
		try {
			AccountFollowship accountToUnFollow = service.findAccountFollowshipById(accountFollowship.getId());
			object = service.unFollow(accountToUnFollow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

}
