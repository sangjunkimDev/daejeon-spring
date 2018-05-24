<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">

<!-- 라이브러리를 가진 jsp include -->
<%@include file="/include/jquery.jsp"%>
<%@include file="/include/jscookie.jsp"%>

<script type="text/javascript">
	//cookie 조회(return cookieValue)
	function getCookie(cookieName) {
		return Cookies.get(cookieName);
		/* 
		cookieName += "=";
		var cookies = document.cookie.split("; ");
		
		for (var i = 0; i < cookies.length; i++) {
			var cookie = cookies[i];
			
			if (cookie.indexOf(cookieName) >= 0) {
				return cookie.substring(cookieName.length);
			}
			
		}
		 */
	}
	
	//cookie 설정
	function setCookieValue(cookieName, cookieValue, expires1) {
		Cookies.set(cookieName, cookieValue, { expires: expires1, path: '/' });
		/*
		var today = new Date();
		today.setDate(today.getDate() + expires);
		
		document.cookie = cookieName + "=" + encodeURIComponent(cookieValue) + "; "
							+ "path=/; " + "expires=" + today.toGMTString() + ";";
		*/
	}
	
	//cookie 삭제
	function deleteCookie(cookieName) {
		setCookieValue(cookieName, "", -1);
	}
	
	//화면 로딩시 쿠키에 설정된 사용자 값을 확인하여 설정해준다
	function initUserId() {
		var userId = getCookie("userId");
		var remember = getCookie("remember");
		
		//아이들를 remember
		if (remember == "true") {
			$('#userId').val(userId);//사용자 아이디를 설정해준다
			$('#password').focus();//비밀번호 입력창으로 focus
			
			//remember checkbox check
			$(':checkbox').prop('checked', true);
		}
	}
	
	//event 핸들러 초기화
	function initEvent() {
		//로그인 버튼 클릭시의 이벤트
		$('#signinbtn').click(function(){
			//전송전 데이터 정리
			var checked = $('#remember').prop('checked');
			if (checked) {
				$('#remember').val('true');
			} else {
				$('#remember').val('false');
			}
			
			$('#frm').submit();
			
		})
		
		/* 
		//remember checkbox change
		$('#remember').change(function(){
			var flag = $(this).prop('checked');
			
			//체크가 된경우
			if (flag) {
				$(this).val('check');
			} else {
				$(this).val('uncheck');
			}
			
			
			
			//체크가 된경우
			if (flag) {
				setCookieValue("userId", $('#userId').val(), 30);
				setCookieValue("remember", true, 30);
			} else {// 체크가 해제 된 경우
				deleteCookie("userId");
				deleteCookie("remember");
			}
			
		})
		 */
	}
	
	
	//문서로딩
	$(function(){
		initUserId();
		initEvent();
	})
	
	
	
</script>
</head>

<body>
	<div class="container">

		<form id="frm" class="form-signin"
			action="<%=request.getContextPath()%>/loginMav" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="userId" class="sr-only">UserId</label> <input type="text"
				id="userId" name="mem_id" class="form-control"
				placeholder="아이디를 입력해주세요" required autofocus>
			<!-- 
        <label for="userId" class="sr-only">UserId</label>
        <input type="text" id="userIdsecond" name="userId" class="form-control" placeholder="아이디를 입력해주세요" required autofocus>
         -->
			<label for="password" class="sr-only">Password</label> <input
				type="password" id="password" name="mem_pass" class="form-control"
				placeholder="비밀번호를 입력하세요" required>
			<div class="checkbox">
				<label> <input type="checkbox" id="remember" value="remember" name="remember">
					Remember me
				</label>
			</div>
			<button id="signinbtn" class="btn btn-lg btn-primary btn-block" type="button">Sign
				in</button>
		</form>

	</div>
	<!-- /container -->
</body>
</html>