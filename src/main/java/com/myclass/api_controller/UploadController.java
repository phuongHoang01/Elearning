package com.myclass.api_controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
	@PostMapping("api/file")
	public Object post(MultipartFile file,HttpServletRequest request) {
		try {
			//Lấy đường dẫn tuyệt dối dường dẫn ở server nó khác với đường dẫn ở máy tính đây là dường dẫn tới máy tính
			
			String folderPath = request.getServletContext().getRealPath("/WEB-INF/assets/upload/");
			File dirFile = new File(folderPath);
			System.out.println(folderPath);
			if(!dirFile.exists()) {
				dirFile.mkdir();
			}
			
			
			String genRandom = UUID.randomUUID().toString();
			String fileName = genRandom + "_" + file.getOriginalFilename();
			File filePath = new File(folderPath+fileName);
			filePath.createNewFile();
			System.out.println(filePath);
			file.transferTo(filePath);
			return new ResponseEntity<String>("/upload/"+fileName,HttpStatus.OK);

		} catch (IllegalStateException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
