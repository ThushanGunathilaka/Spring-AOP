<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<form:form action="login.do" method="POST" commandName="user">
	<table>
		<tr>
			<td>user name</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>password</td>
			<td><form:input path="password" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Login" />
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>