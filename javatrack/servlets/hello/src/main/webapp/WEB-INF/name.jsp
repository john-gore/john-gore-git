<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hello!!</title>
</head>
<body>
<h1>Welcome User!!!</h1>
<h3>Name: <c:out value="${name}"/></h3>
<h3>Dojo Location: <c:out value="${location}"/></h3>
<h3>Language: <c:out value="${language}"/></h3>
<h3>Comment: <c:out value="${comment}"/></h3>
	<a href="/">Go Back</a>
	
</html>