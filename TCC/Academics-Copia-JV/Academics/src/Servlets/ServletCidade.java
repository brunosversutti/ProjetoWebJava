package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BUS.CidadeBUS;

/**
 * Servlet implementation class ServletCidade
 */
@WebServlet("/ServletCidade")
public class ServletCidade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nomeCidade, nomeUF, acao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCidade() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void RecebeValores(HttpServletRequest request){
    	
    	nomeCidade = (request.getParameter("cidade").toUpperCase());
    	nomeUF = (request.getParameter("uf").toUpperCase());
    	
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao = request.getSession(true);
		this.RecebeValores(request);
		
		CidadeBUS cidBUS = new CidadeBUS();
		
		try{
			cidBUS.Incluir(nomeCidade, nomeUF);
			sessao.setAttribute("novaCidade", nomeCidade);
			//response.sendRedirect("/Academics/cidades/confirmacao.jsp");
			request.getRequestDispatcher("/cidades/confirmacao.jsp").forward(request, response);
		}
		catch (Exception e){
			response.sendRedirect("/Academics/cidades/confirmacao.jsp");
		}
		
	}

}
