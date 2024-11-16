<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Cadastrar Produto</title>
</head>
<body>
	<%@ include file="../includes/menu.jsp" %>
	
	<h2>Cadastrar Produto</h2>
	
	
	<form action="${pageContext.request.contextPath}/CadastrarProduto" method="post">

        <label for="marca">Marca: </label>
        <input type="text" name="marca">
        <br>
        <br>
        <label for="nome">Nome: </label>
        <input type="text" name="nome">
        <br>
        <br>
        <label for="descricao">Descrição: </label>
        <input type="text" name="descricao">
        <br>
        <br>
        <input type="submit" value="Cadastrar">
        <input type="button" value="Cancelar" onclick="window.location.href='listar.jsp';"/>

    </form>
    
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>