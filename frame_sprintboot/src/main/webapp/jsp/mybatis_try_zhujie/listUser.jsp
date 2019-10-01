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
	<div align="center">this is Mybatis zhujie method to get User s...</div>
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>修改</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${page.list}" var="u" varStatus="st">
			<tr>
				<td>${u.id}</td>
				<td>${u.name}</td>
				<td><a href="edituser?id=${u.id}">修改</a></td>
				<td><a href="deluser?id=${u.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
			<a href="?start=1">[首  页]</a>
            <a href="?start=${page.pageNum-1}">[上一页]</a>
            <a href="?start=${page.pageNum+1}">[下一页]</a>
            <a href="?start=${page.pages}">[末  页]</a>
    </div>
	
    
    <br/>
    <form action="adduser" method="post" align="center">
    	<input type="text" placeholder="user name" name="name">
    	<input type="submit" value="add">
    </form>
    
</body>
</html>