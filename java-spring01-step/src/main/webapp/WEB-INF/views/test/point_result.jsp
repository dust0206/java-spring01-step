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
	이름 : ${dto.name }<br>
	국어 : ${dto.kor }<br>
	영어 : ${dto.eng }<br>
	수학 : ${dto.mat }<br>
	총점 : ${dto.total }<br>
	평균 : ${dto.average }<br> 
</body>
</html>