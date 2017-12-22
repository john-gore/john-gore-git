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
		<a href="/persons/new">Add new Person</a>
		<a href="/licenses/new">Add License to person</a>



		<h1>Show Person <c:out value="${person.first_name}"/> <c:out value="${person.last_name}"/></h1>
		
		<p>State: <c:out value="${person.license.state}"/></p>
		<p>License: <c:out value="${person.license.id}"/></p>
		<p>Expiration Date: <c:out value="${person.license.expiration_date}"/><fmt:formatDate type="date" value="${person.license.expiration_date}" pattern="MM/dd/yyyy" /></p>
	</div>
</html>