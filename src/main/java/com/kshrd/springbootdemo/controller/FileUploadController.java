package com.kshrd.springbootdemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@GetMapping("/file")
	public String upload() {
		return "upload";
	}

	private String UPLOADED_FOLDER = "/images/";

	@PostMapping("/upload")
	public String upload(Model model, @RequestParam("file") MultipartFile file) {
	
		System.out.println("File: " + file.getOriginalFilename());
		try {
			// filename.ext
			String fileName =  generateFileName(file.getOriginalFilename());
			
			byte[]bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + fileName);
			Files.write(path, bytes);
			
			model.addAttribute("filePath", "/resources/" + fileName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "upload";
	}

	private String generateFileName(String file){
		String ext = file.substring(file.lastIndexOf("."));
		String fileName = System.currentTimeMillis() + ext;
		return fileName;
	}
}
