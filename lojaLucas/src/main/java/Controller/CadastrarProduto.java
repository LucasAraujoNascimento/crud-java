package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import Model.Produto;


@WebServlet("/CadastrarProduto")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();

    public CadastrarProduto() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String marca = request.getParameter("marca");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		
		Produto produto = new Produto();
		produto.setMarca(marca);
		produto.setNome(nome);
		produto.setDescricao(descricao);

		try {
			dao.inserir(produto);
			response.sendRedirect(request.getContextPath() + "/views/listar.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Erro ao cadastrar o usuário no banco de dados.");
		}
	}

}
