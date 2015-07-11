<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <title><spring:message code="label.form.title"></spring:message></title> --%>
</head>
<body>
	<form:form modelAttribute="newCustomer" method="POST" enctype="utf8">
		<table>
			<tr>
				<td><label>First Name:</label></td>
				<td><form:input path="firstName" value="" /> <%--  <form:errors path="firstName" element="div"/> --%>
				</td>
			</tr>


			<tr>
				<td><label>Last Name:</label></td>
				<td><form:input path="lastName" value="" /> <%-- <form:errors path="lastName" element="div" /> --%>
				</td>
			</tr>
			<tr>
				<td><label>Email:</label></td>
				<td><form:input path="email" value="" /> <%--  <form:errors path="email" element="div" />  --%>
				</td>
			</tr>

			<tr>
				<td><label>Phone Number:</label></td>
				<td><form:input path="phone" value="" /> <%--  <form:errors path="phone" element="div" /> --%>
				</td>
			</tr>

			<tr>
				<td><label>Street:</label></td>
				<td><form:input path="address.street" value="" type="text" />
					<%-- <form:errors path="address.street" element="div" /> --%></td>
			</tr>

			<tr>
				<td><label>State:</label></td>
				<td><form:select path="address.state">
				<%-- <form:option value="0" label="-state-" /> --%>
						<form:options items="${states}" />
						<%-- <form:errors path="address.state" element="div" /> --%>
					</form:select></td>
				
			</tr>

			<tr>
				<td><label>Zip Code:</label></td>
				<td><form:input path="address.zipcode" value="" type="text" />
					<%-- <form:errors path="address.zipcode" element="div" /> --%></td>
			</tr>
			<tr>
				<td>
					<!-- <label class="control-label col-lg-2" for="authority">Role</label> -->
					<form:hidden path="credentials.authority[0].authority"
						value="ROLE_CUSTOMER" /> <%-- <form:errors path="credentials.authority[0].authority" cssClass="text-danger"/> --%>
				</td>
			<tr>
				<td><form:hidden path="credentials.enabled" value="TRUE" /></td>
			</tr>
			<tr>
				<td></td>
			</tr>


			<tr>
				<td><label>User Name:</label></td>
				<td><form:input path="credentials.username" value="" /> <%-- <form:errors path="credentials.username" element="div" /> --%>
				</td>
			</tr>

			<tr>
				<td><label>Password:</label></td>
				<td><form:input path="credentials.password" value=""
						type="password" /> <%-- <form:errors path="password" element="div" /> --%>
				</td>
			</tr>
			<tr>
				<td><label>Verify Password:</label></td>
				<td><form:input path="credentials.verifyPassword" value=""
						type="password" /> <%-- <form:errors path="credentials.verifyPassword" element="div" /> --%>
				</td>
			</tr>

			<tr>
				<td><label>Card Number:</label></td>
				<td><form:input path="creditCard.creditCardNo" value=""
						type="text" /> <%-- <form:errors path="creditCard.crediCardNo" element="div" /> --%>
				</td>
			</tr>

			<tr>
				<td><label>CreditType:</label></td>
				<td><form:input path="creditCard.creditCardType" value=""
						type="text" /> <%-- <form:errors path="creditCard.creditCardType" element="div" /> --%>
				</td>
			</tr>

			<tr>
				<td><label>Name On Card:</label></td>
				<td><form:input path="creditCard.nameOnCard" value=""
						type="text" /> <%-- <form:errors path="creditCard.nameOnCard" element="div" /> --%>
				</td>
			</tr>

			<tr>
				<td><label>Expire Month:</label></td>
				<td><form:select path="creditCard.expMonth">
						<%-- <form:option value="0" label="-Month-" /> --%>
						<form:options items="${months}" />
						<%-- <form:errors path="creditCard.expMonth" element="div" /> --%>
					</form:select></td>
			</tr>

			<tr>
				<td><label>Expire Year:</label></td>
				<td><form:select path="creditCard.expYear">
						<%-- <form:option value="0" label="-Year-" /> --%>
						<form:options items="${years}" />
						<%-- <form:errors path="creditCard.expYear" element="div" /> --%>
					</form:select></td>
			</tr>
			<tr>
				<td><label>3 Digit Security Code:</label></td>
				<td><form:input path="creditCard.securityCode" value=""
						type="password" /> <%-- <form:errors path="creditCard.securityCode" element="div" /> --%>
				</td>

			</tr>

		</table>

		<p align="justify">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
				value="Submit" tabindex="5">
		</p>
	</form:form>


</body>


</html>