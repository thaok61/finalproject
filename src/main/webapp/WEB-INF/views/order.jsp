<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Order Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="resources/theme/css/style.css">
</head>
<body>
	<h1>Add a Order</h1>

	<c:url var="addAction" value="/order/add"></c:url>

	<form:form action="${addAction}" commandName="order">
		<table>
			<c:if test="${!empty order.idOrder}">
				<tr>
					<td><form:label path="idOrder">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="idOrder" readonly="true"
							size="200" disabled="true" /> <form:hidden path="idOrder" />
					</td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="totalMoney">
						<spring:message text="Total Money" />
					</form:label></td>
				<td><form:input path="totalMoney" /></td>
				<td><form:errors path="totalMoney" /></td>
			</tr>
			<tr>
				<td><form:label path="idCustomer">
						<spring:message text="Customer" />
					</form:label></td>
				<td><form:select path="idCustomer">
						<form:options items="${customersList}" itemValue="idCustomer"
							itemLabel="nameCustomer" />
					</form:select></td>
				<td><form:errors path="idCustomer" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty order.totalMoney}">
						<input type="submit"
							value="<spring:message text="Edit Order "/>" />
					</c:if> <c:if test="${empty order.totalMoney}">
						<input type="submit"
							value="<spring:message text="Add Order "/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Order List</h3>
	<c:if test="${!empty listOrders}">
		<table class="tg">
			<tr>
				<th width="80">Order ID</th>
				<th width="150">Customer</th>
				<th width="60">Total Money</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listOrders}" var="order">
				<tr>
					<td>${order.idOrder}</td>
					<td>${order.nameOrder}</td>
					<td>
				<c:forEach items="${customersList }"  var="customer">
					<c:if test="${customer.idCustomer eq order.idCustomer}"> <c:out value="${country.countryName }"></c:out> </c:if>
				</c:forEach> 
			</td>
					<td><a
						href="<c:url value='order/edit/${order.idOrder}' />">Edit</a></td>
					<td><a
						href="<c:url value='order/remove/${order.idOrder}' />"
						onclick="return confirm('Do you want delete this record ?')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
