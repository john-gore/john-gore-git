<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hello!!</title>
</head>
<body>
	<h1>Welcome User!!!</h1>
	<form method="POST" action="/submit">
    <label>Your name: <input type="text" name="name"></label>
    <label>Dojo Location: <select name="location">
    		<option value="tulsa">Tulsa</option>
  		<option value="denver">Denver</option>
  		</select></label>
    <label>Language: <select name="language">
    		<option value="mean">MEAN</option>
  		<option value="java">JAVA</option>
  		</select></label>
    <label>Comment: <input type="text" name="comment"></label>
    <button>Submit Info</button>
</form>
	
</html>