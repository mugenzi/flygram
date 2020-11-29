package com.flygram.Domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Post {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private LocalDateTime postDate;
	private String caption;
	private String location;

	@Transient
	private String path;

	@Transient
	private byte[] photo;
	
	@OneToMany(mappedBy = "post")
	private List<PostStatus> postStatusList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostLike> postLikeList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostComment> postCommentList = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "account")
	private AccountProfile account;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public AccountProfile getAccount() {
		return account;
	}

	public void setAccount(AccountProfile account) {
		this.account = account;
	}

	public List<PostComment> getPostCommentList() {
		return postCommentList;
	}

	public void setPostCommentList(List<PostComment> postCommentList) {
		this.postCommentList = postCommentList;
	}

	public List<PostLike> getPostLikeList() {
		return postLikeList;
	}

	public void setPostLikeList(List<PostLike> postLikeList) {
		this.postLikeList = postLikeList;
	}

	public List<PostStatus> getPostStatusList() {
		return postStatusList;
	}

	public void setPostStatusList(List<PostStatus> postStatusList) {
		this.postStatusList = postStatusList;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
