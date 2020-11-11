<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
.error{
	color:#ff0000;
}
</style>
<title>DVD在庫管理</title>
</head>
<body>
<h1>DVD在庫管理</h1>
<hr />
<form:form modelAttribute="productModel">
<table>
	<tr>
		<td>名前</td>
		<td><form:input path="product_name" size="50"/> </td>
		
	</tr>
		
	<tr>
		<td>商品英語名</td>
		<td><form:input path="ename" size="50"/> </td>
		
	</tr>
	<tr>
		<td>タイプ</td>
		<td><form:radiobutton path="type" label="DVD" value="DVD" checked="true" />
		<form:radiobutton path="type" label="CD" value="CD"/></td>

	</tr>
	<tr>
		<td>在庫</td>
		<td><form:input path="account" size="10"/> </td>
		
	</tr>
	<tr>
		<td>画像</td>
		<td><form:input  path="imgurl" size="50"/> </td>
		
	</tr>
	<tr>
		<td>ジャンル</td>
		<td><form:checkbox path="description" label="洋画" value="洋画" size="10"/>
		<form:checkbox path="description" label="邦画" value="邦画" size="10"/>
		<form:checkbox path="description" label="音楽" value="音楽" size="10"/>
		
		</td>
		
	</tr>
	<tr>
		<td>アーティスト</td>
		<td><form:input path="artist" size="10"/> </td>
		
	</tr>
	<tr>
		<td>監督</td>
		<td><form:input path="director" size="10"/> </td>
		
	</tr>
	<tr>
		<td>監督/アーティスト(英語名)</td>
		<td><form:input path="dir" size="10"/> </td>
		
	</tr>
	<tr>
		<td>ストーリー</td>
		<td><form:input path="story" size="100"/> </td>
		
	</tr>
	
	<tr>
		<td colspan="3"><input type="submit" value="登録"/></td>
	</tr>

	</table>
	</form:form>
</body>
</html>