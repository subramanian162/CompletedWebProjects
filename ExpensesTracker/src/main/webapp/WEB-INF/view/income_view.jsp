<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Income</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto|Courgette|Pacifico:400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial;
	padding: 10px;
	margin: 0;
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_eleven.png");
}

.header {
	padding: 10px;
	height: 230px;
	text-align: center;
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/images.png");
}

.header h1 {
	font-size: 50px;
	font-family: 'Pacifico', sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.active {
	background-color: #4CAF50;
	color: white;
}

.topnav .icon {
	display: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 17px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: #333;
	font-family: inherit;
	margin: 0;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.topnav a:hover, .dropdown:hover .dropbtn {
	background-color: #555;
	color: white;
}

.dropdown-content a:hover {
	background-color: #ddd;
	color: black;
}

.dropdown:hover .dropdown-content {
	display: block;
}

@media screen and (max-width: 600px) {
	.topnav a:not (:first-child ), .dropdown .dropbtn {
		display: none;
	}
	.topnav a.icon {
		float: right;
		display: block;
	}
}

@media screen and (max-width: 600px) {
	.topnav.responsive {
		position: relative;
	}
	.topnav.responsive .icon {
		position: absolute;
		right: 0;
		top: 0;
	}
	.topnav.responsive a {
		float: none;
		display: block;
		text-align: left;
	}
	.topnav.responsive .dropdown {
		float: none;
	}
	.topnav.responsive .dropdown-content {
		position: relative;
	}
	.topnav.responsive .dropdown .dropbtn {
		display: block;
		width: 100%;
		text-align: left;
	}
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
	{
	width
	
	
	
	
	

	
	
	
	
	
	

	
	
	
	
	
	

	
	
	
	
	:
	
	
	
	
	

	
	
	
	
	
	
 

	
	
	
	
	
	

	
	
	
	
	100%;
	padding
	
	
	
	
	

	
	
	
	
	
	

	
	
	
	
	
	

	
	
	
	
	:
	
	
	
	
	

	
	
	
	
	
	

	
	
	
	
	
	

	
	
	
	
	0;
}

}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
	.topnav a {
		float: none;
		width: 100%;
	}
}

.formDiv {
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_ten.png");
	height: 500px;
	padding: 16px;
	margin: 45px
}

.button1 {
	background-color: #008CBA;
	color: white;
	width: 120px;
	height: 35px;
	border: 2px solid #008CBA;
}

.button1:hover {
	background-color: #e7e7e7;
	color: #008CBA;
}

/* Footer */
.footer {
	padding: 15px;
	text-align: center;
	margin-top: 20px;
}
/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
	.topnav a {
		float: none;
		width: 100%;
	}
}
</style>
</head>
<body>
	<div class="header">
		<h1>Expenses Tracker</h1>
		<p>Here in this site you easily track your Income and Expenses</p>
		<h4>Welcome to Expenses Tracker</h4>
	</div>

	<div class="topnav" id="myTopnav">
		<a href="${pageContext.request.contextPath}" class="active">Home</a> <a
			href="${pageContext.request.contextPath}/spend">Spending</a>
		<div class="dropdown">
			<button class="dropbtn">
				Categories <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="${pageContext.request.contextPath}/incomeCategory">Income</a>
				<a href="${pageContext.request.contextPath}/expenseCategory">Expense</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Transaction <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="${pageContext.request.contextPath}/income">Income</a> <a
					href="${pageContext.request.contextPath}/expense">Expense</a>
			</div>
		</div>

		<form:form name="submitForm" method="POST"
			action="${pageContext.request.contextPath}/logout">
			<input type="hidden" name="param1" value="param1Value">
			<A HREF="javascript:document.submitForm.submit()">Logout</A>
		</form:form>

		<a href="javascript:void(0);" style="font-size: 15px;" class="icon"
			onclick="myFunction()">&#9776;</a>
	</div>

	<div class="formDiv">
		<br>
		<center>
			<h3 style="color: white">Enter Your Income Details</h3>
		</center>
		<br>
		<hr>

		<center>
			<form:form action="${pageContext.request.contextPath}/saveIncomeDetails" modelAttribute="name" method="POST">
				<br>
				<div class="card">
					<font size="4"><label>Date:</label> </font> <font size="2">
						<input type="text" id="datepicker" name="date">
					</font>
				</div>
				<br>
				<br>
				<div>
					<font size="4"> <label>Category:</label>
					</font> <font size="2"> <form:select name="incomeTransactionName" items="${income_categories}"  path="incomeTransactionName"/>
					</font>
				</div>
				<br>
				<br>
				<div>
					<font size="4"> <label>Amount:</label>
					</font> <font size="2"><input type="text" name="amount"> </font>
				</div>
				<br>
				<br>
				<div>
					<label> <font size="4">Extra Notes:</font> <font size="2">(If
							any)</font>
					</label> <font size="2"> <textarea id="myTextArea" rows="5"
							cols="50" name="extraNotes">Your text here</textarea>
					</font>
				</div>
				<br>
				<br>
				<div>
					<button class="button1">Add</button>
				</div>
			</form:form>
		</center>
	</div>


	<div class="footer">
		<h3>Contacts</h3>
		<i class="glyphicon glyphicon-envelope"> subu2code@gmail.com</i>
	</div>

</body>
</html>