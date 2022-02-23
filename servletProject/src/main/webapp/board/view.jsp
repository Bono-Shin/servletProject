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
<script>
	function delfn(){
		var form = document.getElementsByTagName("form")[0];
		form.setAttribute("action","delete.do");
		form.submit();
	}
</script>
</head>
<body>
	<h2>상세페이지</h2>
		<table border="1">
			<thead>
				<tr>
					<th>제목</th>
					<th><%=vo.getSubject() %></th>
					<th>작성자</th>
					<th><%=vo.getWriter() %></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>내용</th>
					<td colspan="3"><%=vo.getContent() %></td>
				</tr>
			</tbody>
		</table>
	<button onclick="modifyOK()">수정</button>
	<button onclick="delfn()">삭제</button>
	<form method="post">
		<input type="hidden" name="bidx" value="<%=vo.getBidx()%>">
	</form>
	<script>
		function modifyOK(){
			location.href="viewModify.do?bidx=<%=vo.getBidx()%>";
		}
	</script>
</body>
</html>