<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title"/></title>

<style type="text/css">
	.header {
		width: 500px;
		height: 100px;
		background-color: black;
	}
	
	.menu {
		float: left;
		width: 200px;
		height: 500px;
		background-color: blue;
	}
	
	.body{
		width: 500px;
		height: 500px;
		background-color: pink;
	}
	
	.footer{
		clear: both;
		width: 500px;
		height: 100px;
		background-color: yellow;
	}

</style>

</head>
<body>
	<!-- header -->
	<div class="header"><tiles:insertAttribute name="header"/></div>
	
	<!-- menu -->
	<div class="menu"><tiles:insertAttribute name="menu"/></div>
	
	<!-- body -->
	<div class="body"><tiles:insertAttribute name="body"/></div>
	
	<!-- footer -->
	<div class="footer"><tiles:insertAttribute name="footer"/></div>
	
	
	
</body>
</html>