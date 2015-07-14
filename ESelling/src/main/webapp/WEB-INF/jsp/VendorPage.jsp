
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Page</title>

</head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"	rel="stylesheet">
<body>
<div class="container">
				<c:if test="${not empty addproduct}">
<div class="alert alert-danger"  >
<spring:message code="addedproductsuccessfully"/><br />
</div>
</c:if>
</div>
<div class="container">
<div class="menu">
		<ul style="background-color:white;">
			<li><strong>Hello ${vendor.firstName} </strong></li>
			
			<li><a href=" <spring:url value="/addProduct" />" >Post New Product </a> </li>
			<li><a href="#"><pre id="separator">   |   </pre> </a></li>
 	       <li><a href=" <spring:url value="/myProducts" />" >View My Products</a> </li>
 	       <li><a href="#"><pre id="separator">   |   </pre></a></li>
 	       <li><a href=" <spring:url value="/logout" />" >SignOut</a> </li>
 	       <li><a href="#"><pre id="separator">   |   </pre></a></li>
		</ul>	
				</div>
				
		</div>	

 		<%-- <div id="main">

		<div id="products">
			<section class="container">
				<div class="row">
				<c:forEach items="${vendorProducts}" var="product">
					<div class="col-md-5">
						<img src="<c:url value="/resources/images/${product.productName}.png"></c:url>" alt="image"  style="float: right; height:246px; width=190px;"/>  
					</div>

					<div class="col-md-5">
					 <h3>${product.productName}</h3> 
						<p><strong>Description</strong> :${product.description}</p>
						<p>
							<strong>Category</strong> : ${product.category.categoryName}
						</p>

						<p>
							<strong>Available units in stock </strong> :
							      ${product.unitsInStock}
						</p>
						<p>
							<strong>Product Status </strong> :
							      ${product.productApproval}
						</p>
						<h4>${product.unitPrice}USD</h4>
						
						<p>
							<a href="<spring:url value="/approveProducts?id=${product.productId}" />" class="btn btn-warning btn-large"> <span
								class="glyphicon-shopping-cart glyphicon"></span> APPROVE
							</a> 
							<a href="<spring:url value="/disapproveProduct?id=${product.productId}" />" class="btn btn-default">
								<span class="glyphicon-hand-right glyphicon"></span> DISAPPROVE
							</a> 
						</p>

					</div>
					</c:forEach>
				</div>
			</section>
		</div>

	</div>	
   --%>
</body>
</html>