<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
    <h1>Hi <c:out value="${currentUser.firstName}" />!</h1>
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <p><form:errors path="post.*"/></p>
    <form:form method="POST" action="/dashboard/create" modelAttribute="post">
	    <p>
            <form:label path="idea">Post Something Witty here!</form:label>
            <form:input path="idea"/>
        </p>
        <input type="submit" value="Idea!"/>
    </form:form>
    
    	
    <c:forEach items="${posts}" var="post">
    			<p><a href="/dashboard/${ post.createdByUser.getId() }/showUser"><c:out value="${post.createdByUser.getFirstName() }"/></a> says:</p>
    			
    			<p><c:out value="${post.getIdea() }"/> </p>
    			<p><a href="/dashboard/${ post.getId() }/like">Like</a></p>
    			<p><a href="/dashboard/${ post.getId() }/seeUsersWhoLiked"><c:out value="${post.getUserlikes().size() }"/> People Like This!</a></p>
    			<c:choose>
	    				<c:when test="${ post.createdByUser.getId() == currentUser.id }">
	    					<a href="dashboard/${ post.getId() }/delete">Delete</a>
	    				</c:when>
	   				<c:otherwise>
	   					<p></p>
	   				</c:otherwise>
    				</c:choose> 
    	</c:forEach>
</body>
</html>