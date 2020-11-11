<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>レンタル管理システム</title>
<style type="text/css">
.menu{
	display:block;
	width:300px;
	padding-top:10px;
	padding-bottom:10px;
	text-align:center;
	border:2px solid;
	border-color:#aaaaaa #444444 #444444 #aaaaaa;
	text-decoration:none;
	font-color:#444444;
}
.menu:hover{
 	background:#ffcccc;
}
.menu:link{
	color:#000000;
}
.menu:visited{
	color:#000000;
}
</style>
</head>
<body>
<div align="center">
	<h1>レンタル管理システム（スタッフ用）</h1>
	<hr />
	<div>
		<table>
		<tr><td><a href="userList" class="menu">お客様一覧</a></td></tr>
		<tr><td><a href="productList" class="menu">商品一覧</a></td></tr>
		<tr><td><a href="proregist" class="menu">在庫登録</a></td></tr>
		
		
		
		</table>
		
	</div>
	
	<p><a href="slogout">ログアウト</a></p>
	</div>
</body>
</html>