<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>404 - this page does not exist</title>
    <style>
    </style>
</head>
<body background="<c:url value="resources/images/404.jpg" />" style="background-repeat: no-repeat;background-size: 100% 100%;">
<h1><a href="<c:url value="/" />">Back home</a></h1>
</body>
 --%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>HTTP Status 403 - Access is denied</h1>

	<c:choose>
		<c:when test="${empty username}">
		  <h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
		  <h2>Username : ${username} <br/>
                    You do not have permission to access this page!</h2>
		</c:otherwise>
	</c:choose>
	<h1><a href="<c:url value="/" />">Back home</a></h1>
</body>
</html>