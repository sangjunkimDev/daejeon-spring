<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>uploadResult</h1>
	${path}<br>
	${name}<br>
	${originalFilename}<br>
	${filePath}<br> 
	
	<!-- filePath : /upload/brown.png -->
	<hr>
	${pageContext.request.contextPath}${uploadUrl}/${originalFilename}<br>
	<img src="${pageContext.request.contextPath}${uploadUrl}/${originalFilename}">
</body>
</html>