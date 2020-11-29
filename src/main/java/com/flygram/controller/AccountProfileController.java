package com.flygram.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flygram.Domain.AccountProfile;
import com.flygram.service.IAccountProfileService;
import com.util.FlyGramConstant;

@RestController
@CrossOrigin(origins = "http://localhost:9595", maxAge = 3600)
public class AccountProfileController {

	@Autowired
	IAccountProfileService service;

	@Autowired
	ServletContext servletContext;

	private byte[] fileContent;

	@PostMapping("/saveAccountProfile")
	public AccountProfile saveStudent(@RequestBody AccountProfile account) throws Exception {
		File imageFile = new File(account.getPath());
		try {
			byte[] fileContent = Files.readAllBytes(imageFile.toPath());
			if (fileContent.length > 429495295)
				throw new Exception("Your File Exceded Allowed Size (4GB)");
			account.setProfilePic(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return service.createAccountProfile(account);
	}

	@PutMapping("/updateAccountProfile/{id}")
	public AccountProfile updateStudent(@PathVariable("id") long id, @RequestBody AccountProfile acc) throws Exception {
		AccountProfile currentProfile = service.findAccountProfileById(id);
		currentProfile.setProfilePic(fileContent);
		currentProfile.setWebsite(acc.getWebsite());
		currentProfile.setBiography(acc.getBiography());
		currentProfile.setGender(acc.getGender());
		AccountProfile updatedAccount = service.updateAccountProfile(currentProfile);
		return updatedAccount;
	}

	@PostMapping("/upload")
	public AccountProfile singleFileUpload(@RequestParam("file") MultipartFile file) {
		AccountProfile account = (AccountProfile) servletContext
				.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
		try {
			byte[] bytes = file.getBytes();
			fileContent = bytes;
			Path path = Paths.get(file.getOriginalFilename());
			Files.write(path, bytes);
			account.setProfilePic(fileContent);
			AccountProfile acc = service.createAccountProfile(account);
			return acc;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@DeleteMapping("/removeAccountProfile{id}")
	public void removeStudent(@PathVariable long id) {
		try {
			AccountProfile account = service.findAccountProfileById(id);
			service.deleteAccountProfile(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/viewAccountProfiles")
	public List<AccountProfile> viewAccountProfiles() {
		return service.viewAccountProfile();
	}

	@GetMapping("/findAccountProfile{id}")
	public AccountProfile findAccountProfile(@PathVariable long id) {
		try {
			return service.findAccountProfileById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/getLoggedAccountProfile")
	public AccountProfile getLoggedAccountProfile() {
		try {
			System.out.print("Byagezeyo!!!!!!!!!!!!!!!!!!!!!!!!");
			return service.getLoggedAccountProfile();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/testing")
	public ResponseEntity<?> test() {
		return ResponseEntity.ok("Test Passed");
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

}
