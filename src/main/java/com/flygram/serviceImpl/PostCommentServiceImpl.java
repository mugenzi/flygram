package com.flygram.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;
import com.flygram.dao.PostCommentDao;
import com.flygram.service.IPostCommentService;

@Service
@Transactional
public class PostCommentServiceImpl implements IPostCommentService {

	private static final Logger LOGGER = Logger.getLogger(AccountFollowshipServiceImpl.class);

	@Autowired
	private PostCommentDao dao;

	@Override
	public PostComment createPostComment(PostComment comment) {
		PostComment object = null;
		try {
			comment.setCommentDate(LocalDateTime.now());
			comment.setAccount(null);
			object = dao.save(comment);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public PostComment findPostCommentById(long id) {
		PostComment post = null;
		try {
			post = dao.findById(id);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return post;
	}

	@Override
	public List<PostComment> findPostCommentByAccount(AccountProfile account) {
		List<PostComment> list = new ArrayList<>();
		try {
			list = dao.findByAccount(account);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@Override
	public List<PostComment> findPostCommentByPost(Post post) {
		List<PostComment> list = new ArrayList<>();
		try {
			list = dao.findByPost(post);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@Override
	public List<PostComment> findAllPostComment() {
		List<PostComment> list = new ArrayList<>();
		try {
			list =  (List<PostComment>)dao.findAll();
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

}
