<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글씨기</h1>
	
	<form action="/p02/board/write" method="post">
		
		<label> 제목 : </label>
		<input type="text" name="title">
		<br>
		<label> 내용 : </label>
		<textarea name="content"></textarea>
		<br>
		<input type="submit" value="작 성">
	</form>
</body>
</html>