<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>

<%
	ArrayList<BoardVO> alist = (ArrayList<BoardVO>)request.getAttribute("alist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판 목록</h3>
	controller에서 넘어온 데이터 : <%=request.getAttribute("data1") %>
	<br><br>
	<table border="1">
		<thead>
			<tr>
				<th>글제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(int i=0; i<alist.size(); i++){ 
					BoardVO vo = alist.get(i);
			%>
			<tr>
				<td><a href="view.do?bidx=<%=vo.getBidx()%>"><%=vo.getSubject() %></a></td>
				<td><%=vo.getWriter() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<button onclick="location.href='insert.do'">등록</button>
</body>
</html>