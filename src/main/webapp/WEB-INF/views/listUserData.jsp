<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>お客様一覧表</title>
</head>
<body>
		<h1>お客様一覧表</h1>
		<hr/>
	<c:if test="${userList.size()>0 }">
<table border="1">
	<tr><th>お客様ID</th><th>プラン</th><th>お名前</th><th>性別</th>
	<th>携帯電話</th><th>メールアドレス</th><th>郵便番号</th>
	<th>住所</th><th>ポイント</th></tr>
		<c:forEach var="user" items="${userList}">
	<tr>
		<td><c:out value="${user.user_Id}"/></td>
		<td><c:out value="${user.plan}"/></td>
		<td><c:out value="${user.name}"/></td>
		<td><c:out value="${user.gender}"/></td>
		<td><c:out value="${user.phone}"/></td>
		<td><c:out value="${user.email}"/></td>
		<td><c:out value="${user.zip}"/></td>
		<td><c:out value="${user.address}"/></td>
		<td><c:out value="${user.point}"/></td>
		
		<td><a href="deleteUser?userId=${user.user_Id}">削除</a></td>
		<td><a href="editUser?userId=${user.user_Id}">変更</a></td>
		<td><a href="record?userId=${user.user_Id}">レンタル履歴</a></td>
	</tr>
	</c:forEach>
		
</table>
</c:if>
	<c:if test="${vagueList.size()==0}">
	<hr/>
		<p>no data...</p>
		</c:if>
<p><a href="menu">メニューへ</a></p>
</body>
</html>