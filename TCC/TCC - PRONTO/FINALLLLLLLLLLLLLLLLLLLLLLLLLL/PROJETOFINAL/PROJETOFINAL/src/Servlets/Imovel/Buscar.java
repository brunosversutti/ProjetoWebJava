package Servlets.Imovel;

import java.io.IOException;
import java.util.Vector;

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
 * Servlet implementation class Buscar
 */
@WebServlet("/BuscarImovel")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(true);

		String acao = request.getParameter("acao");
		String idimovel = request.getParameter("idimovel");
		ImovelDAO imovelDAO = new ImovelDAO();

		try{
			ImovelDTO imovelDTO = imovelDAO.BuscaRegistro(Integer.parseInt(idimovel));
			request.setAttribute("imovelDTO", imovelDTO);
			if(acao.equals("Alterar"))
				request.getRequestDispatcher("/Imovel/Alterar.jsp").forward(request, response);
			else
				request.getRequestDispatcher("/Imovel/Excluir.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			sessao.setAttribute("errMsg", e.getMessage());
			response.sendRedirect("/PROJETOFINAL/Util/PaginaDeErro.jsp");
		}
	}

}
