package com.flygram.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountPrivacy {

	private static final long serialVersionUID = 1L;
	@Id
	private long id;

	private EAccountPrivacy privacy;

	@ManyToOne
	@JoinColumn(name = "account")
	private AccountProfile account;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EAccountPrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(EAccountPrivacy privacy) {
		this.privacy = privacy;
	}

	public AccountProfile getAccount() {
		return account;
	}

	public void setAccount(AccountProfile account) {
		this.account = account;
	}

}
