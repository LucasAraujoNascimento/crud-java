<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.DAO" %>
<%@ page import="Model.Produto" %>


<%


    DAO dao = new DAO();
    List<Produto> listaProdutos = dao.listar();
    Produto produto = new Produto();
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Listar</title>
</head>
<body>
	<%@ include file="../includes/menu.jsp" %>
	<h2>Lista Produtos</h2>
    <table border="1" cellspacing="0" cellpadding="5">
        <thead>
            <tr>
                <th>ID</th>
                <th>Marca</th>
                <th>Nome</th>
                <th>Descrição</th>
            </tr>
        </thead>

        <tbody>
		     <% 
                for (Produto produtos : listaProdutos) {
            %>
            <tr>
                <td><c:out value="<%=produtos.getId()%>" /></td>
                <td><c:out value="<%=produtos.getMarca()%>" /></td>
                <td><c:out value="<%=produtos.getNome()%>" /></td>
                <td><c:out value="<%=produtos.getDescricao()%>" /></td>
                <td><a href="atualizar.jsp?id=<%= produtos.getId() %>">Editar</a></td>
                <td><a href="${pageContext.request.contextPath}/deleteProduto?id=<%= produtos.getId() %>">Excluir</a></td>

            </tr>
                    <% 
                } 
            %>
          </tbody>
    </table>
    <br>
    <a href="cadastrar.jsp">Novo Cliente</a>
    <br>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>