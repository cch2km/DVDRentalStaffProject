<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Rental Record</title>
</head>
<body>
	<h3>レンタル履歴</h3>
	<hr/>
	<c:out value="${olist}"/>
<table border="1">
	<tr><th>注文番号</th><th>枚数</th><th>注文時間</th><th>返却時間</th></tr>
	<c:forEach var="record" items="${rentalList}">
	<tr>
		<td><c:out value="${record.id}"/></td>
		<td><c:out value="${record.total}"/></td>
		<td><fmt:formatDate value="${record.orderTime}" pattern="yyyy-MM-dd" /></td>
		<td><fmt:formatDate value="${record.returnTime}" pattern="yyyy-MM-dd" /></td>
		<td><a href="recordDetail?productId=">詳細</a></td>
		<td><a href="deleteRecord?orderId=${record.id}">削除</a></td>
		
			
	</tr>
	</c:forEach>
		
</table>

<p><a href="menu">メニュー</a></p>

</body>
</html>
		
		
		