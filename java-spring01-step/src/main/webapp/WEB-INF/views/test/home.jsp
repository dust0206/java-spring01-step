<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<%-- <P>  The time on the server is <fmt:formatDate value="${serverTime}" pattern="yyyy-MM-dd"  ></fmt:formatDate> </P> --%>
<P>  The time on the server is ${serverTime}</P>
</body>
</html>
