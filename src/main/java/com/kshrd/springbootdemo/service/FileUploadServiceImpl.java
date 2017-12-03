package com.kshrd.springbootdemo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService{
	
	private String UPLOADED_FOLDER = "/images/";
	
	@Override
	public String upload(MultipartFile file) {
		System.out.println(file);
		if(file.isEmpty())
			return null;
		
		String fileName = null;
		try {
			fileName =  generateFileName(file.getOriginalFilename());
			
			byte[]bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + fileName);
			Files.write(path, bytes);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/resources/" + fileName;
	}
	
	private String generateFileName(String file){
		String ext = file.substring(file.lastIndexOf("."));
		String fileName = System.currentTimeMillis() + ext;
		return fileName;
	}

}
