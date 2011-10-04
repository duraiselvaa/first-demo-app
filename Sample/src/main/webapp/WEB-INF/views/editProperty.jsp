<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
	<title>Edit Property</title>
	</head>
	<body style="font-family: Arial; font-size:smaller;">
		<p align="right">
			<small>
				<a href="/wm/property/welcome">WelcomePage</a>
				<a href="/wm/property/list">Back</a>				
				<a href="/wm/login/logout">Logout</a><br/>	
			</small>
		</p>	
		<table style="border-collapse: collapse;" width="750" align="center" bgcolor="lightblue" border="1" bordercolor="#006699" height="500">
			<tbody>
				<tr>
					<td align="center"><h3>Edit Property</h3></td>
				</tr>
				<tr valign="top" align="center">
					<td align="center">
						<form:form action="update" method="post" modelAttribute="property">
							<table style="border-collapse: collapse;" width="500" border="0" bordercolor="#006699" cellpadding="2" cellspacing="2">
								<tbody>
									<tr>
										<td width="100" align="right"><form:label path="aliasName">Property Id :</form:label></td>
										<td width="150"><form:input path="id" readonly="true"></form:input></td>
									</tr>
									<tr>
										<td width="100" align="right"><form:label path="aliasName">Alias Name :</form:label></td>
										<td><form:input path="aliasName"></form:input></td>
										<td><form:errors path="aliasName" cssClass="error" /></td>
									</tr>
									<tr>
										<td width="100" align="right"><form:label path="street">Street :</form:label></td>
										<td><form:input path="street" /></td>
										<td><form:errors path="street" cssClass="error" /></td>
									</tr>
									<tr>
										<td width="100" align="right"><form:label path="city">City :</form:label></td>
										<td><form:input path="city" /></td>
										<td><form:errors path="city" cssClass="error" /></td>
									</tr>
									<tr valign="bottom">									
										<td colspan="2" align="center">
  											<input value="Delete" onclick="javascript:deleteProperty('/wm/property/delete?id=${property.id}');" type="button">
											<input name="" value="Save" type="submit">     
											<input value="Back" onclick="javascript:go('/wm/property/list');" type="button">
										</td>
									</tr>
								</tbody>
							</table>
						</form:form>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>	
					
					
					
					
					
					
					
					
					





  
