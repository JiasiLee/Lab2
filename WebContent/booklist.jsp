<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理</title>
</head>
<body>
<form action="findbook" method="post" onsubmit="return check(this);">
<table align="center" width="400">
	<td>作者姓名：</td>
	<td><input type="text" name="Name"/></td>
	<td><input type="submit" value="查询"/></td>
</table>
<hr>
<table class="default" width="100%">
	<col width="10%">
	<col width="20%">
	<col width="10%">
	<col width="20%">
	<col width="10%">
	<col width="30%">
	<tr class="title">
		<td>ISBN</td>
		<td>书名</td>
		<td>作者</td>
		<td>出版社</td>
		<td>价格</td>
		<td>操作</td>
	</tr>
	<s:iterator id="u" value="list">
	    <tr>
	        <td><s:property value="#u.ISBN"/></td>
	        <td><a href="detail.action?ISBN=<s:property value="#u.ISBN"/>"><s:property value="#u.title"/></a></td>
	        <td><s:property value="#u.name"/> </td>
	        <td><s:property value="#u.publisher"/> </td>
	        <td><s:property value="#u.price"/> </td>
	        <td><a href="delete.action?ISBN=<s:property value="#u.ISBN"/>">删除</a></td>
	        
	    </tr>
	</s:iterator>
</table>
</form>
</body>
</html>
