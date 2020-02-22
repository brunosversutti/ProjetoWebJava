package Servlets.Atualizar;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BUS.CidadeBUS;
import DTO.CidadeDTO;

/**
 * Servlet implementation class AtualizaCidades
 */
@WebServlet("/AtualizaCidades")
public class AtualizaCidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizaCidades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("CHAMOU METODO SERVICE");
		
		HttpSession sessao = request.getSession(true);
		CidadeDTO cidadeDTO = null;
		Vector<String> vectorErros = new Vector<String>();
		
		
		long codigo = Long.parseLong(request.getParameter("codigo"));
		String acao = request.getParameter("acao");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		
		
		
		
		String proximaPagina = "";
		switch(acao)
		{
		case "Alterar": proximaPagina="/cidades/alterar.jsp"; break;
		case "Excluir": proximaPagina="/cidades/excluir.jsp"; break;
		}

		if(!acao.equals("Excluir"))
		{
			if(cidade == null || cidade.isEmpty())
				vectorErros.add("Nome deve ser informado");

			if(uf == null || uf.isEmpty())
				vectorErros.add("UF deve ser informada");
		}

		if(vectorErros.size() > 0)
		{
			String[] stringErros = (String[])vectorErros.toArray(new String[vectorErros.size()]);
			request.setAttribute("erros", stringErros);
			request.getRequestDispatcher(proximaPagina).forward(request, response);
		}
		else
		{
			cidadeDTO = new CidadeDTO(codigo, cidade,uf);
			CidadeBUS cidadeBUS = new CidadeBUS();
			try{
				Boolean retornoAtualizacao = false;
				switch(acao)
				{
				case "Alterar": retornoAtualizacao = cidadeBUS.Alterar(cidadeDTO); break;
				case "Excluir": retornoAtualizacao = cidadeBUS.Excluir(codigo); break;
				}

				if(retornoAtualizacao)
					System.out.println("ALTERACAO");
					response.sendRedirect("/Academics/cidades/lista.jsp");
			}
			catch(Exception e)
			{
				sessao.setAttribute("errMsg", e.getMessage());
				response.sendRedirect("/Academics/Util/PaginaDeErro.jsp");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CHAMOU METODO GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CHAMOU METODO POST");
	}

}
