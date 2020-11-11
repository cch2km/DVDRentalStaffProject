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
error.{
	color:#ff0000;
}
td{
	width:300px;
}
</style>
<title>在庫商品一覧</title>
</head>
<body>
<h2>${message}</h2>
<hr/>
<div>
	
	<c:if test="${pList.size()>0 }">
<table border="1">
	<tr><th>商品ID</th><th>商品名</th><th>商品英語名</th><th>タイプ</th>
	<th>ジャンル</th><th>アーティスト</th><th>監督</th><th>検索用名</th><th>在庫</th>
	<th>画像URL</th></tr>
	<c:forEach var="product" items="${pList}">
	<tr>
		<td><c:out value="${product.product_Id}"/></td>
		<td><c:out value="${product.product_name}"/></td>
		<td><c:out value="${product.ename}"/></td>
		<td><c:out value="${product.type}"/></td>
		<td><c:out value="${product.description}"/></td>
		<td><c:out value="${product.artist}"/></td>
		<td><c:out value="${product.director}"/></td>
		<td><c:out value="${product.dir}"/></td>
		<td><c:out value="${product.account}"/></td>
		<td><c:out value="${product.imgurl}"/></td>
		
		<td><a href="deletePro?proId=${product.product_Id}">削除</a></td>
		<td><a href="editPro?proId=${product.product_Id}">変更</a></td>			
	</tr>
	</c:forEach>
		
</table>
</c:if>
	<c:if test="${pList.size()==0}">
	<hr/>
		<p>no data...</p>
		</c:if>
</div>
<p><a href="menu">メニューへ</a></p>

</body>
</html>