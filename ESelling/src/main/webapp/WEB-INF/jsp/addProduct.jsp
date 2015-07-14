<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Product</title>
</head>
<body>

	<%-- <p><a
			href="<spring:url value="/userpage?id=${user.id}" />"> BACK</a> </p>
	<p>	<h4>Hello ${user.fname}</h4> </p> --%>
	
	<section class="container">
		<form:form  modelAttribute="product" class="form-horizontal" enctype="multipart/form-data">
			<fieldset>
				<legend>New product</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Product Name:</label>
					<div class="col-lg-10">
						<form:input id="name" path="productName" type="text" class="form:input-large"/>
						<form:errors path="productName" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitPrice">Unit Price:</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
							<form:errors path="unitPrice" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows = "2"/>
						<form:errors path="description" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="category">Category:</label>
					<div class="col-lg-10">
						<form:select id="category"  path="category.categoryId" class="form:input-large" >
						<form:option value="0" label="--Select Category--" />
						<form:options items="${categories}" itemLabel="categoryName"
							itemValue="categoryId" />
							
						
					</form:select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitsInStock">Quantity:</label>
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
						<form:errors path="unitsInStock" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="productCondition">Product Condition:</label>
					<div class="col-lg-10">
						<form:radiobutton path="productCondition" value="New" />New 
						<form:radiobutton path="productCondition" value="Old" />used 
						<form:radiobutton path="productCondition" value="Refurbished" />Refurbished
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="productImage">Product Image:</label>
					<div class="col-lg-10">
						<form:input id="productImage" path="productImage" type="file"
							class="form:input-large" />
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
