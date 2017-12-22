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
			<h1>Welcome to Lookify!!!</h1>
			<a href="/dashboard">Start Looking!!!</a>
		</div>
		<div class="form-container">
			<form:form action="/newsongs" method="POST" modelAttribute="song">
				<p>
					<form:label path="title" for="title">Title</form:label>
					<form:input path="title" class="border" type="text" name="title"/>
				</p>
				<p>
					<form:label path="artist" for="artist">Artist</form:label>
					<form:input path="artist" class="border" type="text" name="artist"/>
				</p>
				<p>
					<form:label path="rating" for="rating">Rating(1-10)</form:label>
					<form:input path="rating" class="border" type="number" min ="1" max = "10" name="rating"/>
				</p>
					<input class="float" type="submit" value="Add Song" />						
			</form:form>
		</div>
	</body>
</html>