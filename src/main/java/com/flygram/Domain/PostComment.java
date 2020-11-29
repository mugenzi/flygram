package com.flygram.Domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  id;
	private LocalDateTime commentDate;
	private String description;

	@ManyToOne
	@JoinColumn(name = "post")
	private Post post;

	@ManyToOne
	@JoinColumn(name = "account")
	private AccountProfile account;

	@OneToMany(mappedBy = "comment")
	private List<CommentReply> replyList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public AccountProfile getAccount() {
		return account;
	}

	public void setAccount(AccountProfile account) {
		this.account = account;
	}

	public List<CommentReply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<CommentReply> replyList) {
		this.replyList = replyList;
	}

}
