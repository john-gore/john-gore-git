<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<link rel = "stylesheet" type="text/css" href="style/index.css">
</head>
<body>
   <h1>Welcome <c:out value ="${currentUser.first_name}"></c:out> <c:out value ="${currentUser.last_name}"></c:out></h1>
   <c:out value ="${currentUser.id}"></c:out>
   <h1>Create an Event!</h1>
    
    <p class = "error"><form:errors path="event.*"/></p>
    
    <form:form method="POST" action="/addevent" modelAttribute="event">
    		<form:hidden path="users" value="${currentUser.id}"></form:hidden>
    		<form:hidden path="users" value="${currentUser.first_name}"></form:hidden>
    		<form:hidden path="users" value="${currentUser.last_name}"></form:hidden>
        <p>
            <form:label path="event_name">Event Name:</form:label>
            <form:input path="event_name"/>
        </p>
        <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date" />
        </p>
        <p>
            <form:label path="location_city">Location City:</form:label>
            <form:input path="location_city"/>
        </p>
        <p>
            <form:label path="location_state">Location State:</form:label>
            <form:input path="location_state"/>
        </p>
        <input type="submit" value="Add Event!"/>
    </form:form>
   
   <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>