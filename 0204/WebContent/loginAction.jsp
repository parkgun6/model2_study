<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	Cookie ck = new Cookie("userCookie","HongGilDong");

	ck.setMaxAge(60*60*24*7*365);
	
	response.addCookie(ck);	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Cookie publishinshed</h1>
</body>
</html>