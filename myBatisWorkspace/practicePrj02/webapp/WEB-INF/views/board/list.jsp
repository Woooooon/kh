<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	
	<form action="" method="get">
		<select name="category">
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	
	<table border="1">
		<tr>
			<td>제목</td>
			<td>내용</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${voList}" var="i">
		<tr>
			<td>${i.title}</td>
			<td>${i.content}</td>
			<td>${i.enrollDate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>