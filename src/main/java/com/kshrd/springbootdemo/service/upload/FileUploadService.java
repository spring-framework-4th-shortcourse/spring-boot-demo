package com.kshrd.springbootdemo.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	
	public String upload(MultipartFile file);
	
}
