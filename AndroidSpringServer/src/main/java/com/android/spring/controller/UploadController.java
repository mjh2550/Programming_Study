package com.android.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.android.spring.domain.FileBoardVO;
import com.android.spring.service.BoardService;

@Controller
public class UploadController {
	
	@Autowired
	private BoardService boardservice;

		//업로드 될 폴더 경로
		private static final String FILE_PATH = "C:\\testfolder\\upload";
		
		@RequestMapping(value = "upload.do", method = RequestMethod.GET)
		public String link() {
			return "appBoard/updownBoard";
		}
		
		
		@RequestMapping(value = "upload.do", method = RequestMethod.POST)
		public String upload(@RequestParam("uploadFile")MultipartFile file,
				     Model model,FileBoardVO vo) throws IllegalStateException, IOException {
			String fileName = file.getOriginalFilename();
			
			if(!file.getOriginalFilename().isEmpty()) {
				
				File dir = new File(FILE_PATH);
				String[] filenames = dir.list();
				for (int i = 0; i < filenames.length; i++) {
					if(filenames[i].equals(fileName)) {//겹치는 파일 명 있으면 msg리턴후 컨트롤러 바로 종료
						model.addAttribute("msg", "업로드 폴더 내에 같은 파일이 있습니다.");
						return "appBoard/updownBoard";
						
					}else {
				    System.out.println("file: " + filenames[i]);
					}
				}
				
				
				//DB에 저장 성공시 업로드
				vo.setUploadFileName(fileName);
				vo.setFilePath(FILE_PATH);
				if(boardservice.uploadfile(vo)) {
					file.transferTo(new File(FILE_PATH, fileName));
					model.addAttribute("msg", "File uploaded successfully.");
					model.addAttribute("fileName", fileName);
					
				}else {
					model.addAttribute("msg", "Upload Fail.");
				}
				
				
			}else {
				model.addAttribute("msg", "Please select a valid mediaFile..");
			}
			
			return "appBoard/updownBoard";
		}
	
}
