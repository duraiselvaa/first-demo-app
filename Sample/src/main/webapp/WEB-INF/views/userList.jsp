<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
	<title>List of Users</title>
	</head>
	<body>
		<p align="right">
			<small>
				<a href="/wm">Home Page</a><br/>
			</small>
		</p>
	
		<p  align="center">
			<br/>
			<br/>
			<label style="color:Navy; font-size:26px;font-family:Verdana, Ariel, Sans-Serif">List of Users</label>
			<br/>
		</p>
		<p align="center">
			<form:label path="emailId">User Id :</form:label>
		</p>				
	</body>
</html>