<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="upload" method="post" enctype="multipart/form-data">
		  选择图片:<input type="file" name="file" accept="image/*" /> <br>
		  <input type="submit" value="上传">
	</form>
</body>
</html>