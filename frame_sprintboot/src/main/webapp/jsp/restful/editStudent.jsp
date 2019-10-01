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
	<form action="../student/${s.id}" method="post">
		<input type="text" name="name" value="${s.name}"> <br/>
		<input type="submit" value="update">	
		<input type="hidden" name="_method" value="PUT">
	</form>
</body>
</html>