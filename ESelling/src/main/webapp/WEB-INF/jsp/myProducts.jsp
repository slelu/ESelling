<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title> Vendor Products</title>
</head>
<body>
<div class="container">
				<c:if test="${not empty emptylist}">
<div class="alert alert-success"  >
<spring:message code="novendorproducts"/><br />
</div>
</c:if>
</div>
<div id="main">
		<div id="products">
			<section class="container">
				<div class="row">
				<c:forEach items="${vendorProducts}" var="product">
					<div class="col-md-5">
						<img src="<c:url value="../${product.productPath}"></c:url>" alt="${product.productName}" style="float: right; height:246px; width=190px;">  
					</div>

					<div class="col-md-5">
					 <h3>${product.productName}</h3>
         <%--  <p><strong>Status :</strong><span class="label label-warning"> ${product.productApproval}</p> --%>
						<p><strong>Description :</strong> ${product.description}</p>
						<p>
							<strong>Category :</strong>  ${product.category.categoryName}
						</p>			

						<p>
							<strong>Available units in stock </strong> :
							       ${product.unitsInStock}
						</p>
						
						<h4>${product.unitPrice}USD</h4>
						
						<%-- <p>
							<a href="<spring:url value="/approveProducts?id=${product.productId}" />" class="btn btn-warning btn-large"> <span
								class="glyphicon-shopping-cart glyphicon"></span> EDIT
							</a> 
							<a href="<spring:url value="/disapproveProduct?id=${product.productId}" />" class="btn btn-default">
								<span class="glyphicon-hand-right glyphicon"></span>DELETE
							</a> 
						</p> --%>

					</div>
					</c:forEach>
				</div>
			</section>
		</div>

	</div>
</body>
</html>