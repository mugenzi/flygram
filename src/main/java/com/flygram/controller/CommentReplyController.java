package com.flygram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.CommentReply;
import com.flygram.Domain.PostComment;
import com.flygram.service.ICommentReplyService;
import com.flygram.service.IPostCommentService;


@RestController
public class CommentReplyController {
	
	
		@Autowired
		ICommentReplyService service;
		
		@PostMapping("/createCommentReply")
		public CommentReply createCommentReply(@RequestBody CommentReply reply) {
			CommentReply object = null;
			try {	
					return service.createCommentReply(reply);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return object;
		}

		
		@GetMapping("/findCommentReplyById/{id}")
		public CommentReply CommentReplyById(@PathVariable long id) {
			try {
				return service.findById(id);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}


		@GetMapping("/findReplyByAccount")
		public List<CommentReply> findByAccount(@RequestBody AccountProfile account)
		 {
			try {
				return service.findByAccount(account);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		@GetMapping("/findReplyByComment")
		public List<CommentReply> findByComment(@RequestBody PostComment comment)
		 {
			try {
				return service.findByComment(comment);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		@GetMapping("/findAllCommentReply")
		public List<CommentReply> findAllCommentReply() {
			return service.findAll();
		}
}
