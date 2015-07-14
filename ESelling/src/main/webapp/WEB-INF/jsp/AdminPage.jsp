
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>

</head>
<body>
<div class="container">
<div class="menu">
		<ul style="background-color:white;">
			<li><strong>Hello ${admin.firstName}</strong></li>
			
			<li><a href=" <spring:url value="/pendingProducts" />" >Approve Products </a></li>
			<li><a href="#"><pre id="separator">   |   </pre> </a></li>
 	       <li><a href=" <spring:url value="#" />" >Add Categories</a></li>
 	       <li><a href="#"><pre id="separator">   |   </pre></a></li>
 	       <li><a href=" <spring:url value="/logout" />" >SignOut</a> </li>
 	       <li><a href="#"><pre id="separator">   |   </pre></a></li>
		</ul>	
				</div>
				
		</div>	
				
</body>
</html>