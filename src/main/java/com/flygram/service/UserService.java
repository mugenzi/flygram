package com.flygram.service;

import java.util.List;
import java.util.Set;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import com.flygram.Domain.User;
import com.flygram.Domain.UserRole;

public interface UserService {

	public final static String NAME = "UserServiceImpl";

	public User createUser(User user, Set<UserRole> userRole) throws Exception;

	public boolean checkEmailExists(String email);

	public boolean checkUsernameExists(String userName);

	public boolean checkUserExists(String paramString1, String email);

	@PreAuthorize("#user.userName == authentication.name")
	public User updateProfile(User user) throws Exception;

	public User findByUsername(String userName);

	public abstract List<User> findAll();

	@Secured("ROLE_ADMIN")
	void isEnabled(long userId, boolean enabled) throws Exception;

	public List<User> findByEnabled(boolean b);

	public User findbyId(long parseLong) throws Exception;

	List<String> userRoles(Authentication auth);

	boolean checkUserContainsRole(User user, String roleName);

	void resetPassword(String email) throws Exception;

	long countUsers();

	User findByEmail(String email);
}