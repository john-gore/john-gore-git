<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lookify</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1>Add a Dojo!!!</h1>
		<a href="/persons/new">Add new Person</a>
		<a href="/licenses/new">Add License to person</a>
		<c:forEach items="${people}" var="person">
			<p><a href="persons/${person.id}"><c:out value="${person.first_name}"/> <c:out value="${person.last_name}"/></a></p>
		</c:forEach>
	</div>
</html>