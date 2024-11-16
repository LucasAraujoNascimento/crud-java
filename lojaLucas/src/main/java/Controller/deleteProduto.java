package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;


@WebServlet("/deleteProduto")
public class deleteProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();

    public deleteProduto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			dao.delete(id);
			response.sendRedirect(request.getContextPath() + "/views/listar.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Erro ao excluir o produto no banco de dados.");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
