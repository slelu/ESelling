<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Online Shopping</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css"></style>
<link href="resources/css/all.css" rel="stylesheet" type="text/css" />
<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<!-- Header goes here--->
	<div id="header">
		<div id="header_container">
			<div class="right"
				style="padding-right: 16px; padding-top: 12px; width: 115px; height: 40px; float: right; margin-top: -59px; margin-right: 30px;">
				<ul>
					<li class="right"><a href="#"> <img align="right"
							alt="Spanish" src="resources/images/Sp.png"
							style="margin-right: -20px" title="Español" class="drop5">
					</a></li>
					<li class="right"><a href="#"> <img align="right"
							alt="French" src="resources/images/Fr.png"
							style="margin-right: 6px" title="Français" class="drop5">
					</a></li>
					<li class="right"><a href="#"> <img align="right"
							alt="English" src="resources/images/UK1.png"
							style="padding-right: 5px; opacity: 1;" title="English"
							class="drop5">
					</a></li>
				</ul>
			</div>
			<span class="logo left"> <a href="/eselling/"> <img
					alt="E-Selling System" title="E-Selling System"
					src="resources/images/logo.png" />
			</a>
			</span>

			<div class="right" id="share" style="width: 650px">
				<ul class="nav">
				<form:form modelAttribute="productSearchCriteria" action="/product/search" method="post">
					<div class="styled-select">
						<select>
						 <c:forEach var="category" items="${categories}">
							<option>${category.categoryName}</option>
						 </c:forEach>
						</select>
					</div>
					<li id="search">
						
							<input type="text" name="search_text" id="search_text" placeholder="search a product..." /> 
							<input type="button" name="search_button" id="search_button" value="Search"/>
						
					</li>
					</form:form>
				</ul>

				<br class="clear" />
				<div class="menu">
					<ul>
						<li><a href="<spring:url value="/login" />">Sign In</a></li>
						

						<li><a href=""><pre>   |   </pre></a></li>
						
						<li><a href="<spring:url value="/vendorSignUp" />">New Vendor?</a></li>
						<li><a href="#"><pre>   |   </pre></a></li>

						<li><a href="#"><pre id="separator">   |   </pre></a></li>

						
						<li><a href="<spring:url value="/customerSignUp" />">New Customer?</a></li>
					</ul>
					<br style="clear: left" />
				</div>

			</div>

		</div>
	</div>

	<!--Main Content goes here --->
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
