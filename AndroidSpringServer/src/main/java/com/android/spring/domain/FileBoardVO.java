package com.android.spring.domain;

import org.springframework.stereotype.Component;

@Component
public class FileBoardVO {

	private String num;
	private String uploader;
	private String title;
	private String uploadFileName;
	private String filePath;
	private String day;
	private String USEYN;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getUSEYN() {
		return USEYN;
	}
	public void setUSEYN(String uSEYN) {
		USEYN = uSEYN;
	}
	
}
