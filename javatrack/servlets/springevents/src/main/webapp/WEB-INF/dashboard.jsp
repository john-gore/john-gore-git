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
    <h1>Welcome Page <c:out value="${currentUser.firstName}" /></h1>
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    <p>Here are some of the events in your state:</p>
    <table>
    	<thead>
    		<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
    	</thead>
    	<c:forEach items="${inStateGetTogethers }" var="inStateGetTogether">
    		<tr>
    			<td><a href="events/${ inStateGetTogether.getId() }"><c:out value="${inStateGetTogether.getName() }"/></a></td>
    			<td><fmt:formatDate value="${inStateGetTogether.getEventDate() }" type = "date" dateStyle="long" /></td>
    			<td><c:out value="${inStateGetTogether.getCity() }"/></td>
    			<td><c:out value="${inStateGetTogether.getCreatedByUser().getFirstName() }"/></td>
    			<td>
    				<c:choose>
	    				<c:when test="${ inStateGetTogether.getAttendingUsers().contains(currentUser) }">
	    					Joining <a href="/events/${ inStateGetTogether.getId() }/cancel">Cancel</a>
	    				</c:when>
	   					<c:when test="${ inStateGetTogether.getCreatedByUser() == currentUser }">
	   						<a href="/events/${ inStateGetTogether.getId() }/edit">Edit</a>
	   						<a href="/events/${ inStateGetTogether.getId() }/delete">Delete</a>
	   					</c:when>
	   					<c:otherwise>
	   						<a href="/events/${ inStateGetTogether.getId() }/join">Join</a>
	   					</c:otherwise>
    				</c:choose>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
    <p>Here are some of the events in other states:</p>
    <table>
    	<thead>
    		<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
    	</thead>
    	<c:forEach items="${outStateGetTogethers }" var="outStateGetTogether">
    		<tr>
    			<td><a href="events/${ outStateGetTogether.getId() }"><c:out value="${ outStateGetTogether.getName() }"/></a></td>
    			<td><fmt:formatDate value="${outStateGetTogether.getEventDate() }" type = "date" dateStyle="long" /></td>
    			<td><c:out value="${outStateGetTogether.getCity() }"/></td>
    			<td><c:out value="${outStateGetTogether.getCreatedByUser().getFirstName() }"/></td>
    			<td>
    				<c:choose>
	    				<c:when test="${ outStateGetTogether.getAttendingUsers().contains(currentUser) }">
	    					Joining <a href="/events/${ outStateGetTogether.getId() }/cancel">Cancel</a>
	    				</c:when>
	   					<c:when test="${ outStateGetTogether.getCreatedByUser() == currentUser }">
	   						<a href="/events/${ outStateGetTogether.getId() }/edit">Edit</a>
	   						<a href="/events/${ outStateGetTogether.getId() }/delete">Delete</a>
	   					</c:when>
	   					<c:otherwise>
	   						<a href="/events/${ outStateGetTogether.getId() }/join">Join</a>
	   					</c:otherwise>
    				</c:choose>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
    <h1>Create an Event</h1>
    <p><form:errors path="getTogether.*"/></p>
    <form:form method="POST" action="/events/create" modelAttribute="getTogether">
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
        <input type="submit" value="Create Event!"/>
    </form:form>
    
</body>
</html>