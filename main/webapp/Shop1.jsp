<%@page import="databaseutils.ItemDetailsMasterDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.ShopServiceImpl"%>
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
	<div class="container" style="padding: 3%;">
		<figure class="text-center" >
			<blockquote class="blockquote">
				<h3>
					<kbd>Fruit Shop!!</kbd>
				</h3>
			</blockquote>
		</figure>
		<form action="shop.do;jsessionid=<%=session.getId()%>" method="post">
			<%
			ShopServiceImpl getdata = ShopServiceImpl
					.getObject((Properties) request.getServletContext().getAttribute("properties"));
			ArrayList<ItemDetailsMasterDto> data = getdata.getDetails(1);
			for (int i = 0; i < data.size(); i += 2) {

				out.println("		<div class=\"row gx-5\">");
				out.println("			<div class=\"col-5\">");
				out.println("				<div class=\"p-5\">");
				out.println("					<div class=\"card\" style=\"width: 20rem;\">");
				out.println("						<img");
				out.println("							src=\"" + data.get(i).getUrl() + " \" ");
				out.println("							class=\"card-img-top\" alt=\"...\">");
				out.println("						<div class=\"card-body\">");
				out.println("							<h5 class=\"card-title\">" + data.get(i).getDesc() + "</h5>");
				out.println("							<p class=\"card-text\">Units :" + data.get(i).getUnits() + "\nPrice : "
				+ data.get(i).getPrice() + "</p>");
				out.println("                           <label for=\"" + data.get(i).getItemno()
				+ "\" class=\"form-label\">Select Quantity</label>");
				out.println(
				"							<input type=\"range\" class=\"form-range\" min=\"0\" max=\"50\" step=\"1\" value=\"0\" name=\""
						+ data.get(i).getItemno() + "\"> ");
				out.println("						</div>");
				out.println("					</div>");
				out.println("				</div>");
				out.println("			</div>");
				out.println("			<div class=\"col-5\">");
				out.println("				<div class=\"p-5\">");
				out.println("					<div class=\"card\" style=\"width: 20rem;\">");
				out.println("						<img");
				out.println("							src=\"" + data.get(i + 1).getUrl() + " \" ");
				out.println("							class=\"card-img-top\" alt=\"...\">");
				out.println("						<div class=\"card-body\">");
				out.println("							<h5 class=\"card-title\">" + data.get(i + 1).getDesc() + "</h5>");
				out.println("							<p class=\"card-text\">Units :" + data.get(i + 1).getUnits() + "\nPrice : "
				+ data.get(i + 1).getPrice() + "</p>");
				out.println("                           <label for=\"" + data.get(i + 1).getItemno()
				+ "\" class=\"form-label\">Select Quantity</label>");
				out.println(
				"							<input type=\"range\" class=\"form-range\" min=\"0\" max=\"50\" value=\"0\" step=\"1\" name=\""
						+ data.get(i + 1).getItemno() + "\"> ");
				out.println("						</div>");
				out.println("					</div>");
				out.println("				</div>");
				out.println("			</div>");
				out.println("		</div>");

			}
			%>
			<input type="hidden" name="formid" value="shop"> 
			<input type="hidden" name="shopid" value="shop1">
			<div class="d-grid gap-2 col-6 mx-auto">
				<button class="btn btn-primary" type="submit">Shop Two</button>
			</div>

		</form>
	</div>
</body>
</html>

