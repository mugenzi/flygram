package com.flygram.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.User;
import com.flygram.security.JwtRequest;
import com.flygram.security.JwtResponse;
import com.flygram.security.UserDTO;
import com.flygram.securityconfig.JwtTokenUtil;
import com.flygram.service.IAccountProfileService;
import com.flygram.service.JwtUserDetailsService;
import com.flygram.service.UserService;
import com.util.FlyGramConstant;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private IAccountProfileService account;

	@Autowired
	private UserService userService;

	@Autowired
	ServletContext servletContext;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final User u = userService.findByUsername(authenticationRequest.getUsername());
		final AccountProfile acc = account.findAccountProfileByUser(u);
		final String token = jwtTokenUtil.generateToken(userDetails);

		// Add the Logged User to the Servelet Session
		servletContext.setAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE, acc);
		
		return ResponseEntity.ok(new JwtResponse(token, acc));
		// return ResponseEntity.ok(token);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
		try {
			return ResponseEntity.ok(userDetailsService.save(user));
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}

	private void authenticate(String userName, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}