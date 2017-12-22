<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Category Page</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1>Questions Dahsboard</h1>
		<div class="container">
		<div id="dashboard-header" class="table-display flex header">
		<%-- 	<form action="/search" method="POST">
				<input id="searchText" type="text" placeholder="Artist Name" name="artist" />
				<input class="button" type="submit" value="Search Artists"/>
			</form> --%>
		</div>
		
		<table>
			<thead>
				<tr>
					<th>Questions</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="q" items="${questions}">
					<tr>
						<td>
							<a href="/questions/${q.id}"><c:out value="${q.question}"/></a>
						</td>
						<td>
							<c:forEach var="tag" items="${q.tags}" varStatus="loop">
								<c:out value="${tag.subject}" /><c:if test="${!loop.last}">,</c:if>
							</c:forEach>
						</td>
					</tr>	
				</c:forEach>							
			</tbody>	
		</table>
		<a href="/new">New Question</a>
	</div>
	</div>
</body>
</html>