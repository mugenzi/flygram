package com.flygram.service;

import java.util.List;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.CommentReply;
import com.flygram.Domain.PostComment;

public interface ICommentReplyService {

	public CommentReply createCommentReply(CommentReply reply);
	
	public CommentReply findById(long id);

	public List<CommentReply> findByAccount(AccountProfile account);

	public List<CommentReply> findByComment(PostComment comment);

	public List<CommentReply> findAll();

}
