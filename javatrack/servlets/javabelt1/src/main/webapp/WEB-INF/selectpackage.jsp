<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Packages!!</title>
</head>
<body>
	<h1>Please choose a Subscription and a Start Date <c:out value="${currentUser.firstName}" />!</h1>
	
    <form:form method="POST" action="/subscriptions/signup" modelAttribute="subscription">
	    
        <p>
				<form:label path="startDate" for="startDate">Start Date (1-31)</form:label>
				<form:input path="startDate" min="1" max="31" type="number" name="startDate"/>
			</p>
        <p>
            <form:label path="id">Subscription: </form:label>
            <form:select path="id">
					<c:forEach items="${subscriptions}" var="subscription">
						<form:option value="${subscription.id}" label="${subscription.subscriptionName} ($${subscription.cost})" />
					</c:forEach>
				</form:select>
        </p>
        <input type="submit" value="Sign Up!"/>
    </form:form>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>