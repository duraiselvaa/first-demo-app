<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
	<title>Add User</title>
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
				<a href="/wm">Home Page</a><br/>
			</small>
		</p>
	
		<form:form modelAttribute="user" method="POST" action="save" >
		<p  align="center">
			<br/>
			<br/>
			<label style="color:Navy; font-size:26px;font-family:Verdana, Ariel, Sans-Serif">Registration</label>
			<br/>
		</p>
		
		<c:if test="${error != null}">
    		<div class="error"><fmt:message key="${error}" /></div>
		</c:if>
		
		<p align="center">
			<form:label path="emailId">Email Address :</form:label>
			<form:input path="emailId" />
			<form:errors path="emailId" cssClass="error" />
			<br />
			<form:label path="password">Password :</form:label>
			<form:password path="password" />
			<form:errors path="password" cssClass="error" />
			<br />
			<form:label path="confirmPassword">Confirm Password :</form:label>
			<form:password path="confirmPassword" />
			<form:errors path="confirmPassword" cssClass="error" />
			<br />
			<input type="submit" value="Register" />
		</p>
		</form:form>			
		
	</body>
</html>