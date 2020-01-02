<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Category Page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="resources/theme/css/style.css">
</head>
<body>
<h1>
	Add a Category
</h1>

<c:url var="addAction" value="/category/add" ></c:url>

<form:form action="${addAction}" commandName="category">
<table>
	<c:if test="${!empty category.nameCategory}">
	<tr>
		<td>
			<form:label path="idCategory">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="idCategory" readonly="true" size="200"  disabled="true" />
			<form:hidden path="idCategory" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="nameCategory">
				<spring:message text="Category Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="nameCategory" />
		</td> 
		<td>
			<form:errors path="nameCategory" />
		</td> 
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty category.nameCategory}">
				<input type="submit"
					value="<spring:message text="Edit Category"/>" />
			</c:if>
			<c:if test="${empty category.nameCategory}">
				<input type="submit"
					value="<spring:message text="Add Category"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Categories List</h3>
<c:if test="${!empty listCategories}">
	<table class="tg">
	<tr>
		<th width="80">Category ID</th>
		<th width="150">Category Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCategories}" var="category">
		<tr>
			<td>${category.idCategory}</td>
			<td>${category.nameCategory}</td>
			<td><a href="<c:url value='category/edit/${category.idCategory}' />" >Edit</a></td>
			<td><a href="<c:url value='category/remove/${category.idCategory}' />" onclick="return confirm('Do you want delete this record ?')">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
