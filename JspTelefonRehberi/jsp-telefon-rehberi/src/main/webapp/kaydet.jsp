<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="org.ismek.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!List<Rehber> rehberList = new ArrayList<Rehber>();%>

	<%!void kaydet(HttpServletRequest request) {
		String isim = request.getParameter("isim");
		String telefon = request.getParameter("tel");
		Rehber rehber = new Rehber(isim, telefon);
		rehberList.add(rehber);
		System.out.print(rehberList.size());
	}%>

	<%
		kaydet(request);
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
				<%
					if (rehberList != null)
						for (Rehber rehber : rehberList) {
				%>
				<tr>
					<td><%=rehber.getIsim()%></td>
					<td><%=rehber.getTelefon()%></td>
				<tr>
					<%
						}
					%>
			</tbody>
		</table>
	</div>

	<a href="index.html">Yeni Ekle</a></ body>
</html>