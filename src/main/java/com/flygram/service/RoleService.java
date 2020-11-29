package com.flygram.service;

import java.util.List;

import com.flygram.Domain.Role;

public interface RoleService {
	public final static String NAME = "RoleServiceImpl";

	Role createRole(Role role);

	Role findByName(String name);

	List<Role> findAll();

	Role update(Role role);

	void deleteRole(long roleId);
}
