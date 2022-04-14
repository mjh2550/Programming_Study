package com.android.spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DownloadController {

		//다운로드 할 파일을 가져올 폴더 경로
		private static final String FILE_PATH = "C:\\testfolder\\upload";
		
		@RequestMapping("download.do")
		@ResponseBody
		public byte[] download(HttpServletResponse response,@RequestParam String item) throws IOException{
			File file = new File(FILE_PATH, item);
			
			byte[] bytes = FileCopyUtils.copyToByteArray(file);
			
			String fn = new String(file.getName().getBytes(), "utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
			response.setContentLength(bytes.length);
			
			return bytes;
		}
	

}
