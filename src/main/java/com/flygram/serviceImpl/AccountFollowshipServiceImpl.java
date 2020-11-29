package com.flygram.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;
import com.flygram.dao.AccountFollowshipDao;
import com.flygram.service.IAccountFollowshipService;

@Service
@Transactional
public class AccountFollowshipServiceImpl implements IAccountFollowshipService {

	private static final Logger LOGGER = Logger.getLogger(AccountFollowshipServiceImpl.class);

	@Autowired
	private AccountFollowshipDao dao;

	@Override
	public AccountFollowship follow(AccountProfile follower, AccountProfile following) {
		AccountFollowship object = null;
		try {
			AccountFollowship newObject = new AccountFollowship();
			newObject.setFollower(follower);
			newObject.setFollowing(following);
			newObject.setFollow(true);
			newObject.setDate(LocalDateTime.now());
			object = dao.save(newObject);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public AccountFollowship unFollow(AccountFollowship accountFollowship) {
		AccountFollowship object = null;
		try {
			AccountFollowship accountFollowshipToUpdate = (AccountFollowship) dao.findById(accountFollowship.getId());
			accountFollowship.setFollow(false);
			dao.save(accountFollowshipToUpdate);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public List<AccountFollowship> findFollowers(AccountProfile account) {
		List<AccountFollowship> list = new ArrayList<>();
		try {
			list = account.getFollowerList();
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@Override
	public List<AccountFollowship> findFollowing(AccountProfile account) {
		List<AccountFollowship> list = new ArrayList<>();
		try {
			list = account.getFollowingList();
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@Override
	public AccountFollowship findAccountFollowshipById(long id) {
		return dao.findById(id);
	}

	@Override
	public AccountFollowship findByFollower(AccountProfile account) {
		return dao.findByFollower(account);
	}

	@Override
	public AccountFollowship findByFollowing(AccountProfile account) {
		return dao.findByFollowing(account);
	}

}
