<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
    <%@ page import="com.android.spring.domain.BoardVO" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>앱 목록</title>
</head>
<style>
	h2 {
		text-align: center;
	}
	table {
		width: 100%;
	}
	#outter {
		display: block;
		width: 60%;
		margin: auto;
	}
	a {
		text-decoration: none;
	}
</style>
<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="boardList.do?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
	
</script>
<body>
<h2>첨부파일 관리</h2>

<div id="outter">
	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
			<option value="10"
				<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
			<option value="15"
				<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div> <!-- 옵션선택 끝 -->
	
<table  border=1>

<tr>
	<td>순번</td>
	<td>업로더</td>
	<td>제목</td>
	<td>파일명</td>
	<td>파일경로</td>
	<td>업로드일시</td>
	<td>사용유무</td>
</tr>		


<c:forEach var="item" items="${appViewAll}">
<tr>
	<td><c:out value="${item.num}"></c:out></td>
	<td><c:out value="${item.uploader}"></c:out>
	<%-- <a href="viewBoard.do?title=${item.title}&content=${item.content}&cnt=${item.cnt}&seq=${item.seq}">
	<c:out value="${item.title}"></c:out></a> --%></td>
	<td><c:out value="${item.title}"></c:out></td>
	<td><a href="download.do?item=${item.uploadFileName}"><c:out value="${item.uploadFileName}"></c:out></a></td>
	<td><c:out value="${item.filePath}"></c:out></td>
	<td><c:out value="${item.day}"></c:out></td>
	<td><c:out value="${item.USEYN}"></c:out>
	<%-- <c:choose>
	<c:when test="${item.USEYN eq Y}" >
	<c:out value="YES"></c:out>
	<td><c:out value="NO"></c:out></td>
	</c:when>
	
	<c:otherwise> 
	<c:out value="NO"></c:out>
	<td><c:out value="YES"></c:out></td>
	</c:otherwise>
	</c:choose> --%>
	</td>
	</tr>
	
	 </c:forEach>
</table>
	<input type="button" value="앱 업로드" style="float: right;" onclick="location.href='upload.do'"><br>
	
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="boardList.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="boardList.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="boardList.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
</div>
</body>
</html>