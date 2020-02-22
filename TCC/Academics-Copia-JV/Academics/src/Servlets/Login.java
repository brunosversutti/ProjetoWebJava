package Servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BUS.PessoaBUS;
import DTO.ParametrosDTO;
import DTO.PessoaDTO;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PessoaBUS pessoaBUS = new PessoaBUS();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ParametrosDTO.setParametros(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		

		HttpSession sessao = request.getSession(true);

		try{

			PessoaDTO pessoaDTO = pessoaBUS.Login(usuario, senha);
			if(pessoaDTO != null){

				sessao.setMaxInactiveInterval(600);
				sessao.setAttribute("usuarioLogado", pessoaDTO);
				request.getRequestDispatcher("/Admin/Index.jsp").forward(request, response);
			}
			else
			{
				sessao.setAttribute("loginOk", false);
				request.getRequestDispatcher("/Login/Login.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			sessao.setAttribute("errMsg", e.getMessage());
			response.sendRedirect("/Academics/Util/PaginaDeErro.jsp");
		}
	}

}
