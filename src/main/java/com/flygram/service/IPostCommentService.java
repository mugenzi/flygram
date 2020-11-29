package com.flygram.service;

import java.util.List;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;

public interface IPostCommentService {

	public PostComment createPostComment(PostComment comment);

	public PostComment findPostCommentById(long id);

	public List<PostComment> findPostCommentByAccount(AccountProfile account);

	public List<PostComment> findPostCommentByPost(Post post);

	public List<PostComment> findAllPostComment();

}
