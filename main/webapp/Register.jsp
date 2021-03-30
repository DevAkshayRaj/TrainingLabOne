<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
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
<div class="container" >
				<figure class="text-center" style="padding:3%;">
			<blockquote class="blockquote">
				<h3><kbd>Registration Page</kbd></h3>
			</blockquote>
		</figure>
		<form class="row g-3" action="Register.do;jsessionid=<%=session.getId()%>"
		method="post">
		<input type="hidden" name="formid" value="register">
			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">Username</label> 
				<input
					type="text" class="form-control" id="inputEmail4" name="uname">
			</div>
			<div class="col-md-6">
				<label for="inputPassword4" class="form-label">Password</label> 
				<input
					type="password" class="form-control" id="inputPassword4" name="upass">
			</div>
			<div class="col-12">
				<label for="inputAddress" class="form-label">Address</label> 
				<input
					type="text" class="form-control" id="inputAddress"
					placeholder="1234 Main St" name="address">
			</div>
			<div class="col-12">
				<label for="inputAddress2" class="form-label">Phone Number</label> 
				<input
					type="text" class="form-control" id="inputAddress2"
					placeholder="Please enter phone number...." name="phone">
			</div>
			<div class="col-md-6">
				<label for="inputCity" class="form-label">Email</label> 
				<input
					type="email" class="form-control" id="inputCity" name="email">
			</div>
					<div class="d-grid gap-2 col-12 mx-auto">
				<button class="btn btn-primary" type="submit" name="register">Register</button>
			</div>
		</form>
	</div>
</body>
</html>