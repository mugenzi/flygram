package com.flygram.service;

import java.util.List;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.PostLike;

public interface IPostService {

	public Post createPost(Post post);

	public List<Post> findAllPostByAccount(AccountProfile account);

	public List<PostComment> findCommentByPost(Post post);

	public List<PostLike> findLikeByPost(Post post);

	public long countAllPostByAccount(AccountProfile account);

	public long countCommentByPost(Post post);

	public long countLikeByPost(Post post);

	public Post findPostById(long id);

	public List<Post> findPostByLocation(String location);

	public List<Post> findAllPost();

	public void deletePost(Post post);

}
