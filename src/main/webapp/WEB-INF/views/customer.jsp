<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Customer Page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="resources/theme/css/style.css">
</head>
<body>
<h1>
	Add a Customer
</h1>

<c:url var="addAction" value="/customer/add" ></c:url>

<form:form action="${addAction}" commandName="customer">
<table>
	<c:if test="${!empty customer.nameCustomer}">
	<tr>
		<td>
			<form:label path="idCustomer">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="idCustomer" readonly="true" size="200"  disabled="true" />
			<form:hidden path="idCustomer" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="nameCustomer">
				<spring:message text="Customer Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="nameCustomer" />
		</td> 
		<td>
			<form:errors path="nameCustomer" />
		</td> 
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty customer.nameCustomer}">
				<input type="submit"
					value="<spring:message text="Edit Customer"/>" />
			</c:if>
			<c:if test="${empty customer.nameCustomer}">
				<input type="submit"
					value="<spring:message text="Add Customer"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Categories List</h3>
<c:if test="${!empty listCustomers}">
	<table class="tg">
	<tr>
		<th width="80">Customer ID</th>
		<th width="150">Customer Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCustomers}" var="customer">
		<tr>
			<td>${customer.idCustomer}</td>
			<td>${customer.nameCustomer}</td>
			<td><a href="<c:url value='customer/edit/${customer.idCustomer}' />" >Edit</a></td>
			<td><a href="<c:url value='customer/remove/${customer.idCustomer}' />" onclick="return confirm('Do you want delete this record ?')">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
