package com.flygram.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flygram.Domain.Role;
import com.flygram.Domain.User;
import com.flygram.Domain.UserRole;
import com.flygram.dao.RoleDao;
import com.flygram.dao.UserDaoc;
import com.flygram.dao.UserRoleDao;
import com.flygram.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserRoleDao userRoleDao;


	@Autowired
	private UserDaoc userDaoc;


	public UserServiceImpl() {
	}

	public void save(User user) {
		userDaoc.save(user);
	}

	@Override
	public void isEnabled(long userId, boolean enabled) throws Exception {
		User user = userDaoc.findById(userId);
		if (user != null) {
//			user.setEnabled(enabled);
			userDaoc.save(user);
		} else {
			throw new Exception("User not exists");
		}
	}

	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{

		User localUser = userDaoc.findByUserName(user.getUserName());

		if (localUser != null) {

//			LOG.info("Username {} already exists. Please try another one. " + user.getUsername());
			
			throw new Exception("Username already exists. Please try another one.");

		} else {


			//user.getUserRoles().addAll(userRoles);
			localUser = (User) userDaoc.save(user);
		}

		return localUser;
	}

	public User findByUsername(String userName) {
		return userDaoc.findByUserName(userName);
	}

	public User findByEmail(String email) {
		return userDaoc.findByEmail(email);
	}

	public boolean checkUserExists(String userName, String email) {
		if ((checkUsernameExists(userName)) || (checkEmailExists(email))) {
			return true;
		}
		return false;
	}

	public boolean checkUsernameExists(String userName) {
		if (findByUsername(userName) != null) {
			return true;
		}
		return false;
	}

	public boolean checkEmailExists(String email) {
		if (findByEmail(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<String> userRoles(Authentication auth) {
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}
		return roles;
	}

	@Override
	public boolean checkUserContainsRole(User user, String roleName) {
		Role role = roleDao.findByName(roleName);
		if (!userRoleDao.findByUserAndRole(user, role)) {
			return false;
		}
		return true;
	}

	@Transactional
	public User updateProfile(User user) throws Exception {
		User localUser = userDaoc.findByUserName(user.getUserName());
		if (localUser == null) {
			LOG.info("Username {} not found. " + user.getUserName());
		} else {
			if (!user.getPassword().equals("")) {
				//String encryptedPassword = passwordEncoder.encode(user.getPassword());
				user.setPassword(user.getPassword());
			}else {
				user.setPassword(localUser.getPassword());
			}
			localUser = userDaoc.save(user);
		}

		return localUser;
	}

	public List<User> findAll() {
		return (List<User>) userDaoc.findAll();
	}
	
	@Override
	public User findbyId(long id) throws Exception {
		return userDaoc.findById(id);
	}

	@Override
	public void resetPassword(String email) throws Exception {
		User user = userDaoc.findByEmail(email);
		
	}

	@Override
	public long countUsers() {
		return userDaoc.count();
	}

	@Override
	public List<User> findByEnabled(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

}