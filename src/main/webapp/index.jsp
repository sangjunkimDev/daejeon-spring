<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello index
<img src="${pageContext.request.contextPath}/requestPart/pictureDownload?pictureName=Koala.jpg">
<a href="${pageContext.request.contextPath}/requestPart/pictureDownload?pictureName=Koala.jpg">download Koala</a>
</body>
</html>