<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
       /*将post method 改变为delete*/
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
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${cs}" var="c" varStatus="st">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td><a href="category/${c.id}">编辑</a></td>
				<td><a href="category/${c.id}" class="delete">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
    </div>
    
    <form action="category" method="post" align="center">
    	 <input type="text" name="name" placeholder="input a name" />
    	 <input type="submit" value="增加" />
    </form>
    
   <form id="formdelete" action="" method="POST" >
       <input type="hidden" name="_method" value="DELETE">
   </form>
    
</body>
</html>