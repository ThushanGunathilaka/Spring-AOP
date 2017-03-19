<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Holder Management</title>
</head>
<body>
<h1>Account Holder Data</h1>
<form:form action="accountHolder.do" method="POST" commandName="CombinedCommand">
	<table>
		<tr>
			<td>ID</td>
			<td><form:input path="accountHolder.accountHolderId" /></td>
		</tr>
		<tr>
			<td>First name</td>
			<td><form:input path="accountHolder.firstName" /></td>
		</tr>
		<tr>
			<td>Last name</td>
			<td><form:input path="accountHolder.lastName" /></td>
		</tr>
		<tr>
			<td>phone</td>
			<td><form:input path="accountHolder.phone" /></td>
		</tr>
		<tr>
			<td>address</td>
			<td><form:input path="accountHolder.address" /></td>
		</tr>
		<tr>
			<td>account type</td>
			<td><form:input path="account.accountType" /></td>
		</tr>
		<tr>
			<td>initial balance</td>
			<td><form:input path="account.balance" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<th>ID</th>
	<th>First name</th>
	<th>Last name</th>
	<th>phone</th>
	<th>address</th>
	<c:forEach items="${accountHolderList}" var="accountHolder">
		<tr>
			<td>${accountHolder.accountHolderId}</td>
			<td>${accountHolder.firstName}</td>
			<td>${accountHolder.lastName}</td>
			<td>${accountHolder.phone}</td>
			<td>${accountHolder.address}</td>
		</tr>
	</c:forEach>
</table>
<table border="1">
	<th>ID</th>
	<th>Balance</th>
	<th>Account Type</th>
	<th>Date Started</th>
	<c:forEach items="${accountList}" var="account">
		<tr>
			<td>${account.accountId}</td>
			<td>${account.balance}</td>
			<td>${account.accountType}</td>
			<td>${account.dateStarted}</td>
		</tr>
	</c:forEach>
</table>
<table border="1">
	<th>Transaction ID</th>
	<th>Transaction Type</th>
	<th>Transaction Amount</th>
	<th>Transaction Date</th>
	<th>Account Holder ID</th>
	<th>Account ID</th>
	<c:forEach items="${transactionList}" var="transaction">
		<tr>
			<td>${transaction.transactionId}</td>
			<td>${transaction.transactionType}</td>
			<td>${transaction.transactionAmount}</td>
			<td>${transaction.transactionDate}</td>
			<td>${transaction.transactionAccountHolderId}</td>
			<td>${transaction.transactionAccountId}</td>
		</tr>
	</c:forEach>
</table>
<h1>Transactions</h1>
<br/>
<form:form action="transaction.do" method="POST" commandName="CombinedCommand">
	<table>
		<tr>
			<td>Account Holder ID</td>
			<td><form:input path="transaction.transactionAccountHolderId" /></td>
		</tr>
		<tr>
			<td>Account ID</td>
			<td><form:input path="transaction.transactionAccountId" /></td>
		</tr>
		<tr>
			<td>Amount</td>
			<td><form:input path="transaction.transactionAmount" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Deposit" />
				<input type="submit" name="action" value="Withdraw" />
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>