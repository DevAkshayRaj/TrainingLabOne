<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Expired</title>
</head>
<body>
<h1>Session Expired Due to Inactivity!!!</h1>
<h3>Please Login again</h3>
	<form action="LoginAgain.do;jsessionid=<%=session.getId()%>" method="post">
	<input type="hidden" name="formid" value="sessionexpired">
	<input type="submit" value="Login Again..." />
	</form>
</body>
</html>