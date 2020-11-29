package com.flygram.Domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountProfileStatus {

	@Id
	private UUID id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private EAccountProfileStatus status;
	
	@ManyToOne
	@JoinColumn(name = "account")
	private AccountProfile account;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public EAccountProfileStatus getStatus() {
		return status;
	}

	public void setStatus(EAccountProfileStatus status) {
		this.status = status;
	}

	public AccountProfile getAccount() {
		return account;
	}

	public void setAccount(AccountProfile account) {
		this.account = account;
	}

}
