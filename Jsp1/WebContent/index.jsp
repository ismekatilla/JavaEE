<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp1</title>
</head>
<body>

	<% 
		int b = carp(3, 4);
		out.print(b); 
	%>

	<%! int carp(int a, int b) {
		return a * b;
	}
	
	int asd = 135;
	%>
	
	<%= asd %>
</body>
</html>
