package com.flygram.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flygram.dao.UserDaoc;
import com.flygram.security.UserDTO;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDaoc userDaoc;

	@Autowired
	private IAccountProfileService accountService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDaoc.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with userName: " + userName);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(UserDTO user) throws Exception {
		AccountProfile profile = new AccountProfile();
		User testEmail = userDaoc.findByEmail(user.getEmail());
		User testUserName = userDaoc.findByUserName(user.getUsername());
		if (testEmail != null) {
			throw new Exception("The provided email is used by another account");
		}
		if (testUserName != null) {
			throw new Exception("The provided user name is used by another account");
		}
		User newUser = new User();
		newUser.setUserName(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setFullName(user.getFullName());
		newUser.setPhone(user.getPhone());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		User savedUser = userDaoc.save(newUser);
		profile.setUser(savedUser);
		accountService.createAccountProfile(profile);
		return savedUser;
	}
}