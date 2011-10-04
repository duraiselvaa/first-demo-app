<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
	<title>Add Property</title>
  		<style>
			.error {
				color: #ff0000;
				font-style: italic;
			}
		</style> 	
	</head>
	<body onload="initialize()">
		<p align="right">
			<small>
				<a href="/wm/property/welcome">Back</a>
				<a href="/wm/login/logout">Logout</a><br/>	
			</small>
		</p>	
		
		<form:form modelAttribute="property" method="POST" action="save" >
			<p  align="center">
				<br/>
				<br/>
				<label style="color:Navy; font-size:26px;font-family:Verdana, Ariel, Sans-Serif">Add New Property</label>
				<br/>
			</p>
			<div>
			<p align="center">
				<form:label path="aliasName">Alias Name :</form:label>
				<form:input path="aliasName" />
				<form:errors path="aliasName" cssClass="error" />
				<br />
				<form:label path="street">Street :</form:label>
				<form:input path="street" />
				<form:errors path="street" cssClass="error" />
				<br />
				<form:label path="city">City :</form:label>
				<form:input path="city" />
				<form:errors path="city" cssClass="error" />
				<br />
				<input type="submit" value="Add" />
			</p>
			</div>
		</form:form>
	</body>
</html>