<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<form action="point_result.do" method="post">
		이름 : <input name="name"><br>
		국어 : <input name="kor"><br>
		영어 : <input name="eng"><br>
		수학 : <input name="mat"><br> 
		<button>전송</button>
	</form>
</body>
</html>