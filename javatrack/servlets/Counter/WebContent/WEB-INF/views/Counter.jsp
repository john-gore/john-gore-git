<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Great Counter!!!</title>
<link rel="stylesheet" type="text/css" href="static/stylesheets/style.css" />
</head>
<body>
	<a href="Counter">Click me</a>
	<h1>You have clicked the button <%= session.getAttribute("clicks") %> times</h1>
	<a href="Restart">Restart</a>
</body>
</html>