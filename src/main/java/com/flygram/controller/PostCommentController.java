package com.flygram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;
import com.flygram.service.IPostCommentService;

@RestController
public class PostCommentController {
	
	@Autowired
	IPostCommentService service;
	
	@PostMapping("/createPostComment")
	public PostComment createPostComment(@RequestBody PostComment postComment) {
		PostComment object = null;
		try {	
				return service.createPostComment(postComment);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	@GetMapping("/findPostCommentById/{id}")
	public PostComment findPostCommentById(@PathVariable long id) {
		try {
			return service.findPostCommentById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/findPostCommentByAccount")
	public List<PostComment> findPostCommentByAccount(@RequestBody AccountProfile account)
	 {
		try {
			return service.findPostCommentByAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@GetMapping("/findAllPostComment")
	public List<PostComment> findAllPostComment() {
		return service.findAllPostComment();
	}
	
	@GetMapping("/findPostCommentByPost")
	public List<PostComment> findPostCommentByPost(@RequestBody Post post)
	{
		
		try {
			return service.findPostCommentByPost(post);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}