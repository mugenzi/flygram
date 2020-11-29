package com.flygram.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.CommentReply;
import com.flygram.Domain.PostComment;
import com.flygram.dao.CommentReplyDao;
import com.flygram.dao.PostCommentDao;
import com.flygram.service.ICommentReplyService;
import com.flygram.service.IPostCommentService;


@Service
@Transactional
public class CommentReplyServiceImpl implements ICommentReplyService{

	private static final Logger LOGGER = Logger.getLogger(CommentReplyServiceImpl.class);

	@Autowired
	private CommentReplyDao dao;

	@Override
	public CommentReply createCommentReply(CommentReply reply) {
		CommentReply  object = null;
		try {
			
			//reply.setAccount(null);
			object = dao.save(reply);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}
	
	@Override
	public CommentReply findById(long id)
	{
		CommentReply reply = null;
		try {
			reply = dao.findById(id);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return reply;
	}

	@Override
	public List<CommentReply> findByAccount(AccountProfile account){
		
		List<CommentReply> list = new ArrayList<>();
		try {
			list = dao.findByAccount(account);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}
	@Override
	public List<CommentReply> findByComment(PostComment comment)
	{
		
		List<CommentReply> list = new ArrayList<>();
		
		try {
			list=(List<CommentReply>) dao.findByComment(comment);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
		
	}
	@Override
	public List<CommentReply> findAll()
	{
		
		List<CommentReply> list = new ArrayList<>();
		try {
			list =  (List<CommentReply>)dao.findAll();
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}
}
