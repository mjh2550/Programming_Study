<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>
    <%@ page import="com.android.spring.domain.BoardVO" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyBatis Test</title>

<script>
function move() {
	location.href="insertBoard.do";
}

</script>
</head>
<body>
<p>종합 게시판</p>
<br>
<br>


<table  border=1>



<tr>
	<td>순번</td>
	<td>제목</td>
	<td>글쓴이</td>
	<td>작성일시</td>
	<td>조회수</td>
</tr>		


<c:forEach var="item" items="${viewAll}">
<tr>
	<td><c:out value="${item.seq}"></c:out></td>
	<td><a href="viewBoard.do?title=${item.title}&content=${item.content}&cnt=${item.cnt}&seq=${item.seq}">
	<c:out value="${item.title}"></c:out></a></td>
	<td><c:out value="${item.writer}"></c:out></td>
	<td><c:out value="${item.regdate}"></c:out></td>
	<td><c:out value="${item.cnt}"></c:out></td>
</tr>

 </c:forEach>
</table>
<input type="button" value="글쓰기" onclick="move()"/>
</body>
</html>