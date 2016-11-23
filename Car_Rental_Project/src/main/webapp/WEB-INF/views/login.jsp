<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>

<body>
<div id="login-box">
	<h2 align="center">Login Page</h2>

	<form action="<spring:url value="/postLogin"></spring:url>"	method="post">
		<table>
			<tr>
				<td><label for="userName"> User Name : </label> </td>
				<td><input type="text"
					name="userName" id="userName" value="" /></td>
			</tr>
			<tr>
				<td><label for="password"> Password: </label></td>
				<td><input id="password"
					name="password" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="Login"/> 
					<%-- <spring:url value="/vehicle/showVehicle" var="show" />
					<a href="${show}"><button>Cancel</button></a> --%>
				</td>
			</tr>
		</table>
	</form>
 	<spring:url value="/vehicle/showVehicle" var="show" />
		<a href="${show}"><button>Cancel</button></a>
</div>
</body>
</html>
