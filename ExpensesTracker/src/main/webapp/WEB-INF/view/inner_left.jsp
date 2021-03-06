<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Expenses History</title>
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

/* Footer */
.footer {
	padding: 15px;
	text-align: center;
	margin-top: 20px;
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

.centreBox {
	padding: 45px;
	width: 100%;
	margin-top: 100px;
	margin-left: 10px;
	margin-right: 10px;
	margin-bottom: 10px;
	text-align: center;
	height: 70%;
	text-align: center;
	height: 70%;
	background-color: white;
}

body {
	font-family: Arial;
	padding: 10px;
	margin: 5px;
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/images.png");
}

.income_div {
	margin-top: 40px;
	margin-left: 10px;
	margin-right: 10px;
	background-image:
		url("file:///C:/Users/802359/workspace/ExpensesTracker/src/main/resources/image/image_twelve.jpg");
	height: 100%;
	width: 100%;
	border-radius: 80px;
	padding: 20px;
}

hr {
	border-color: black;
	color: black;
}

.td {
	color: #da2d2d;
}

.tf {
	color: #333;
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

	<center style="margin: 60px">
		<h1>Monthly Expenses Report</h1>
	</center>

	<div class="income_div">
		<center>
			<table cellspacing="10px">
				<tr>
					<td>
						<h3>Income:</h3>
					</td>
					<td>
						<p style="color: #00ff00;">+${report.income}</p>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="5px">
							<tr>
								<th>Income Category</th>
								<th>Amount</th>
							</tr>
							<c:forEach var="incomeCat" items="${report.incomeTransactions}">
								<tr>
									<td class="tf"><c:out
											value="${incomeCat.incomeTransactionName}" /></td>
									<td style="color: #00ff00"><c:out
											value="+${incomeCat.amount}" /></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<h3>Expenses:</h3>
					</td>
					<td>
						<p class="td">-${report.expense}</p>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="5px">
							<tr>
								<th>Expense Category</th>
								<th>Amount</th>
							</tr>
							<c:forEach var="expenseCat" items="${report.expenseTransactions}">
								<tr>
									<td class="tf"><c:out
											value="${expenseCat.expenseTransactionName}" /></td>
									<td class="td"><c:out value="-${expenseCat.amount}" /></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td><hr></td>
					<td><hr></td>
				</tr>
				<tr>
					<td><h3>Total Balance:</h3></td>
					<td><c:if test="${report.balance < 0}">
					 <p style="color: #da2d2d">${report.balance}</p>
					</c:if>
					<c:if test="${report.balance > 0}">
					 <p style="color: #00ff00">+${report.balance}</p>
					</c:if></td>
				</tr>
				<tr>
					<td><hr></td>
					<td><hr></td>
				</tr>
			</table>
		</center>

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