<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />


<style type="text/css">
.error{
	color:#FF0000;
}
</style>
<title>在庫管理表修正</title>
</head>
<body>
	<h1>在庫管理表　修正</h1>
	<hr/>
	
	<form:form modelAttribute="productModel">
	<div class="error">${errorMessage}</div>
<table>
	<tr>
		<td>商品ID</td>
		<td><form:input path="product_Id" size="50"/> </td>
		
	</tr>
	<tr>
		<td>商品名</td>
		<td><form:input path="product_name" size="50"/> </td>
		<td><form:errors path="product_name" element="div" cssClass="error"/></td>
		
	</tr>
	<tr>
		<td>商品英語名</td>
		<td><form:input path="ename" size="50"/> </td>
		<td><form:errors path="ename" element="div" cssClass="error"/></td>
		
	</tr>
	<tr>
		<td>タイプ</td>
		<td><form:radiobutton path="type" label="DVD" value="DVD" />
		<form:radiobutton path="type" label="CD" value="CD"/></td>
		<td><form:errors path="type" element="div" cssClass="error"/></td>
		
	</tr>

	<tr>
		<td>在庫</td>
		<td><form:input path="account" size="10"/> </td>
		
	</tr>
	<tr>
		<td>画像URL</td>
		<td><form:input  path="imgurl" size="50"/> </td>
		
	</tr>
		
	<tr>
		<td>ジャンル</td>
		<td><form:radiobutton path="description" label="洋画" value="洋画" size="10" />
		<form:radiobutton path="description" label="邦画" value="邦画" size="10"/>
		<form:radiobutton path="description" label="音楽" value="音楽" size="10"/>
		</td>
		<td><form:errors path="description" element="div" cssClass="error"/></td>
		
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
		<td>検索用英語名</td>
		<td><form:input path="dir" size="30"/> </td>
		<td><form:errors path="dir" element="div" cssClass="error"/></td>
	</tr>
	<tr>
		<td>ストーリー</td>
		<td><form:input path="story" size="100"/> </td>
		<td><form:errors path="story" element="div" cssClass="error"/></td>
		
	</tr>
	
	<tr>
		<td colspan="3">
		<input type="submit" value="修正"  name="editProduct"/></td>
	</tr>

	</table>
	</form:form>
	
	<p><a href="menu">メニューへ戻る</a></p>
</body>
</html>