<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Languages</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<p class="float"><a href="/dashboard">Dashboard</a></p><br />
		<p><c:out value="${song.title}"/></p>
		<p><c:out value="${song.artist}"/></p>
		<p><c:out value="${song.rating}"/></p>
		<p><c:out value="${song.id}"/></p>
		<p><a href="/songs/delete/${song.id}">Delete</a></p>	
	</div>
</body>
</html>