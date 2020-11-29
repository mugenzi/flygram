package com.flygram.dao;

import org.springframework.data.repository.*;

import com.flygram.Domain.Role;


public interface RoleDao extends CrudRepository<Role, Long>
{
    Role findByName(String role);
}