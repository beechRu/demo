<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit</title>
<style type="text/css">
label {
	display: block;
}
</style>
</head>
<body>
	<h1>edit: ${staff.name }</h1>
	<form action="${staff.id }" method="post">
		<input type="hidden" name="id" value="${staff.id }">
		<div>
			<label>姓名</label> <input name="name" value="${staff.name }"
				readonly="readonly">
		</div>
		<div>
			<label>电话号码</label> <input name="phone" value="${staff.phone }">
		</div>
		<div>
			<label></label>
			<input type="submit" value="更新">
		</div>
	</form>
</body>
</html>