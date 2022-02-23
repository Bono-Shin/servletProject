<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert.do" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>제목</th>
					<th><input type="text" name="subject"></th>
					<th>작성자</th>
					<td><input type="text" name="writer">
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea name="content"></textarea></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="등록">
	</form>
</body>
</html>