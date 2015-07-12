<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content=
"text/html; charset=ISO-8859-1">

<title>Login</title>
</head>
<body>

<h3 class="panel-title">Please sign in</h3>

<c:if test="${not empty error}">
<div class="alert alert-danger">
<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
</div>
</c:if>
<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">

<div id="fieldset">
<fieldset >
<table >
<tr>
<td>
<input class="form-control" placeholder="User Name" name='j_username' type="text">
</td>
</tr>

<tr>
<td>
<input class="form-control" placeholder="Password" name='j_password' type="password" value="">
</td>
</tr>
</table>
<p align="left">
<input  type="submit" value="Login">
</p>

<p align="left">
			<a href="<spring:url value="/customerSignUp" />">New Customer ?</a>
			<a href="<spring:url value="/vendorSignUp" />"> New Vendor ? </a>
</p>

</fieldset>
</div>
</form>


</body>
</html>