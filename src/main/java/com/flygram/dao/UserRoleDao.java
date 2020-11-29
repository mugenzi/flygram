package com.flygram.dao;

import org.springframework.data.repository.*;

import com.flygram.Domain.*;

public interface UserRoleDao extends CrudRepository<UserRole, Long>
{
    Iterable<UserRole> findByRole(Role userRole);
    boolean findByUserAndRole(User user, Role role);
}