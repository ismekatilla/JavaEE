<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="org.ismek.*"%>
<%@ page import="org.ismek.db.*"%>
<%@ page import="javax.servlet.http.Cookie"%>
<%@ page import="com.google.gson.Gson"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="rehber" class="org.ismek.Rehber"></jsp:useBean>
	<jsp:setProperty property="*" name="rehber" />
	<%
		RehberDao rehberDao = new RehberDao();
		rehberDao.rehberEkle(rehber);
		List<Rehber> rehberList = rehberDao.rehberListesiGetir();
		request.setAttribute("rehberList", rehberList);
	%>
	
	<% 
		Gson gson = new Gson();
	 	String rehberListAsJson = gson.toJson(rehberList);
		Cookie cookie = new Cookie("rehberList", rehberListAsJson);
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
	%>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>İsim</th>
					<th>Telefon</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${rehberList}">
					<tr>
						<td>${r.getIsim()}</td>
						<td>${r.getTelefon()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<a href="index.html">Yeni Ekle</a>
	<a href="cookie.jsp">Cookies</a>
</body>
</html>