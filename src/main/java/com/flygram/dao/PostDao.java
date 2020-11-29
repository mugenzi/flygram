package com.flygram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.Post;

public interface PostDao extends CrudRepository<Post, Long> {

	public Post findById(long id);

	public List<Post> findByAccount(AccountProfile accountProfile);

	public List<Post> findAll();

	public List<Post> findByLocation(String location);

}
