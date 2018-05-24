<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table th,td {
		border: 1px solid black;
		border-collapse: collapse;
	}
	
</style>
</head>
<body>
	<h1>login 성공</h1>
	${LOGIN_USER.mem_id }<br>
	${LOGIN_USER.mem_name }<br>
	${LOGIN_USER.mem_alias }<br>
	
	<table>
		<thead>
			<tr>
				<th>seq</th>
				<th>title</th>
				<th>content</th>
				<th>regId</th>
				<th>regDt</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList }" var="boardVO">
				<tr>
					<td>${boardVO.seq }</td>
					<td>${boardVO.title }</td>
					<td>${boardVO.content }</td>
					<td>${boardVO.regId }</td>
					<td><fmt:formatDate value="${boardVO.regDt }" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>