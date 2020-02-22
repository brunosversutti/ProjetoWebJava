package Servlets.Usuario;

import java.io.IOException;
import java.util.Vector;

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


@WebServlet("/Registrar")
public class Registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ParametrosDTO.setParametros(config);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessao = request.getSession(true);

		UsuarioDTO usuarioDTO = null;

		Vector<String> vectorErros = new Vector<String>();

		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String datanascimento = request.getParameter("datanascimento");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
	

		if(nome == null || nome.isEmpty())
			vectorErros.add("Nome deve ser informado");
		
		if(login == null || login.isEmpty())
			vectorErros.add("Login deve ser informado");
		

		if(senha == null || senha.isEmpty())
			vectorErros.add("Senha deve ser informada");
		
		
		if(cpf == null || cpf.isEmpty())
			vectorErros.add("CPF deve ser informado");

		if(telefone == null || telefone.isEmpty())
			vectorErros.add("Telefone deve ser informado");
		

		if(datanascimento == null || datanascimento .isEmpty())
			vectorErros.add("Data de Nascimento deve ser informado");
		
		
		if(endereco == null || endereco.isEmpty())
			vectorErros.add("Endereço deve ser informado");
		
		
		if(email == null || email.isEmpty())
			vectorErros.add("Email deve ser informado");
	



		if(vectorErros.size() > 0)
		{
			String[] stringErros = (String[])vectorErros.toArray(new String[vectorErros.size()]);
			request.setAttribute("erros", stringErros);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else
		{
			usuarioDTO = new UsuarioDTO(nome,login,senha,cpf,telefone,datanascimento,endereco,email);
			UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
			try{
				if(usuarioBusiness.Incluir(usuarioDTO))
				{
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

}
