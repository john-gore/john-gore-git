<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Your crappy pet!!!!</title>
</head>
<body>
	<h1>Add a Dog</h1>
	<form action="dogs" method="get">
	<p>Name: <input type="text" name ="name"></p>
	<p>Breed: <input type="text" name ="breed"></p>
	<p>Weight: <input type="text" name ="weight"></p>
	<input type="submit" value="submit">
	</form>
	<h1>Add a Cat</h1>
	<form action="cats" method="get">
	<p>Name: <input type="text" name ="name"></p>
	<p>Breed: <input type="text" name ="breed"></p>
	<p>Weight: <input type="text" name ="weight"></p>
	<input type="submit" value="submit">
	</form>
</body>
</html>