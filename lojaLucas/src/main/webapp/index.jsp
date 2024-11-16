<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Página Inicial</title>
</head>
<body>
	<%@ include file="/includes/menu.jsp" %>
	<%
	response.sendRedirect(request.getContextPath() + "/views/listar.jsp");
	%>
	<%@ include file="/includes/footer.jsp" %>
</body>
</html>