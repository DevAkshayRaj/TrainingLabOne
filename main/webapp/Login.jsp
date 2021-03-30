<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
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
<div class="container" style="padding:5%;">
				<figure class="text-center" >
			<blockquote class="blockquote">
				<h3><kbd>Login Page</kbd></h3>
			</blockquote>
		</figure>
	<form action="/ShoppingPage/login.do;jsessionid=<%=session.getId()%>"
		method="post">
		<input type="hidden" name="formid" value="login">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Username</label>
				 <input type="text" class="form-control"
				id="exampleInputEmail1" name="uname" aria-describedby="emailHelp">
			<div id="emailHelp" class="form-text">We'll never share your
				username with anyone else.</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label" >Password</label>
			<input type="password" class="form-control" name="upass"
				id="exampleInputPassword1">
		</div>
			<div class="d-grid gap-2 col-6 mx-auto">
				<button class="btn btn-primary" type="submit">Login</button>
			</div>
	</form>
	</div>
</body>
</html>