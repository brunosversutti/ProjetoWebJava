package Servlets.Imovel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.ImovelBusiness;
import Dao.ImovelDAO;
import Dto.ImovelDTO;

/**
 * Servlet implementation class ListarServlet
 */
@WebServlet("/ListarImovel")
public class Listar extends HttpServlet {
	private ImovelDAO imovelDAO = new ImovelDAO();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(true);
		
		try
		{
			List<ImovelDTO> imoveis = imovelDAO.Listar();
			sessao.setAttribute("listaImovel", imoveis);
			request.getRequestDispatcher("/Imovel/IndexImovel.jsp").forward(request, response);
		
		}
		catch(Exception e)
		{
			sessao.setAttribute("errMsg", e.getMessage());
			response.sendRedirect("/PROJETOFINAL/Util/PaginaDeErro.jsp");
		}
		
	}

	
}
