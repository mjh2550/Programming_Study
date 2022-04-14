<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>파일 업/다운로드</title>
</head>
 <body>
	<h3>파일 업로드</h3>
	<form action="upload.do" method="post" enctype="multipart/form-data">
	 	첨부할 파일 : <input type="file" name="uploadFile" />
	
		 <button type="submit">Upload</button>
		 ${msg }
	</form>
	<br>
	<input type="button" value="앱 목록으로" style="float: right;" onclick="location.href='appBoardList.do'">
	<input type="button" value="게시판 목록으로" style="float: right;" onclick="location.href='boardList.do'"><br>
	<%-- 
	<h3>파일 다운로드</h3>
	<form action="download.do" method="post">
		<input type="hidden" name="filename" value="${fileName}">
		<input type="submit" value="다운로드">
	</form> --%>
	
 </body>
</html>
