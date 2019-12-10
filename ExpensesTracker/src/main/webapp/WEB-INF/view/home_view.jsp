<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto|Courgette|Pacifico:400,700"
	rel="stylesheet">
<style>
/* Header/Blog Title */
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial;
	padding: 10px;
	background: #f1f1f1;
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/images_three.png")
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

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
	float: left;
	width: 75%;
}

/* Right column */
.rightcolumn {
	float: left;
	width: 25%;
	background-color: #f1f1f1;
	padding-left: 20px;
}

/* Fake image */
.fakeimg {
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_one.jpg");
	width: 100%;
	padding: 20px;
}

.mainimg {
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_nine.jpg");
	width: 100%;
	padding: 20px;
}

.sideImgOne {
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_seven.jpg");
	width: 100%;
	padding: 20px;
}

.sideImgTwo {
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_eight.png");
	width: 100%;
	padding: 20px;
}

.bottomImg {
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_five.jpg");
	width: 100%;
	padding: 20px;
}

.aboutimg {
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_two.png");
	width: 100%;
	padding: 20px;
}
/* Add a card effect for articles */
.card {
	background-color: white;
	padding: 20px;
	margin-top: 20px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Footer */
.footer {
	padding: 15px;
	text-align: center;
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_twelve.jpg");
	margin-top: 20px;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
	.leftcolumn, .rightcolumn {
		width: 100%;
		padding: 0;
	}
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
		<h4>Today get your free access!</h4>
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


		<c:if test="${pageContext.request.userPrincipal.name == null}">
			<a href="${pageContext.request.contextPath}/signup">SignUp</a>
			<a href="${pageContext.request.contextPath}/login">Login</a>
		</c:if>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form:form name="submitForm" method="POST"
				action="${pageContext.request.contextPath}/logout">
				<input type="hidden" name="param1" value="param1Value">
				<A HREF="javascript:document.submitForm.submit()">Logout</A>
			</form:form>

		</c:if>

		<a href="javascript:void(0);" style="font-size: 15px;" class="icon"
			onclick="myFunction()">&#9776;</a>


	</div>

	<div class="row">
		<div class="leftcolumn">
			<div class="card">
				<h2>Smart Tracker</h2>
				<hr>
				<h5>Developed on, Oct 21, 2019</h5>
				<div class="mainimg" style="height: 450px; margin: 3px;"></div>
				<br>
				<p>This site saves your lots of time..</p>
				<p>Here you can track all your Expenses as well as your Income
					clearly with the help of our clear and well explained graphical
					views.</p>
			</div>
			<div class="card">
				<h2>Intelligent Calculation</h2>
				<hr>
				<div class="bottomImg" style="height: 330px;"></div>
				<br>
				<p>Our Site help you to save lot of money.</p>
				<p>This Site is totally free. With the help of our site you can
					easily make some pre calculation on your Expenses and try to
					control your unwanted Expenses.</p>
			</div>
		</div>
		<div class="rightcolumn">
			<div class="card">
				<h2>About Me</h2>
				<hr>
				<div class="aboutimg" style="height: 150px;"></div>
				<br>
				<p>Myself Subramanian G, And I am an full stack web developer.</p>
				<br>
				<p>For more information contact me at subu2code@gmail.com</p>
			</div>
			<div class="card">
				<h3>Graphical Views</h3>
				<hr>
				<div class="sideImgOne"
					style="width: 150px; height: 150px; margin: 12px;"></div>
				<hr>
				<div class="sideImgTwo"
					style="width: 250px; height: 100px; margin: 12px;"></div>
			</div>
			<div class="card">
				<h3>Follow Me</h3>
				<hr>
				<p>subu2code@facebook.com</p>
			</div>
		</div>
	</div>

	<div class="footer">
		<h3>Contacts</h3>
		<i class="glyphicon glyphicon-envelope"> subu2code@gmail.com</i>
	</div>

	<script>
		function myFunction() {
			var x = document.getElementById("myTopnav");
			if (x.className === "topnav") {
				x.className += " responsive";
			} else {
				x.className = "topnav";
			}
		}
	</script>
</body>
</html>
