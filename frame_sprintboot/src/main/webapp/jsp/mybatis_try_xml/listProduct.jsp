<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	this is Mybatis-xml method to get Product s...
	<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${ps}" var="p" varStatus="st">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>