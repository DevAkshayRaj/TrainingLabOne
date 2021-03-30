<%@page import="databaseutils.ItemDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Shop</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="Logout.jsp"></jsp:include>
	<div class="container">
		<figure class="text-center">
			<blockquote class="blockquote">
				<h3><kbd>Selected Items</kbd></h3>
			</blockquote>
		</figure>
				<%
		if (session.getAttribute("invno") != null) {
			int invno = Integer.parseInt((String) session.getAttribute("invno"));
			Properties ps = (Properties) request.getServletContext().getAttribute("properties");
			ArrayList<ItemDetails> data = (ArrayList<ItemDetails>)session.getAttribute("invoice");

			out.println("<table class=\"table table-striped\">");
			out.println("  <thead>");
			out.println("    <tr>");
			out.println("       <th scope=\"col\">#</th>");
			out.println("      <th scope=\"col\">Item Number</th>");
			out.println("      <th scope=\"col\">Item Quantity</th>");
			out.println("    </tr>");
			out.println("  </thead>");
			out.println("  <tbody>");
			for (int i = 0; i < data.size(); i++) {
				out.println("    <tr>");
				out.println("      <th scope=\"row\">" + (i +1) + "</th>");
				out.println("      <td>" + data.get(i).getItemno() + "</td>");
				out.println("      <td>" + data.get(i).getQty() + "</td>");
				out.println("    </tr>");
			}
			out.println("  </tbody>");
			out.println("</table>");
		}
		%>
	<form action="shop.do;jsessionid=<%=session.getId()%>" method="post">
<input type="hidden"  name="formid" value="Invoice">

			<div class="d-grid gap-2 col-6 mx-auto">
				<button class="btn btn-primary" type="submit">Generate Invoice</button>
			</div>
</form>
</div>
</body>
</html>