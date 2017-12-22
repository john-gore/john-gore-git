<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit an Event</h1>
    
	    <p><form:errors path="getTogether.*"/></p>
	    <form:form method="POST" action="events/{id}/edit" modelAttribute="getTogether">
		    <p>
	            <form:label path="name">Name:</form:label>
	            <form:input path="name"/>
	        </p>
	        <p>
	        	<form:label path="eventDate">Date:</form:label>
	            <form:input path="eventDate" type="date"/>
	        </p>
	        <p>
	            <form:label path="city">Location:</form:label>
	            <form:input path="city"/>
	            <form:select path="state">
	            	<form:options items="${stateMap}"/>
	            </form:select>
	        </p>
        <input type="submit" value="Update Event!"/>
    </form:form>
</body>
</html>