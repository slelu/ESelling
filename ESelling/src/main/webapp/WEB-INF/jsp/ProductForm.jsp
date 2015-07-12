<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>
<body>
<div class="row">
	<%-- <p><a
			href="<spring:url value="/userpage?id=${user.id}" />"> BACK</a> </p>
	<p>	<h4>Hello ${user.fname}</h4> </p> --%>
	

<form:form  modelAttribute="product" enctype="multipart/form-data">
		<table>
			 <tr>
				<td><label>Category:</label></td>
				<td><form:select path="category.categoryId">
						<form:option value="0" label="--Select Category--" />
						<form:options items="${categories}" itemLabel="name"
							itemValue="id" />
						
					</form:select></td>
			</tr>



			
			<tr>
				<td><label >Product Name:</label></td>
				<td><form:input  path="productName" /> 
				<%-- <form:errors path="productName" element="div" /></td> --%>
			</tr>

			<tr>
				<td><label>Description:</label></td>
				<td><form:textarea  path="description" rows="2" />
					<%-- <form:errors path="description" element="div" /></td> --%>
			</tr>

			<tr>
				<td><label>Unit Price:</label></td>
				<td><form:input  path="unitPrice" /> 
				<%-- <form:error path="unitPrice" element="div"/></td> --%>
			</tr>

			<tr>
				<td><label >Quantity:</label></td>
				<td><form:input  path="unitsInStock" /> 
				<%-- <form:errors path="unitsInStock" element="div" /></td> --%>
			</tr>
			<tr>
				<td><label>Condition:</label></td>
				<td><form:radiobutton path="productCondition" value="New" />New <form:radiobutton
						path="productCondition" value="Used" />Used <form:radiobutton
						path="productCondition" value="Refurbished" />Refurbished</td>
			</tr>

			<tr>
				<td><label >Image:</label></td>
				<td><form:input  path="productImage" type="file" /></td>
		</table>
		<p align="justify">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <input type="submit"
				value="Submit" value="Post" tabindex="5">
		</p>
		

	</form:form>
</div>
</body>
</html>
