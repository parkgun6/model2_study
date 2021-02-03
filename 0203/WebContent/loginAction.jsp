<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = request.getParameter("mid");

	if(mid != null){
		session.setAttribute("userName", mid);
	}
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login success</h1>
</body>
</html>