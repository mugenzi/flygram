package com.flygram.Domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountFollowship {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "follower")
	private AccountProfile follower;

	@ManyToOne
	@JoinColumn(name = "following")
	private AccountProfile following;

	private LocalDateTime date;

	private boolean follow;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AccountProfile getFollower() {
		return follower;
	}

	public void setFollower(AccountProfile follower) {
		this.follower = follower;
	}

	public AccountProfile getFollowing() {
		return following;
	}

	public void setFollowing(AccountProfile following) {
		this.following = following;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean isFollow() {
		return follow;
	}

	public void setFollow(boolean follow) {
		this.follow = follow;
	}

	@Override
	public String toString() {
		return "AccountFollowship [id=" + id + ", follower=" + follower + ", following=" + following + ", date=" + date
				+ ", follow=" + follow + "]";
	}

}
