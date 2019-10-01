<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
      $(function(){                    
           $(".delete").click(function(){
               var href=$(this).attr("href");
               $("#formdelete").attr("action",href).submit();
               return false;
           })
       })
</script>   
</head>
<body>
	<div align="center">this is JPA + Restful method to get Student s...</div>
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>修改</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${page.content}" var="s" varStatus="st">
			<tr>
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td><a href="student/${s.id}">修改</a></td>
				<td><a href="student/${s.id}" class="delete">删除</a></td>
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
    <form id="formdelete" action="" method="POST" >
       <input type="hidden" name="_method" value="DELETE">
   </form>
    <form action="student" method="post" align="center">
    	<input type="text" placeholder="Student name" name="name">
    	<input type="submit" value="add">
    </form>
    
</body>
</html>