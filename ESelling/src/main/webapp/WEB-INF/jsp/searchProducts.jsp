<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Products</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css"></style>
<link href="resources/css/all.css" rel="stylesheet" type="text/css" />
<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<!-- Header goes here--->
	

	<!--Main Content goes here --->
<div class="container">
				<c:if test="${not empty nosearchproduct}">
<div class="alert alert-success"  >
<spring:message code="successful"/><br />
</div>
</c:if>
</div>	
	<div class="container">
				<c:if test="${not empty admin}">
<div class="container">
<div class="menu">
		<ul style="background-color:white;">
			<li><strong>Hello ${admin.firstName}</strong></li>
			
			<li><a href=" <spring:url value="/pendingProducts" />" >Approve Products </a></li>
			<li><a href="#"><pre id="separator">   |   </pre> </a></li>
 	       <li><a href=" <spring:url value="#" />" >Add Categories</a></li>
 	       <li><a href="#"><pre id="separator">   |   </pre></a></li>
 	       <li><a href=" <spring:url value="/" />" >SignOut</a> </li>
 	       <li><a href="#"><pre id="separator">   |   </pre></a></li>
		</ul>	
				</div>
				
		</div>	
</c:if>
<c:if test="${not empty customer}">
<div class="container">
			<div class="menu">
			<ul>
			
			<li><strong>Hello ${customer.firstName}</strong></li>	
			<li><a href=" <spring:url value="/" />" >SignOut</a> </li>
			<li><a href="#"><pre id="separator">   |   </pre></a></li>	
	       </ul>	
				</div>
				</div>
</c:if>
<c:if test="${not empty vendor}">
<div class="container">
<div class="menu">
		<ul style="background-color:white;">
			<li><strong>Hello ${vendor.firstName} </strong></li>
			
			<li><a href=" <spring:url value="/addProduct" />" >Post New Product </a> </li>
			<li><a href="#"><pre id="separator">   |   </pre> </a></li>
 	       <li><a href=" <spring:url value="#" />" >View My Products</a> </li>
 	       <li><a href="#"><pre id="separator">   |   </pre></a></li>
 	       <li><a href=" <spring:url value="/" />" >SignOut</a> </li>
 	       <li><a href="#"><pre id="separator">   |   </pre></a></li>
		</ul>	
				</div>
				
		</div>	
</c:if>

</div>
	<div id="main">

		<div id="products">
			<ul>
				<c:forEach items="${products}" var="product">
					<li id="product" class="products">
						<div class="innerproduct">
							<div>
								<div class="titleOptions">
									<a href="<spring:url value="/products/product?id=${product.productId}" />"> <img
										src="<c:url value="${product.productPath}"></c:url>"
										height="246px" width="190px">
									</a>
								</div>
								<div class="productinfo">
									<div class="productdescription">
										<a href="<spring:url value="/products/product?id=${product.productId}" />"> <span class="large bold">
												${product.productName} </span>
										</a>
									</div>
									<div class="productprice">
										<a href="<spring:url value="/products/product?id=${product.productId}" />"> <span class="bold large red">$${product.unitPrice }</span>
										</a>
									</div>
								</div>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>



	</div>

	<!--Footer goes here --->
	
</body>

</html>
