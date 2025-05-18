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
		$("#login_btn").click(function() {
			let id = $("#id").val();
			let pw = $("#pw").val();
			param = { "id":id, "pw":pw};
			$.ajax({
				type: "post",
				url: "login_result.do",
				data: param,
				success: function(result) {
					$("#result").html(result);
				}
			});
		});
	});

</script>	
	</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<form method="post" id="formid">
		아이디 : <input name="id" id="id"><br>
		패스워드 : <input type="password" name="pw" id="pw"><br>
		<button type="button" id="login_btn">로그인</button>
	</form>
		<div id="result"></div>
</body>
</html>