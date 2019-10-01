<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		filename: ${filename}
		<br/>
		host:
		<br/>
		<%=request.getServletContext().getRealPath("")%>
		<br/>
		<%=request.getRequestURI()%>
		<br/>
		<%=request.getRequestURL()%>
		<br/>
		<img src="jsp/upload/uploaded/${filename}"  width="600px" height="800px"/>
		<br/>
	</div>

</body>
</html>