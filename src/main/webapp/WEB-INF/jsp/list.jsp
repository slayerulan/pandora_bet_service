<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page session ="false" %>
    <%@ page errorPage="jsp/errorpage.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.7.2/angular.min.js"></script>
<script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<body ng-app = "fr">
	<h1>Spring 3 MVC REST web service</h1>
	
	<h3>Movie Name hfg: ${movie.size()}</h3>
		<!-- <ol>
            <li ng-repeat = "${movie} in entry">
               {{'Key = ' + entry.key + 'Value = ' + entry.value }}
            </li>
        </ol> -->
	 <c:forEach items="${movie}" var="entry">
	    Key = ${entry.key}, value = ${entry.value}<br>
	</c:forEach>	
</body>
</html>