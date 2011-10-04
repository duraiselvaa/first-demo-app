<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
	<title>Home Page</title>
	</head>
	<body>
		<p align="right">
			<small>
				<a href="/wm/register/add">Register</a><br/>
				<a href="/wm/login/getLogin">Login</a>
			</small>
		</p>
		<c:if test="${message != null}">
    		<div style="color:blue"><fmt:message key="${message}" /></div>
		</c:if>
		
		
		
		<form:form modelAttribute="property" method="POST" action="/wm/property/search" >
			<p align="center">
				<label style="color:Navy; font-size:26px;font-family:Verdana, Ariel, Sans-Serif">wm</label>
				<br/>
				<br/>	
				<form:input path="city" />
				<form:errors path="city" cssClass="error" />				
				<input type="submit" value="Search">
				<br/>
				<small>
				 ....(search by city...)
				</small>
			</p>			
		</form:form>	
	</body>
</html>
