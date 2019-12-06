<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://fonts.googleapis.com/css?family=Roboto|Courgette|Pacifico:400,700"
	rel="stylesheet">
<title>Bootstrap Start Free Trail Sign up Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_eleven.png");
	font-family: 'Roboto', sans-serif;
}

.header h1 {
	font-size: 50px;
	padding: 55px;
	font-family: 'Pacifico', sans-serif;
}

.header {
	padding: 10px;
	height: 230px;
	text-align: center;
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/images.png");
}

.form-control {
	min-height: 41px;
	box-shadow: none;
	border-color: #e1e1e1;
}

.form-control:focus {
	border-color: #00cb82;
}

.form-control, .btn {
	border-radius: 3px;
}

.form-header {
	margin: -30px -30px 20px;
	padding: 30px 30px 10px;
	text-align: center;
	background: #329ced;
	border-bottom: 1px solid #eee;
	color: #fff;
}

.form-header h2 {
	font-size: 34px;
	font-weight: bold;
	margin: 0 0 10px;
	font-family: 'Pacifico', sans-serif;
}

.form-header p {
	margin: 20px 0 15px;
	font-size: 17px;
	line-height: normal;
	font-family: 'Courgette', sans-serif;
}

.signup-form {
	width: 390px;
	margin: 0 auto;
	padding: 30px 0;
}

.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #f0f0f0;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form label {
	font-weight: normal;
	font-size: 13px;
}

.signup-form input[type="checkbox"] {
	margin-top: 2px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	background: #329ced;
	border: none;
	min-width: 200px;
}

.signup-form .btn:hover, .signup-form .btn:focus {
	background: #0b7ed9 !important;
	outline: none;
}

.signup-form a {
	color: #329ced;
}

.signup-form a:hover {
	text-decoration: underline;
}
/* Footer */
.error
{
color: red;
}
.footer {
	padding: 15px;
	text-align: center;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="header">
		<h1>Expenses Tracker</h1>
		<h4 style="color:white">Welcome to Expenses Tracker</h4>
	</div>
	<div class="signup-form">
		<form:form action="${pageContext.request.contextPath}/addUserCredentials" method="post" modelAttribute="user">
			<div class="form-header">
				<h2>Sign Up</h2>
				<p>Fill out this form to start your free trial!</p>
			</div>
			<div class="form-group">
				<label>Username</label> 
				<form:input path="name" class="form-control" required="true"/>
				<form:errors path="name" cssClass="error"></form:errors>
			</div>
			<div class="form-group">
				<label>Email Address</label>
				<form:input path="email" class="form-control" required="true"/>
				<form:errors path="email" cssClass="error"></form:errors>
			</div>
			<div class="form-group">
				<label>Password</label> 
				<form:input type="password" path="password" class="form-control" required="true"/>
				length min:6 max:8 atleast one low and high alphabet and one number
				<form:errors path="password" cssClass="error"></form:errors>
			</div>
			<div class="form-group">
				<label>Confirm Password</label>
				 <form:input type="password" path="confirm_password" class="form-control" required="true"/>
				 length min:6 max:8 atleast one low and high alphabet and one number
				 <form:errors path="confirm_password" cssClass="error"></form:errors><br>
				 <form:errors path="check_passwords" cssClass="error"></form:errors>
			</div>
			<div class="form-group">
				<label class="checkbox-inline"><input type="checkbox"
					> I accept the <a href="#">Terms of
						Use</a> &amp; <a href="#">Privacy Policy</a></label>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block btn-lg">Sign
					Up</button>
			</div>
		</form:form>
		<div class="text-center small">
			Already have an account? <a href="/ExpensesTracker/login">Login
				here</a>
		</div>
		<div class="footer">
			<h3>Contacts</h3>
			<i class="glyphicon glyphicon-envelope"> subu2code@gmail.com</i>
		</div>
	</div>
</body>
</html>
