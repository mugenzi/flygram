package com.flygram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;

public interface PostCommentDao extends CrudRepository<PostComment, Long> {

	public PostComment findById(long id);

	public List<PostComment> findByAccount(AccountProfile account);

	public List<PostComment> findByPost(Post post);

	public List<PostComment> findAll();

}
