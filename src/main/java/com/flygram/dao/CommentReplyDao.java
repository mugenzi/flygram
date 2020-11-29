package com.flygram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.CommentReply;
import com.flygram.Domain.PostComment;



public interface CommentReplyDao extends CrudRepository<CommentReply, Long> {
	public CommentReply findById(long id);

	public List<CommentReply> findByAccount(AccountProfile account);

	public List<CommentReply> findByComment(PostComment comment);

	public List<CommentReply> findAll();

}
