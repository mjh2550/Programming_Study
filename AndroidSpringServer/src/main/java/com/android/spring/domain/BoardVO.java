package com.android.spring.domain;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BoardVO {
	int SEQ, CNT;
	String TITLE, WRITER, CONTENT;
	Date REGDATE;
	public int getSeq() {
		return SEQ;
	}
	public void setSeq(int seq) {
		this.SEQ = seq;
	}
	public int getCnt() {
		return CNT;
	}
	public void setCnt(int cnt) {
		this.CNT = cnt;
	}
	public String getTitle() {
		return TITLE;
	}
	public void setTitle(String title) {
		this.TITLE = title;
	}
	public String getWriter() {
		return WRITER;
	}
	public void setWriter(String writer) {
		this.WRITER = writer;
	}
	public String getContent() {
		return CONTENT;
	}
	public void setContent(String content) {
		this.CONTENT = content;
	}
	public Date getRegdate() {
		return REGDATE;
	}
	public void setRegdate(Date regdate) {
		this.REGDATE = regdate;
	}



}
