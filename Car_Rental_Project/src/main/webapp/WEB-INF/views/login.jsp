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
	<h2 align="center"><spring:message code="loginpage" text="default text" /></h2>
	<spring:message code="language" text="default text" /> &nbsp; &nbsp;<a href="?language=en_US">English</a>|<a href="?language=vn_VN">Viet Nam</a><br><br>
	<form action="<spring:url value="/postLogin"></spring:url>"	method="post">
		<table>
			<tr>
				<td width="50%"><!-- <label for="userName"> User Name : </label>  -->
					<spring:message code="username" text="default text" />
				</td>
				<td  width="50%"><input type="text"
					name="userName" id="userName" value="" /></td>
			</tr>
			<tr>
				<td><!-- <label for="password"> Password: </label> -->
					<spring:message code="password" text="default text" />
				</td>
				<td><input id="password"
					name="password" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<spring:message code="login" var="Login"></spring:message>
					<input type="submit" value="${Login}"/> 		
				</td>
			</tr>
		</table>
	</form>
	<spring:message code="cancel" var="cancel"></spring:message>
 	<spring:url value="/vehicle/showVehicle" var="show" />
		<a href="${show}"><input type="submit" value="${cancel}"/></a>
</div>
</body>
</html>
