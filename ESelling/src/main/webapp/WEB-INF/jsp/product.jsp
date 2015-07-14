<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css"></style>
<link href="../resources/css/all.css" rel="stylesheet" type="text/css" />
<link href="../resources/css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	
	<div id="main">

		<div id="products">
			<section class="container">
				<div class="row">
					<div class="col-md-5">
						<img src="<c:url value="../${product.productPath}"></c:url>" alt="${product.productName}" style="float: right; height:246px; width=190px;">
					</div>

					<div class="col-md-5">
						<h3>${product.productName}</h3>
						<p>${product.description}</p>
						<p>
							<strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
						</p>

						<p>
							<strong>Category</strong> : ${product.category.categoryName}
						</p>

						<p>
							<strong>Available units in stock </strong> :
							${product.unitsInStock}
						</p>
						<h4>${product.unitPrice}USD</h4>
						<p>
							<a href="<c:url value="/cart/add/${product.productId}"/>" class="btn btn-warning btn-large"> <span
								class="glyphicon-shopping-cart glyphicon"></span> <spring:message code="product.addtocart"/>
							</a> 
							<a href="<spring:url value="/cart" />" class="btn btn-default">
								<span class="glyphicon-hand-right glyphicon"></span> <spring:message code="product.viewcart"/>
							</a> 
							<a href="<spring:url value="/" />"
								class="btn btn-default"> <span
								class="glyphicon-hand-left glyphicon"></span> <spring:message code="continueshopping"/>
							</a>

						</p>

					</div>
				</div>
			</section>


		</div>



	</div>

	<!--Footer goes here --->
	<div id="footer">
		<div id="footer_details_menu">
			<ul>

				<li style="color: #232f3e;">HEAD OFFICE</li>
				<li>Fairfield, IA 52557</li>
				<li>1000 N 4th st</li>
				<li>Tel: +641 562-2564 / 5 / 6</li>
				<li>Fax: +641 333-6521</li>
				<li>E-mail: inquiry@esellingsystem.com</li>

			</ul>



			<ul class="footer_menu">

				<li><a href="/eselling/welcome" title="Home">Home</a></li>



			</ul>



			<ul class="footer_menu" style="border: none;">



				<li><a href="/terms" title="Terms and Conditions">Terms and
						Conditions</a></li>

			</ul>



			<ul class="footer_menu" style="border: none;">

				<li><a href="skype:eselling.system?call"
					onclick="return skypeCheck();" title="Support Center">Support
						Center</a></li>


			</ul>

			<ul class="footer_menu" style="border: none;">



				<li><a href="/contacts" title="Contacts">Contacts</a></li>

			</ul>


			<div class="clear"></div>
		</div>
	</div>
</body>
</html>
