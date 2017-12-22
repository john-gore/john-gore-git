<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="static/css/style.css">
<title>Number Game</title>
</head>
<body>
	<% Integer ans = (Integer) request.getSession().getAttribute("answer"); %>
	<% String result = (String) request.getSession().getAttribute("result"); %>
	<%= ans %>

	<h1>Welcome to the Great Number Game!</h1>
	<h3>I am thinking of a number between 1 and 100</h3>
	<h3>Take a guess!</h3>
	
	
	<% if(!result.equals("") && (result.equals("Too High!") || result.equals("Too Low!"))) { %>
		<div class="result red">			
			<h1><%= result %></h1>
		</div>
	<% } %>
	
	<% if(result.equals("Correct")) { %>
		<div class="result green">
			<h1><%= ans %> was the number!</h1>
			<form action='Home' method='POST'>
				<input type="hidden" name="restart" value="restart">
				<input type='Submit' value='Play again!'/>
			</form>
		</div>
	<% } else { %>
		<form action="Home" method="POST">
			<input type="number" min="1" max="100" name="guess"/>
			<input type="submit" value="Submit"/>
		</form>
	<% } %>
</body>
</html>