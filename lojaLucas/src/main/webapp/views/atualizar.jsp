<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.DAO" %>
<%@ page import="Model.Produto" %>


<%

	DAO dao = new DAO();
	Produto produto = new Produto();
	int id = Integer.parseInt(request.getParameter("id"));
	produto = dao.listaUm(id);
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Cadastrar Produto</title>
</head>
<body>
	<%@ include file="../includes/menu.jsp" %>
	
	<h2>Atualizar Produto</h2>
	
	
	<form action="${pageContext.request.contextPath}/atualizarProduto" method="post">

        <input type="hidden" name="id" value="<%=produto.getId()%>">
        <label for="marca">Marca: </label>
        <input type="text" name="marca" value="<%=produto.getMarca()%>">
        <br>
        <br>
        <label for="nome">Nome: </label>
        <input type="text" name="nome" value="<%=produto.getNome()%>">
        <br>
        <br>
        <label for="descricao">Descrição: </label>
        <input type="text" name="descricao" value="<%=produto.getDescricao()%>">
        <br>
        <br>
        <input type="submit" value="Atualizar">
        <input type="button" value="Cancelar" onclick="window.location.href='listar.jsp';"/>

    </form>
    
    
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>