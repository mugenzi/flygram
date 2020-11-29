package com.flygram.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.PostLike;
import com.flygram.dao.PostDao;
import com.flygram.service.IPostService;
import com.util.FlyGramConstant;

@Service
@Transactional
public class PostServiceImpl implements IPostService {
	private static final Logger LOGGER = Logger.getLogger(PostServiceImpl.class);

	@Autowired
	private PostDao dao;

	@Autowired
	ServletContext servletContext;

	@Override
	public Post createPost(Post post) {
		Post object = null;
		try {
			// Add the Logged User to the Servelet Session
			AccountProfile account = (AccountProfile) servletContext
					.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
			post.setAccount(account);
			post.setPostDate(LocalDateTime.now());
			object = dao.save(post);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public List<Post> findAllPostByAccount(AccountProfile account) {
		List<Post> list = new ArrayList<>();
		try {
			list = dao.findByAccount(account);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@Override
	public List<Post> findAllPost() {
		List<Post> list = new ArrayList<>();
		try {
			list = dao.findAll();
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@Override
	public void deletePost(Post post) {
		try {
			Post postToDelete = (Post) dao.findById(post.getId());
			dao.delete(postToDelete);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
	}

	@Override
	public Post findPostById(long id) {
		Post object = null;
		try {
			object = dao.findById(id);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public List<PostComment> findCommentByPost(Post post) {
		return post.getPostCommentList();
	}

	@Override
	public List<PostLike> findLikeByPost(Post post) {
		return post.getPostLikeList();
	}

	@Override
	public List<Post> findPostByLocation(String location) {
		List<Post> list = new ArrayList<Post>();
		try {
			list = dao.findByLocation(location);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@Override
	public long countAllPostByAccount(AccountProfile account) {
		return account.getPostList().size();
	}

	@Override
	public long countCommentByPost(Post post) {
		return post.getPostCommentList().size();
	}

	@Override
	public long countLikeByPost(Post post) {
		return post.getPostLikeList().size();
	}

}
