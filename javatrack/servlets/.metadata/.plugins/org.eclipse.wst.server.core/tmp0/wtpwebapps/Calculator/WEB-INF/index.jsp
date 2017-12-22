<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La Calculadora</title>
<link rel="stylesheet" type="text/css" href="static/css/style.css">
</head>
<body>
	<div id="interface">
		<p>You must press equals (=) for calculation.</p>
        <form action="calculate" method="POST">
            <input type="text" id="inputs" name="userInput" value="${sessionInput}">
            <div>
                <ul id="number-pad">
                    <li><button name="character" value="1">1</button></li>
                    <li><button name="character" value="2">2</button></li>
                    <li><button name="character" value="3">3</button></li>
                    <li><button name="character" value="/">/</button></li><br>
                    <li><button name="character" value="4">4</button></li>
                    <li><button name="character" value="5">5</button></li>
                    <li><button name="character" value="6">6</button></li>
                    <li><button name="character" value="*">x</button></li><br>
                    <li><button name="character" value="7">7</button></li>
                    <li><button name="character" value="8">8</button></li>
                    <li><button name="character" value="9">9</button></li>
                    <li><button name="character" value="-">-</button></li><br>
                    <li class="space-right"><button name="character" value="0">0</button></li>
                    <li><button name="character" value="equal">=</button></li>
                    <li><button name="character" value="+">+</button></li>
                </ul>
            </div>
        </form>
	</div>
	
	<% 
		String results = (String) session.getAttribute("results");
		String[] allResults;
		
		if(results.equals("")) {
			allResults = new String[0];
		} else {
			allResults = results.split(",");	
		} 
	%>
	<div id="results">
		<h4>Previous Results</h4>
		<div>
			<ul id="result-items">
				<% for(int i = 0; i < allResults.length; i++) { %>
					<li><%= i+1 %>) <%= allResults[i] %></li>
				<% } %>
			</ul>
		</div>
	</div>
</body>
</html>