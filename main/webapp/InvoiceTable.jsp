<%@page import="java.util.Properties"%>
<%@page import="java.util.ArrayList"%>
<%@page import="databaseutils.InvoiceGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice Summary</title>
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
				<h3><kbd>Export Options</kbd></h3>
			</blockquote>
		</figure>
		<form action="generate.do" method="post">
			<input type="hidden" name="formid" value="download">
			<div class="row row-cols-1 row-cols-md-2 g-4">
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Print Invoice to PDF</h5>
							<p class="card-text">Download the whole Invoice as an PDF
								File.</p>
							<input class="btn btn-primary" type="submit" value="Generate PDF"
								name="pdf">

						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Print Invoice to Excel</h5>
							<p class="card-text">Download the whole Invoice as an Excel
								File.</p>
							<input class="btn btn-primary" type="submit"
								value="Generate Excel" name="excel">
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Send The Invoice as Email</h5>
							<p class="card-text">Send the whole invoice as an Email to
								the Customer's Email id.</p>
							<input class="btn btn-primary" type="submit" value="Send Email"
								name="email">
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Send The Invoice as SMS</h5>
							<p class="card-text">Send the customer name, final amount and
								the invoice number as SMS.</p>
							<input class="btn btn-primary" type="submit" value="Send SMS"
								name="sms">
						</div>
					</div>
				</div>
			</div>
		</form>
				<figure class="text-center">
			<blockquote class="blockquote">
				<h3><kbd>Invoice Receipt</kbd></h3>
			</blockquote>
		</figure>
		<%
		if (session.getAttribute("invno") != null) {
			int invno = Integer.parseInt((String) session.getAttribute("invno"));
			Properties ps = (Properties) request.getServletContext().getAttribute("properties");
			InvoiceGenerator ig = InvoiceGenerator.getObj(ps);
			ArrayList<ArrayList<String>> data = ig.getInvoice(invno);

			out.println("<table class=\"table table-striped\">");
			out.println("  <thead>");
			out.println("    <tr>");
			out.println("       <th scope=\"col\">#</th>");
			out.println("      <th scope=\"col\">Item Number</th>");
			out.println("      <th scope=\"col\">Item Description</th>");
			out.println("      <th scope=\"col\">Item Units</th>");
			out.println("      <th scope=\"col\">Item Price</th>");
			out.println("      <th scope=\"col\">Item Quantity</th>");
			out.println("      <th scope=\"col\">Amount</th>");
			out.println("    </tr>");
			out.println("  </thead>");
			out.println("  <tbody>");
			ArrayList<String> a = data.remove((data.size() - 1));
			int h[] = new int[a.size()];
			for (int i = 0; i < a.size(); i++) {
				h[i] = Integer.parseInt(a.get(i));
			}
			for (int i = 5; i < h[h.length - 1]; i++) {
				out.println("    <tr>");
				out.println("      <th scope=\"row\">" + (i - 4) + "</th>");
				out.println("      <td>" + data.get(i).get(0) + "</td>");
				out.println("      <td>" + data.get(i).get(1) + "</td>");
				out.println("      <td>" + data.get(i).get(2) + "</td>");
				out.println("      <td>" + data.get(i).get(3) + "</td>");
				out.println("      <td>" + data.get(i).get(4) + "</td>");
				out.println("      <td>" + data.get(i).get(5) + "</td>");
				out.println("    </tr>");
			}
			out.println("  </tbody>");
			out.println("</table>");
		}
		%>
	</div>
</body>
</html>