<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
	<title>Search Page</title>
  		<style>
			.error {
				color: #ff0000;
				font-style: italic;
			}
		</style>	
	</head>
	<body>
		<p align="right">
			<small>
				<a href="/wm/property/welcome">WelcomePage</a>
				<a href="/wm/login/logout">Logout</a><br/>	
			</small>
		</p>	
		<form:form modelAttribute="property" method="POST" action="search" >
			<p align="center">
				<label style="color:Navy; font-size:26px;font-family:Verdana, Ariel, Sans-Serif">Search</label>
				<br/>
				<br/>	
				<form:label path="street">Street :</form:label>
				<form:input path="street" />
				<form:errors path="street" cssClass="error" />
				<br />
				<form:label path="city">City :</form:label>
				<form:input path="city" />
				<form:errors path="city" cssClass="error" />
				<br />				
				<input type="submit" value="Search">
			</p>					
		</form:form>		
	</body>
</html>
