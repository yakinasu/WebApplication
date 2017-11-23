<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>読書管理ページ</title>
	</head>
	<body>
		<form method="get" action ="./MainPageServlet">
			新規で追加する場合はここをクリック
			<input type = "submit" name = "add" value = "追加する">
			<br>
			<input type="submit" name =  "search" value="検索">
			<input type = "submit" name ="upload" value = "編集する">
			<br>

		</form>
	</body>
</html>