<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>

<%
	BoardVO vo = (BoardVO)request.getAttribute("vo");
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="viewModify.do" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>제목</th>
					<th><input type="text" name="subject" value="<%=vo.getSubject() %>"></th>
					<th>작성자</th>
					<th><input type="text" name="writer" value="<%=vo.getWriter() %>"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>내용</th>
					<td colspan="3"><input type="text" name="content" value="<%=vo.getContent() %>"></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="bidx" value="<%=vo.getBidx() %>">
		<input type="submit" value="저장">
	</form>
</body>
</html>