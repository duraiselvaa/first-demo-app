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
			<small>
				<a href="/wm/property/getSearch">Search</a>
				<a href="/wm/property/welcome">Back</a>
				<a href="/wm/login/logout">Logout</a><br/>	
			</small>
		</p>	
		
   	
	   	<c:if test="${message != null}">
    		<div style="color:blue">${message}</div>
		</c:if>
		
	
		<p align="left">
			<br/>
			<br/>
			<label style="color:Navy; font-size:22px;font-family:Verdana, Ariel, Sans-Serif">List of Properties </label>
			<br/>
			<br/> 			
		</p>

		<c:forEach items="${propertylist}" var="property">
			${property.aliasName} - ${property.street} - ${property.city}
			<a href="javascript:deleteProperty('/wm/property/delete?id=${property.id}');">Delete</a>
			<a href="javascript:go('/wm/property/edit?id=${property.id}');">Edit</a>
			<br /> 
			<br /> 						
		</c:forEach>
	
	<c:if test="${empty propertylist}">
		<p>No properties to list yet...</p>
        <br/>
	</c:if>		
 </body>
</html>	
