<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Dojo</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1>New Dojo</h1>
		
		<form:form action="/dojos" method="POST" modelAttribute="dojo">
			<p>
				<form:label path="name">Name:</form:label>
				<form:input type="text" path="name" />			
			</p>
			<input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>