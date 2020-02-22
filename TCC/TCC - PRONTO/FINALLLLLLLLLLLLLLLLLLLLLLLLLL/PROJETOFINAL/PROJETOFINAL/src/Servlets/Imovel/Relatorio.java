package Servlets.Imovel;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.ImovelBusiness;

/**
 * Servlet implementation class ListarServlet
 */
@WebServlet("/RelatorioProdutos")
public class Relatorio extends HttpServlet {
	private ImovelBusiness imovelBusiness = new ImovelBusiness();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession(true);

		String produtoInicial = request.getParameter("produtoInicial"); 
		String produtoFinal = request.getParameter("produtoFinal");
		
		String filtro = "";
		filtro = "codigo between " + produtoInicial + " and " + produtoFinal; 
		
		try
		{
			ResultSet rsImovel = imovelBusiness.Relatorio(filtro);
			//sessao.setAttribute("listaProdutos", produtos);
			request.getRequestDispatcher("/Imovel/Relatorio.jsp").forward(request, response);
		
		}
		catch(Exception e)
		{
			sessao.setAttribute("errMsg", e.getMessage());
			response.sendRedirect("/PROJETOFINAL/Util/PaginaDeErro.jsp");
		}
		
	}

	
}
