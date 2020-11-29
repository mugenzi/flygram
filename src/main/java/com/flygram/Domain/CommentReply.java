package com.flygram.Domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommentReply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String description;

	@ManyToOne
	@JoinColumn(name = "comment")
	private PostComment comment;
	
	@ManyToOne
	@JoinColumn(name = "account")
	private AccountProfile account;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PostComment getComment() {
		return comment;
	}

	public void setComment(PostComment comment) {
		this.comment = comment;
	}

	public AccountProfile getAccount() {
		return account;
	}

	public void setAccount(AccountProfile account) {
		this.account = account;
	}

}
