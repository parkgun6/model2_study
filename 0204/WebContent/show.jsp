<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<%
		Cookie[] arr = request.getCookies();
		for(int i = 0; i < arr.length; i++){
			Cookie ck = arr[i];	
		
	%>
	<li><%=ck.getName() %>	<%=ck.getValue() %></li>
	<%
		}
	%>
</ul>
</body>
</html>