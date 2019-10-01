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
	<div align="center">this is JPA method to get Categorys...</div>
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>修改</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${page.content}" var="c" varStatus="st">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td><a href="editcategory?id=${c.id}">修改</a></td>
				<td><a href="delcategory?id=${c.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
			<a href="?start=0">[首  页]</a>
            <a href="?start=${page.number-1}">[上一页]</a>
            <a href="?start=${page.number+1}">[下一页]</a>
            <a href="?start=${page.totalPages-1}">[末  页]</a>
    </div>
	
    
    <br/>
    <form action="addcategory" method="post" align="center">
    	<input type="text" placeholder="Category name" name="name">
    	<input type="submit" value="add">
    </form>
    
</body>
</html>