<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${ pickedPost.getIdea() }" /></title>
</head>
<body>
	<p><a href="/dashboard/${ pickedPost.createdByUser.getId() }/showUser"><c:out value="${pickedPost.createdByUser.getFirstName() }"/></a> says:</p>
	<p><c:out value="${ pickedPost.getIdea() }" /></p>
	
		
	<a href="/dashboard">Bright Ideas!</a>
	
	<h1>People Who Liked This Post!</h1>
	
	<table>
	    	<thead>
	    		<tr>
				<th>Alias</th>
				<th>Name</th>
			</tr>
	    	</thead>
	    	<c:forEach items="${ pickedPost.getUserlikes() }" var="user">
	    		<tr>
	    			
			    	<c:set var="currUserID" scope="session" value="${ user.getId() }"/>
		    			<c:if test="${user.getId() == user.getId()}" var="booleanValue">
		    				<td><c:out value="${user.getAlias() }"/></td>
		    				<input type="hidden" name="record" value="<c:out value="${booleanValue}"/>" />
		    			</c:if>
	    			<td><a href="/dashboard/${ user.getId() }/showUser"><c:out value="${user.getFirstName() }"/></a></td>
	    		</tr>
    		</c:forEach>
	</table>   		
    		<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>