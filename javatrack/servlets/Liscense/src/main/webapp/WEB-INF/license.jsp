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
		<h1>Add a license to a person!!!</h1>
		<a href="/">First Page</a>
			<!-- ... -->
			<form:form method="POST" action="/licenses" modelAttribute="license">
				
				<p>
				    <form:label path="person">Person
				    <form:select path="person" items="${people}" itemLabel="first_name"/>
				    <form:errors path="person"/>
				    </form:label>
				</p>
				<p>
				    <form:label path="state">State
				    <form:errors path="state"/>
				    <form:input path="state"/></form:label>
				</p>
				<p>
				    <form:label path="expiration_date">Expiration Date
				    <form:errors path="expiration_date"/>
				    <form:input type="date" path="expiration_date"/></form:label>
				</p>
				    <input type="submit" value="Submit"/>
				</form:form>
	</div>
</html>