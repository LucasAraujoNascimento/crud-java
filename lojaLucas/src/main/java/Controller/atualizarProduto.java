package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import Model.Produto;


@WebServlet("/atualizarProduto")
public class atualizarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
       
    public atualizarProduto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String marca = request.getParameter("marca");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		
		Produto produto = new Produto();
		produto.setId(id);
		produto.setMarca(marca);
		produto.setNome(nome);
		produto.setDescricao(descricao);
		
		
		try {
			dao.atualizar(produto, id);
			response.sendRedirect(request.getContextPath() + "/views/listar.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Erro ao atualizar o produto no banco de dados.");
		}
		
		
	}

}
