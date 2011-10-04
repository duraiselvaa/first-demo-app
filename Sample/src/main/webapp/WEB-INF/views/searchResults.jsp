<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
 	<script type="text/javascript">
 		function deleteProperty(url) {
 			var isOK = confirm("Are you sure to delete the selected property?");
 		 	if(isOK) {
 		  		go(url);
 		 	}
 		}
 		function go(url)
 		{
 			 window.location = url;
 		}
 	</script>	
	<title>List of Properties</title>
	</head>
	<body>
		<p align="right">
			<%
				if( (request.getSession().getAttribute("user_id")) != null) {
			%>			
			<small>
				<a href="/wm/property/getSearch">Back</a>
				<a href="/wm/property/welcome">WelcomePage</a>
				<a href="/wm/login/logout">Logout</a><br/>	
			</small>
			<%
				}
				else {
			%>
			<small>
				<a href="/wm">Back</a>
			</small>			
			<%
				}
			%>		
				
		</p>	
	
		<p align="left">
			<br/>
			<br/>
			<label style="color:Navy; font-size:22px;font-family:Verdana, Ariel, Sans-Serif">List of Properties </label>
			<br/>
			<br/> 			
		</p>

		<c:forEach items="${propertylist}" var="property">
			${property.aliasName} - ${property.street} - ${property.city}
			<br /> 
			<br /> 						
		</c:forEach>
	
	<c:if test="${empty propertylist}">
		<p>No properties to list yet...</p>
        <br/>
	</c:if>		
 </body>
</html>	
