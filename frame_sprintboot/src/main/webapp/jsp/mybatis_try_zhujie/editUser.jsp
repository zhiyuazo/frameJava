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
	<form action="updateuser" method="post">
		<input type="text" name="name" value="${c.name}"> <br/>
		<input type="hidden" name="id" value="${c.id}"> <br/>
		<input type="submit" value="update">	
	</form>
</body>
</html>