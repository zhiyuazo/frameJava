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
    <form action="../category/${c.id}" method="post" align="center">
    	 <input type="text" name="name" value="${c.name}" />
    	 <input type="hidden" name="_method" value="PUT">
    	 <input type="submit" value="修改" />
    </form>
    
</body>
</html>