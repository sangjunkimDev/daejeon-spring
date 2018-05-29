<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/include/jquery.jsp" %>
<script type="text/javascript">
	$(function(){
		$('select').on('change', function(){
			$('form').submit();
		})
		
		
	})
</script>
</head>
<body>
	global/view.jsp : ${language}<br>
	GREETING : <spring:message code="GREETING"/>

	<form action="${pageContext.request.contextPath}/global/view">
		<select name="language">
			<c:forEach items="${map }" var="item">
			
				<c:choose>
					<c:when test="${language == item.key}">
						<option value="${item.key}" selected>${item.value}</option>
					</c:when>
					
					<c:otherwise>
						<option value="${item.key}">${item.value}</option>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
		</select>
	</form>
</body>
</html>