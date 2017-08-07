<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show</title>
</head>
<body>
	<h1>显示所有数据</h1>
	<table width="80%" align="center" cellspacing="0" border="1px">
		<caption>员工列表</caption>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>联系方式</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${staffs }" var="s">
		<tr>
			<td>${s.id }</td>
			<td>${s.name }</td>
			<td>${s.phone }</td>
			<td>
			<a href="${s.id }">编辑</a>
			<form action="./${s.id }/delete" method="post">
				<input type="submit" value="删除">
			</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<form action="./" method="post">
		<div>
			<label>编号</label>
			<input name="id">
		</div>
		<div>
			<label>姓名</label>
			<input name="name">
		</div>
		<div>
			<label>手机号</label>
			<input name="phone">
		</div>
		<div>
			<label></label>
			<input type="submit" value="创建">
		</div>
	</form>
	
	<ul>
		<li><a href="1234">edit</a></li>

		<li><form action="./" method="post">
				<input type="submit" value="create">
			</form></li>


		<li><form action="./1234/delete" method="post">
				<input type="submit" value="delete">
			</form></li>
	</ul>
</body>
</html>