package Servlets.Login;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.UsuarioBusiness;
import Dto.ParametrosDTO;
import Dto.UsuarioDTO;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
       
    
    public Login() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ParametrosDTO.setParametros(config);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		HttpSession sessao = request.getSession(true);

		try
		{
			UsuarioDTO usuarioDTO = usuarioBusiness.Login(login, senha);
			
			/* TESTE
			UsuarioDTO usuarioDTO = new UsuarioDTO(1,"NOME1","LOGIN1","SENHA1");
			*/
			
			if(usuarioDTO != null)
			{
				sessao.setMaxInactiveInterval(600);
				sessao.setAttribute("usuarioLogado", usuarioDTO);
				request.getRequestDispatcher("Menu/MenuInicial.jsp").forward(request, response);
			}
			else
			{
				sessao.setAttribute("loginOk", false);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			sessao.setAttribute("errMsg", e.getMessage());
			response.sendRedirect("/PROJETOFINAL/Util/PaginaDeErro.jsp");
		}
	}

}
