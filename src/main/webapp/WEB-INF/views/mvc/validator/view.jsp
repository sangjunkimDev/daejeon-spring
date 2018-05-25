<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>validator의 view.jsp</h1>
	<h2>origin</h2>
	<form action="${pageContext.request.contextPath}/validator/origin" method="post">
		<input type="text" name="mem_id" value="${memberVO.mem_id }"><br>
		<input type="password" name="mem_pass"><br>
		<input type="submit" value="전송"><br>
	</form>
</body>
</html>