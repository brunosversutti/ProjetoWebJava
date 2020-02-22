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
 * Servlet implementation class Gravar
 */
@WebServlet("/AtualizarImovel")
public class Atualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(true);

		ImovelDTO imovelDTO = null;
		Vector<String> vectorErros = new Vector<String>();
        
		int idimovel = 0;
		String acao = request.getParameter("acao");
		String endereco = request.getParameter("endereco");
		String cep = request.getParameter("cep");
		String preco = request.getParameter("preco");
		String metragem = request.getParameter("metragem");
		String quadra = request.getParameter("quadra");
		String lote = request.getParameter("lote");
		String situacao = request.getParameter("situacao");
		

		String proximaPagina = "";
		switch(acao)
		{
		case "Alteracao": proximaPagina="/Imovel/Alterar.jsp"; break;
		case "Inclusao": proximaPagina="/Imovel/Inserir.jsp"; break;
		case "Exclusao": proximaPagina="/Imovel/Excluir.jsp"; break;
		}

		if(!acao.equals("Inclusao"))
			idimovel = Integer.parseInt(request.getParameter("idimovel"));

		if(!acao.equals("Exclusao"))
		{
			if(endereco == null || endereco.isEmpty())
				vectorErros.add("Endereço deve ser informado");

			if(cep == null || cep.isEmpty())
				vectorErros.add("CEP deve ser informado");
			
			if(preco == null || preco.isEmpty())
				vectorErros.add("Preço deve ser informado");
			
			if(metragem == null || metragem.isEmpty())
				vectorErros.add("Metragem deve ser informado");
			
			if(quadra == null || quadra.isEmpty())
				vectorErros.add("Quadra deve ser informado");
			
			if(lote == null || lote.isEmpty())
				vectorErros.add("Lote deve ser informado");
			
			if(situacao == null || situacao.isEmpty())
				vectorErros.add("Situação deve ser informado");
		}

		if(vectorErros.size() > 0)
		{
			String[] stringErros = (String[])vectorErros.toArray(new String[vectorErros.size()]);
			request.setAttribute("erros", stringErros);
			request.getRequestDispatcher(proximaPagina).forward(request, response);
		}
		else
		{
			imovelDTO = new ImovelDTO(idimovel, endereco,cep,preco, metragem, quadra, lote, situacao);
			ImovelDAO imovelDAO = new ImovelDAO();
			try{
				Boolean retornoAtualizacao = false;
				switch(acao)
				{
				case "Inclusao": retornoAtualizacao = imovelDAO.Incluir(imovelDTO); break;
				case "Alteracao": retornoAtualizacao = imovelDAO.Alterar(imovelDTO); break;
				case "Exclusao": retornoAtualizacao = imovelDAO.Excluir(idimovel); break;
				}

				if(retornoAtualizacao)
					response.sendRedirect("/PROJETOFINAL/ListarImovel");
			}
			catch(Exception e)
			{
				sessao.setAttribute("errMsg", e.getMessage());
				response.sendRedirect("/PROJETOFINAL/Util/PaginaDeErro.jsp");
			}
		}
	}

}
