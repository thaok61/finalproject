<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Product Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="resources/theme/css/style.css">
</head>
<body>
	<h1>Add a Product</h1>

	<c:url var="addAction" value="/product/add"></c:url>

	<form:form action="${addAction}" commandName="product">
		<table>
			<c:if test="${!empty product.nameProduct}">
				<tr>
					<td><form:label path="idProduct">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="idProduct" readonly="true" size="8"
							disabled="true" /> <form:hidden path="idProduct" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="nameProduct">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="nameProduct" /></td>
				<td><form:errors path="nameProduct" /></td>
			</tr>
			<tr>
				<td><form:label path="quantity">
						<spring:message text="Quantity" />
					</form:label></td>
				<td><form:input path="quantity" /></td>
				<td><form:errors path="quantity" /></td>
			</tr>
			<tr>
				<td><form:label path="price">
						<spring:message text="Price" />
					</form:label></td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="idCategory">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:select path="idCategory">
						<form:options items="${categoriesList}" itemValue="idCategory"
							itemLabel="nameCategory" />
					</form:select></td>
				<td><form:errors path="idCategory" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty product.nameProduct}">
						<input type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.nameProduct}">
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Products List</h3>
	<c:if test="${!empty listProducts}">
		<table class="tg">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="120">Product Quantity</th>
				<th width="120">Product Price</th>
				<th width="120">Category of Product</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listProducts}" var="product">
				<tr>
					<td>${product.idProduct}</td>
					<td>${product.nameProduct}</td>
					<td>${product.quantity}</td>
					<td>${product.price}</td>
					<td><c:forEach items="${categoriesList }" var="category">
							<c:if test="${category.idCategory eq product.idCategory}">
								<c:out value="${category.nameCategory }"></c:out>
							</c:if>
						</c:forEach></td>
					<td><a href="<c:url value='product/edit/${product.idProduct}' />">Edit</a></td>
					<td><a href="<c:url value='product/remove/${product.idProduct}' />"
						onclick="return confirm('Do you want delete this record ?')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
