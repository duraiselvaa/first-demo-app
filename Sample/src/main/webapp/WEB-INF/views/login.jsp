<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
	<title>Login</title>
	</head>
	<body>
		<p align="right">
			<small>
				<a href="/wm">Home Page</a><br/>
			</small>
		</p>
	
		<form:form modelAttribute="user" method="POST" action="log" >
		
		<c:if test="${error != null}">
    		<div style="border-color:red; color:red"><fmt:message key="${error}" /></div>
		</c:if>				
	
        <br/>
        
		<p  align="center">
			<br/>
			<br/>
			<label style="color:Navy; font-size:26px;font-family:Verdana, Ariel, Sans-Serif">Login</label>
			<br/>
		</p>
		<p align="center">
			<form:label path="emailId">UserName/email Id :</form:label>
			<form:input path="emailId" />
			<br />
			<form:label path="password">Password :</form:label>
			<form:password path="password" />
			<br />
			<input type="submit" value="login" />
		</p>
		</form:form>			
	</body>
</html>