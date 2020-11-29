package com.flygram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;

public interface AccountFollowshipDao extends CrudRepository<AccountFollowship, Long> {

	public AccountFollowship findById(long id);

	public List<AccountFollowship> findAll();

	public AccountFollowship findByFollower(AccountProfile account);

	public AccountFollowship findByFollowing(AccountProfile account);

//	public boolean follow(AccountFollowship account);
//
//	public boolean unFollow(AccountFollowship account);

//	public boolean unFollow(AccountProfile account);
//
//	public List<AccountProfile> findFollowers(AccountProfile account);
//
//	public List<AccountProfile> findFollowing(AccountProfile account);

}
