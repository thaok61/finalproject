<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>OrderDetail Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="resources/theme/css/style.css">
</head>
<body>
	<h1>Add a OrderDetail</h1>

	<c:url var="addAction" value="/orderDetail/add"></c:url>

	<form:form action="${addAction}" commandName="orderDetail">
		<table>
			<c:if test="${!empty orderDetail.quantity}">
				<tr>
					<td><form:label path="idOrderDetail">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="idOrderDetail" readonly="true"
							size="200" disabled="true" /> <form:hidden path="idOrderDetail" />
					</td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="quantity">
						<spring:message text="Quantity" />
					</form:label></td>
				<td><form:input path="quantity" /></td>
				<td><form:errors path="quantity" /></td>
			</tr>
			<tr>
				<td><form:label path="idOrder">
						<spring:message text="Order" />
					</form:label></td>
				<td><form:select path="idOrder">
						<form:options items="${ordersList}" itemValue="idOrder"
							itemLabel="nameProduct" />
					</form:select></td>
				<td><form:errors path="idProduct" /></td>
			</tr>
			<tr>
				<td><form:label path="idProduct">
						<spring:message text="Product" />
					</form:label></td>
				<td><form:select path="idProduct">
						<form:options items="${productsList}" itemValue="idProduct"
							itemLabel="nameProduct" />
					</form:select></td>
				<td><form:errors path="idProduct" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty orderDetail.quantity}">
						<input type="submit"
							value="<spring:message text="Edit Order Detail"/>" />
					</c:if> <c:if test="${empty orderDetail.quantity}">
						<input type="submit"
							value="<spring:message text="Add Order Detail"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Order List</h3>
	<c:if test="${!empty listOrders}">
		<table class="tg">
			<tr>
				<th width="80">OrderDetail ID</th>
				<th width="150">OrderDetail Name</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listOrders}" var="orderDetail">
				<tr>
					<td>${orderDetail.idOrderDetail}</td>
					<td>${orderDetail.nameOrderDetail}</td>
					<td><a
						href="<c:url value='orderDetail/edit/${orderDetail.idOrderDetail}' />">Edit</a></td>
					<td><a
						href="<c:url value='orderDetail/remove/${orderDetail.idOrderDetail}' />"
						onclick="return confirm('Do you want delete this record ?')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
