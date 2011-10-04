<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
	<title>Home Page</title>
	</head>
	<body>	
	
		<p align="right">
			<small>
				<a href="/wm/property/getSearch">Search</a>
				<a href="/wm/login/logout">Logout</a>
			</small>
		</p>
			
			<p align="center">
				<label style="color:Navy; font-size:18px;font-family:Verdana, Ariel, Sans-Serif">Welcome to wm</label>
				<br/>
				<br/>
				<a href="/wm/property/add">Add a Property</a><br/><br/>
				<a href="/wm/property/list">List all your properties</a><br/><br/>
			</p>			
			
	</body>
</html>
