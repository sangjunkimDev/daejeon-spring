<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("loading complete");
		var lineRangers = ["brown", "cony", "sally", "james"];
		var memberVO = {"mem_id":"brown", "mem_alias":"cony"};
		
		console.log(JSON.stringify(lineRangers));
		
		$('#before').text('before : ' + JSON.stringify(lineRangers));
		
		
		$('#call').on('click', function(){
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/json/requestBody/sendData",
				data : JSON.stringify(lineRangers),
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(data){
					console.log(data);
					$('#after').text('after : ' + JSON.stringify(data));
				},
				fail : function(xhr){
					console.log(xhr);
				}
			});
			
			
		})
		
		
		
		
		
		
		
		
		
	})
</script>
</head>
<body>
	<h1>mvc/json/view.jsp</h1>
	<span id="before"></span><br>
	<button id="call">전송</button><br>
	<span id="after"></span><br>
</body>
</html>