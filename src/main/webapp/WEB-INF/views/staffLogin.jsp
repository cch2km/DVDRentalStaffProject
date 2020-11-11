<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>スタッフ登録</title>
<style type="text/css">
	.error{color:#ff0000;}
	table{
		border-collapse: separate;
		border-spacing: 10px;
	}
</style>
</head>
<body>
<h1>スタッフログイン</h1>
<hr/>
<form:form modelAttribute="loginModel">
<div class="error">${errorMessage}</div>
<table>
<tr>
	<td>スタッフID</td>
	<td><form:input path="staffId" /></td>
	<td><form:errors path="staffId" element="div" cssClass="error"/></td>
</tr>
<tr>
	<td>パスワード</td>
	<td><form:password path="password" /></td>
	<td><form:errors path="password" element="div" cssClass="error"/></td>
</tr>
<tr>
	<td colspan="3"><input type="submit" value="ログイン"/></td>
</tr>
</table>

</form:form>

</body>
</html>
