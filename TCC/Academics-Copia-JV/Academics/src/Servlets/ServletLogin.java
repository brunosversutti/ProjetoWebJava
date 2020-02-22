package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import BUS.PessoaBUS;
import DAO.PessoaDAO;
import DTO.ParametrosDTO;
import DTO.PessoaDTO;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PessoaDTO pessoaDTO = new PessoaDTO();
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private PessoaBUS pessoaBUS = new PessoaBUS();
	
	
	


	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ParametrosDTO.setParametros(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String loginUsuario = request.getParameter("usuario");
		String senhaUsuario = request.getParameter("senha");
		HttpSession sessao = request.getSession(true);

		try{

			pessoaDTO = pessoaBUS.Login(loginUsuario, senhaUsuario);

			if(loginUsuario.equals("admin")&& senhaUsuario.equals("admin")){

				sessao.setAttribute("usuario", loginUsuario);
				sessao.setMaxInactiveInterval(600);
				sessao.setAttribute("usuarioLogado", pessoaDTO);
				request.getRequestDispatcher("/gerenciador/menu.jsp").forward(request, response);
				
			}
			else if(!pessoaDTO.getLogin().equals(loginUsuario) || !pessoaDTO.getSenha().equals(senhaUsuario)){

				sessao.setAttribute("loginOk", false);
				response.sendRedirect("/Academics/Util/PaginaDeErro.jsp");

			}
			else if(pessoaDTO.getLogin().equals(loginUsuario) || pessoaDTO.getSenha().equals(senhaUsuario)){

				sessao.setAttribute("usuario", loginUsuario);
				sessao.setMaxInactiveInterval(600);
				sessao.setAttribute("usuarioLogado", pessoaDTO);

				if(pessoaDTO.getNivel() == 1){
					
					sessao.setAttribute("usuario", loginUsuario);
					sessao.setMaxInactiveInterval(600);
					sessao.setAttribute("usuarioLogado", pessoaDTO);
					
					request.getRequestDispatcher("/gerenciador/menu.jsp").forward(request, response);

				}
				else if(pessoaDTO.getNivel() == 2){
					
					sessao.setAttribute("usuario", loginUsuario);
					sessao.setMaxInactiveInterval(600);
					sessao.setAttribute("usuarioLogado", pessoaDTO);

					request.getRequestDispatcher("/professor/menu.jsp").forward(request, response);
				}
				else if(pessoaDTO.getNivel() == 3){
					
					sessao.setAttribute("usuario", loginUsuario);
					sessao.setMaxInactiveInterval(600);
					sessao.setAttribute("usuarioLogado", pessoaDTO);

					request.getRequestDispatcher("/aluno/menu.jsp").forward(request, response);
				}


			}


		}
		catch(Exception e){

			sessao.setAttribute("errMsg", e.getMessage());
			response.sendRedirect("/Academics/Util/PaginaDeErro.jsp");
		}


	}

	public void sendPageErro(HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Página de Login</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("Usuário ou senha incorretos");
		writer.println("</body>");
		writer.println("</html>");
	}
	public void sendWelcome(HttpServletResponse response, HttpServletRequest request) throws IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Dados do usuário</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("Nome do usuário: " + request.getSession().getAttribute("usuário") + "<br/>");
		writer.println("Id da sessão: " + request.getSession().getId() + "<br/>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
