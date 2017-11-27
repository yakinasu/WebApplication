<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import= "logic.*, java.util.*" %>
<%
BookInfoLogic searchBookSql = new BookInfoLogic();
ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
list = searchBookSql.searchBookdb();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>読書管理ページ</title>
	</head>
	<body>
		<form method="get" action ="./servlet/MainPageServlet">
			新規で追加する場合はここをクリック
			<input type = "submit" name = "add" value = "追加する">
			<br>
			<input type="submit" name =  "search" value="検索">
			<input type = "submit" name ="upload" value = "編集する">
		</form>
			<br>
			<table border ="1">
				<tr>
					<th>isbn</th>
					<th>tytle</th>
					<th>page</th>
					<th>author</th>
				</tr>
				<% for (HashMap<String, String> search : list) { %>
				<tr>
					<td><%= search.get("isbn") %></td>
					<td><%= search.get("tytle") %></td>
					<td><%= search.get("page") %></td>
					<td><%= search.get("author") %></td>
					<%} %>
				</tr>
				</table>

	</body>
</html>