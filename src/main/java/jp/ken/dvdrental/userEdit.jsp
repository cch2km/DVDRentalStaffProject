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
<title>顧客情報編集</title>
</head>
<body>
<div align="center">
<h1>お客様情報を編集</h1>
<hr />
	
	<form:form modelAttribute="userModel">
	<div class="error">${errorMessage}</div>
	<table>
	<tr>
		<td>会員ID</td>
	
		<td><c:out value="${userModel.user_Id}"/>
		<input type="hidden" value="${userModel.user_Id}" name="user_Id"/>
		 </td>
	
	</tr>
	<tr>
		<td>名前</td>
		<td><c:out value="${userModel.name}"/>
		<input type="hidden" value="${userModel.name}" name="name"/>
		 </td>
		
	</tr>
	<tr>
		<td>フリガナ</td>
		<td><c:out value="${userModel.kana}"/>
		<input type="hidden" value="${userModel.kana}" name="kana"/> </td>
		
	</tr>
	<tr>
		<td>パスワード</td>
		<td><c:out value="${userModel.password}"/>
		<input type="hidden" value="${userModel.password}" name="password"/>
		</td>
	</tr>
	<tr>
		<td>生年月日</td>
		<td><c:out value="${userModel.birth}"/>
		<input type="hidden" value="${userModel.birth}" name="birth"/> </td>
	</tr>
		
	<tr>
		<td>性別</td>
		<td>
			<c:out value="${userModel.gender}"/>
			<input type="hidden" value="${userModel.gender}" name="gender"/>
		</td>
    </tr>
	<tr>
		<td>携帯番号</td>
		<td><c:out value="${userModel.phone}"/>
		<input type="hidden" value="${userModel.phone}" name="phone"/> </td>
		
	</tr>
	<tr>
		<td>メールアドレス</td>
		<td><c:out value="${userModel.email}"/>
		<input type="hidden" value="${userModel.email}" name="email"/> </td>
	</tr>
	
	<tr>
		<td>郵便番号</td>
		<td><c:out value="${userModel.zip}"/>
		<input type="hidden" value="${userModel.zip}" name="zip"/> </td>
	</tr>
	
	
	<tr>
		<td>住所</td>
		<td><c:out value="${userModel.address}"/>
		<input type="hidden" value="${userModel.address}" name="address"/> </td>
	</tr>
	<tr>
		<td>プラン</td>
		<td><form:select path="plan">
		　<option selected="selected">お試し</option>
	　	　<option >Bronze</option>
		　<option >Silver</option>
		　<option >Gold</option>
		</form:select></td>
		<td><form:errors path="plan" element="div" cssClass="error"/> </td>
	</tr>
	<tr>
		<td>ポイント</td>
		<td><form:input path="point" size="100"/></td>
		<td><form:errors path="point" element="div" cssClass="error"/> </td>
	</tr>
	<tr>
	
		<td colspan="3">
		<input type="submit" value="変更" name="edit"/>
		</td>
	</tr>

</table>

</form:form>
<p><a href="menu">メニューへ戻る</a></p>
</div>
</body>
</html>