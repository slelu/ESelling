<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title></title>
</head>
<body>

	<div id="main">

		<div id="products">
			<ul>
				<c:forEach items="${products}" var="product">
					<li id="product1" class="products">
						<div class="innerproduct" style="width:180px;">
							<div>
								<div class="titleOptions">
									<a href="<spring:url value="/products/product?id=${product.productId}" />"> 
										<img src="<c:url value="${product.productPath}"></c:url>" alt="image"  height="246px" width="190px"/>  
									</a>
								</div>
								<div class="productinfo">
									<div class="productdescription">
										<a href="<spring:url value="/products/product?id=${product.productId}" />"> <span class="large bold">
												${product.productName} </span>
										</a>
									</div>
									<div class="productprice">
										<a href="<spring:url value="/products/product?id=${product.productId}" />"> <span class="bold large red"><fmt:formatNumber value="${product.unitPrice}" type="currency"/></span>
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


</body>
</html>
