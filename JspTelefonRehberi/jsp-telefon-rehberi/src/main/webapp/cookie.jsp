<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.reflect.TypeToken"%>
<%@ page import="java.lang.reflect.Type"%>
<%@ page import="java.util.List"%>
<%@ page import="org.ismek.Rehber"%>
<%@ page isELIgnored="false" %>

<%
	Cookie[] cookieArray = request.getCookies();
	for (Cookie cookie : cookieArray) {
		if (cookie.getName().equals("rehberList")) {
			String rehberListAsJson = cookie.getValue();
			Gson gson = new Gson();
			Type listType = new TypeToken<List<Rehber>>() {
			}.getType();
			List<Rehber> rehberList = gson.fromJson(rehberListAsJson, listType);
			request.setAttribute("rehberList", rehberList);
		}
	}
%>

<c:forEach var="rehber" items="${rehberList}">
	${rehber.getIsim()}
</c:forEach>