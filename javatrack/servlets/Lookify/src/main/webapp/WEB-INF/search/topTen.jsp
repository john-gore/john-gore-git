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
	<a href="/songs/new">Add New</a>
	<a href="/search/topTen">Top Songs</a>
	<h1>Top Ten List!!!</h1>
		<table>
			<thead>
				<tr>
					<th>Rating</th>
					<th>Title</th>
					<th>Artist</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="song" varStatus="loop" items="${songs}">
					<tr>
						<td>
							<c:out value="${song.rating}"/>
						</td>
						<td><c:out value="${song.title}"/></td>

						<td>
							<c:out value="${song.artist}"/>			
						</td>
					</tr>	
				</c:forEach>							
			</tbody>
		</table>
	</div>
</body>
</html>