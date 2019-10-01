<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	session中记录的访问次数：${count}
	<form action="clear" method="post">
		<input type="submit" value="clear" />
	</form>
	
</body>
</html>