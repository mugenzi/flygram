package com.flygram.Domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class AccountProfile {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountId;

	private String website;
	private String biography;
	private String gender;

	@Lob
	private byte[] profilePic;

	@Transient
	private String path;

	private LocalDateTime creationDate;
	@OneToOne
	@JoinColumn(name = "user")
	private User user;
	private EAccountPrivacy privacy;
	private EAccountProfileStatus status;

	@OneToMany(mappedBy = "account")
	private List<PostLike> postLikeList;

	@OneToMany(mappedBy = "account")
	private List<PostComment> postCommentList = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	private List<Post> postList;

	@OneToMany(mappedBy = "account")
	private List<CommentReply> commentReplyList = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	private List<AccountProfileStatus> accountStatusList = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	private List<AccountPrivacy> privacyList = new ArrayList<>();

	@OneToMany(mappedBy = "following")
	private List<AccountFollowship> followingList = new ArrayList<>();

	@OneToMany(mappedBy = "follower")
	private List<AccountFollowship> followerList = new ArrayList<>();

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBiography() {
		return biography;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte[] getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EAccountPrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(EAccountPrivacy privacy) {
		this.privacy = privacy;
	}

	public EAccountProfileStatus getStatus() {
		return status;
	}

	public void setStatus(EAccountProfileStatus status) {
		this.status = status;
	}

	public List<AccountFollowship> getFollowingList() {
		return followingList;
	}

	public void setFollowingList(List<AccountFollowship> followingList) {
		this.followingList = followingList;
	}

	public List<AccountFollowship> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(List<AccountFollowship> followerList) {
		this.followerList = followerList;
	}

	public List<AccountPrivacy> getPrivacyList() {
		return privacyList;
	}

	public void setPrivacyList(List<AccountPrivacy> privacyList) {
		this.privacyList = privacyList;
	}

	public List<AccountProfileStatus> getAccountStatusList() {
		return accountStatusList;
	}

	public void setAccountStatusList(List<AccountProfileStatus> accountStatusList) {
		this.accountStatusList = accountStatusList;
	}

	public List<PostComment> getPostCommentList() {
		return postCommentList;
	}

	public void setPostCommentList(List<PostComment> postCommentList) {
		this.postCommentList = postCommentList;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public List<CommentReply> getCommentReplyList() {
		return commentReplyList;
	}

	public void setCommentReplyList(List<CommentReply> commentReplyList) {
		this.commentReplyList = commentReplyList;
	}

	public List<PostLike> getPostLikeList() {
		return postLikeList;
	}

	public void setPostLikeList(List<PostLike> postLikeList) {
		this.postLikeList = postLikeList;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
