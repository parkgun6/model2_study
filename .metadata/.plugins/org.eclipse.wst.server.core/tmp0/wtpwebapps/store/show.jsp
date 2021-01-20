<%@ page language="java" contentType="image/jpeg"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>

<%
	FileInputStream fin = new FileInputStream("C:\\zzz\\bbb.jpg");
	OutputStream os = response.getOutputStream();

	byte[] buffer = new byte[1024*8];
	while(true){
		int count = fin.read(buffer);
		if(count == -1){break;}
		os.write(buffer,0,count);
	}
%>
