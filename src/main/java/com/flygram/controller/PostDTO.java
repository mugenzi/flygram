package com.flygram.controller;

import org.springframework.web.multipart.MultipartFile;

public class PostDTO {

	private String caption;

	private MultipartFile file;

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	 

}
