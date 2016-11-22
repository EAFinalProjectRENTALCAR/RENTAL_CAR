<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<spring:url value="/vehicle/addVehicle" var="url" />
		<a href="${url}"><button>Add Vehicle</button></a>
<h1>Car Rental Agency </h1>
<div style = "text-align:center">
	<c:forEach items="${vehicles}" var="vehicle">
		<div style="float: left; padding: 10px">
			<img
				src="<c:url value="/resources/images/${vehicle.vehicleId}.png"/>"
				alt="image" style="width: 400px; height:300px" />
			<h4>${vehicle.description}</h4>
			<p>Price: $${vehicle.price}</p>
			<p>
				<a href=" <spring:url value="/vehicle/vehicleDetail?id=${vehicle.vehicleId}" /> "><button>See Details</button></a>
				<a href="<spring:url value="/reservation?id=${vehicle.vehicleId}"/>"><button>Book Now</button></a>
			</p>
		</div>
	</c:forEach>
</div>
<div><a href="login">Login</a></div>
</body>
</html>
