package com.flygram.Domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PostStatus {

	@Id
	private UUID id;
	@ManyToOne
	@JoinColumn(name = "post")
	private Post post;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private EPostStatus status;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public EPostStatus getStatus() {
		return status;
	}

	public void setStatus(EPostStatus status) {
		this.status = status;
	}

}
