<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션저장소에 있는걸 모두 무효화시킨다. 기본적으로 로그아웃함
	session.invalidate();
	//조금더 안전한 방법.
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOGOUT----------------</h1>
</body>
</html>