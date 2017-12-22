<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>Welcome to Liscense!!!</h1>
		<a href="/">First Page</a>
			<!-- ... -->
			<form:form method="POST" action="/persons" modelAttribute="person">
				
				<p>
				    <form:label path="first_name">First Name
				    <form:errors path="first_name"/>
				    <form:input path="first_name"/></form:label>
				</p>
				<p>
				    <form:label path="last_name">Last Name
				    <form:errors path="last_name"/>
				    <form:input path="last_name"/></form:label>
				</p>
				    <input type="submit" value="Submit"/>
				</form:form>
	</div>
</html>