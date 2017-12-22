<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${ currEvent.getName() }" /></title>
</head>
<body>
	<h1>Welcome <c:out value="${currentUser.firstName}" />!</h1>
	
		<p>Current Package: <c:out value="${currentUser.subscription.getSubscriptionName()  }"/></p>
		<p>Next Due date: <fmt:formatDate type="date" value="${currentUser.getStartDate() }" pattern="MM/dd/yyyy" /></p>
		<p>Amount Due: $<c:out value="${currentUser.subscription.getCost() }"/>0</p>
		<p>User Since: <fmt:formatDate type="date" value="${currentUser.getCreatedAt() }" pattern="MM/dd/yyyy" /></p>
		<p>
			<c:choose>
		    		<c:when test="${ currentUser.id < 2 }">
		    			<a href="/admin/subscriptions">Back to Admin Dashboard</a>
		    		</c:when>		
		   		<c:otherwise>
		   			<h1>Hello!</h1>
		   		</c:otherwise>
    			</c:choose>
    		</p>
    		<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>