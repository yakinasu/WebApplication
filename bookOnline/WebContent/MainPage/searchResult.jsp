<%@ page import= "beans.BookBean" %>
<%
BookBean bookBean = (BookBean)request.getAttribute("bookList");
%>
<html>
	<head>
	<meta charset="UTF-8">
	<title>SearchResult</title>
	</head>
	<body>
		<form method="get" action ='./servlet/BookDeleteServlet'>
			<table border = "1">
				<tr>
					<th>BookTitle</th>
						<td><%= bookBean.getBookTytle() %></td>
				</tr>
				<tr>
					<th>ISBNcode</th>
					<td><%= bookBean.getIsbn() %></td>
				</tr>
				<tr>
					<th>Page</th>
					<td><%= bookBean.getTotalPage() %></td>
				</tr>
				<tr>
					<th>Author</th>
					<td><%= bookBean.getAuthor() %></td>
				</tr>
				<tr>
					<th colspan="2">
					念のためISBNコードを再度入力してください。
					<input type = "text" class= "stringwidth" name = "isbn">
					<input type = "submit" value = "削除する">
				</th>
				</tr>
				ボタンをそのうち実装したい
		</form>
	</body>
</html>