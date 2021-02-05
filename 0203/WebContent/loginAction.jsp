<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String mid = request.getParameter("mid");

	Integer tempValue = (Integer) session.getAttribute("captcha");

	if (mid.equals(tempValue.toString())) {
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
<%
	} else {
		response.sendRedirect("/login.jsp");
	}
%>