<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${n > 0}">
		<h3>양수입니다</h3>
	</c:if>
	<c:if test="${n < 0}">
		<h3>음수입니다</h3>
	</c:if>
</body>
</html>