<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ninja Gold Game</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
	    <h1>Your gold: <span id="gold" class="border"><c:out value="${gold}" /></span></h1>
	    <form action="/reset" method="get">
	        <input type="submit" value="Reset Gold">
	    </form>
	    <div class="row">
	        <div class="task border">
	            <h3>Farm</h3>
	            <p>(earns 10-20 gold)</p>
	            <form action="/process" method="post">
	            	<input type="hidden" name="building" value="farm" />
	             	<input type="submit" value="Find Gold!"/>
	            </form>
	        </div>
	        <div class="task border">
	            <h3>Cave</h3>
	            <p>(earns 5-10 gold)</p>
	            <form action="/process" method="post">
	            	<input type="hidden" name="building" value="cave" />
	            	<input type="submit" value="Find Gold!"/>
	            </form>
	        </div>
	        <div class="task border">
	            <h3>House</h3>
	            <p>(earns 2-5 gold)</p>
	            <form action="/process" method="post">
	            	<input type="hidden" name="building" value="house" />
	            	<input type="submit" value="Find Gold!"/>
	            </form>
	        </div>
	        <div class="task border">
	            <h3>Casino</h3>
	            <p>(earn/lose 0-50 gold)</p>
	            <form action="/process" method="post">
	            	<input type="hidden" name="building" value="casino" />
	             	<input type="submit" value="Find Gold!"/>
	            </form>
	        </div>
	    </div>
	    
	    <div class="activity">
	    	<h3>Activities:</h3>
			<c:forEach var="msg" items="${messages}">	
				<c:choose>
					<c:when test="${msg.contains('lost')}">
						<p class="red"><c:out value="${msg}"/></p>
					</c:when>
					<c:otherwise>
						<p class="green"><c:out value="${msg}"/></p>
					 </c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>
</body>
</html>