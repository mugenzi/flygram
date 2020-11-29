package com.flygram.security;

import java.io.Serializable;

import com.flygram.Domain.AccountProfile;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	public AccountProfile acc;
	public JwtResponse(String jwttoken,AccountProfile acc) {
		this.jwttoken = jwttoken;
		this.acc = acc;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public AccountProfile getUser() {
		return acc;
	}
}