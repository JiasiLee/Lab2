<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细信息</title>
</head>
<body>
<table align="center" width="500">
	<center><h1>详细信息</h1></center>
    <tr><td>ISBN:</td><td><s:property value="book.ISBN"/></td></tr>
    <tr><td>题目:</td><td><s:property value="book.title"/></td></tr>
    <tr><td>作者:</td><td><s:property value="book.name"/></td></tr>
    <tr><td>出版社:</td><td><s:property value="book.publisher"/></td></tr>
    <tr><td>价格:</td><td><s:property value="book.price"/></td></tr>
    <tr><td>出版日期:</td><td><s:property value="book.publishDate"/></td></tr>
    <tr><td>作者年龄:</td><td><s:property value="book.age"/></td></tr>
    <tr><td>作者国家:</td><td><s:property value="book.country"/></td></tr>
</table>
</body>
</html>
