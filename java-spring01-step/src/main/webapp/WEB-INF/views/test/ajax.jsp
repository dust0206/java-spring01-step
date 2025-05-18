<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="http://code.jquery.com/jquery-3.6.0.js"></script>
	<title>Insert title here</title>
<script>
	$(function() {
		$.ajax({
			type: "post",
			url : "background.do",
			success : function(dto) {
				$("#result").html("상품명:" + dto.name + "<br> 가격 : " + dto.price);
			}
		});
	});

</script>	
	</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<div id="result"></div>
	
</body>
</html>