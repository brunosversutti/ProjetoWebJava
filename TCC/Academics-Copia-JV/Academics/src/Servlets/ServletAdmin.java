package Servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUS.AdministradorBUS;
import BUS.CidadeBUS;
import BUS.EnderecoBUS;
import BUS.PessoaBUS;
import DAO.PessoaDAO;
import DTO.AlunoDTO;
import DTO.CidadeDTO;
import DTO.CursoDTO;
import DTO.EnderecoDTO;
import DTO.PessoaDTO;
import DTO.AdministradorDTO;



/**
 * Servlet implementation class Administrador
 */
@WebServlet("/Administrador")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private PessoaDTO pessoaDTO;
	private AdministradorDTO administradorDTO;
	private CidadeDTO cidadeDTO;
	private EnderecoDTO enderecoDTO;
	private PessoaDAO pessoaDAO;
	private String nome, nascimento, rg, cpf, telefone, logradouro, numero, complemento, bairro, cidade, estado, cep, cargo , login, senha, curso;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void recebeValores(HttpServletRequest request){

		//RECEBE OS VALORES DOS CAMPOS DO FORMULARIO ATRAVES DO REQUEST

		nome = request.getParameter("nome");
		nascimento = request.getParameter("nascimento");
		cpf = request.getParameter("cpf");
		rg = request.getParameter("rg");
		telefone = request.getParameter("telefone");
		logradouro = request.getParameter("logradouro");
		numero = request.getParameter("numero");
		complemento = request.getParameter("complemento");
		bairro = request.getParameter("bairro");
		cidade = request.getParameter("cidade");
		estado = request.getParameter("uf");
		cep = request.getParameter("cep");
		cargo = request.getParameter("cargo");
		login = request.getParameter("login");
		senha = request.getParameter("senha");

		System.out.println("recuperou o " + curso);
		
		
		//ALIMENTANDO O OBJETO CIDADE

		cidadeDTO = new CidadeDTO();
		cidadeDTO.setCidade(cidade);
		cidadeDTO.setUf(estado);


		//ALIMENTANDO O OBJETO PESSOA
		pessoaDTO = new PessoaDTO();
		pessoaDTO.setCidade(cidadeDTO);
		pessoaDTO.setNome(nome);
		pessoaDTO.setNascimento(nascimento);
		pessoaDTO.setTelefone(telefone);
		pessoaDTO.setLogin(login);
		pessoaDTO.setSenha(senha);
		pessoaDTO.setRg(rg);
		pessoaDTO.setCpf(cpf);
		pessoaDTO.setNivel(3);



		//ALIMENTANDO O OJETO ENDERECO

		enderecoDTO = new EnderecoDTO();
		enderecoDTO.setLogradouro(logradouro);
		enderecoDTO.setNumero(Integer.parseInt(numero));
		enderecoDTO.setComplemento(complemento);
		enderecoDTO.setBairro(bairro);
		enderecoDTO.setCep(Integer.parseInt(cep));
		enderecoDTO.setCidade(cidadeDTO);
		enderecoDTO.setPessoa(pessoaDTO);
		
		
		//ALIMENTANDO O OBJETO ADMINISTRADOR
		
		administradorDTO = new AdministradorDTO();
		administradorDTO.setCargo(cargo);
		administradorDTO.setPessoa(pessoaDTO);
		administradorDTO.setCidade(cidadeDTO);
		

		
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
		
		this.recebeValores(request);
		
		CidadeBUS cidadeBUS = new CidadeBUS();
		PessoaBUS pessoaBUS  = new PessoaBUS();
		EnderecoBUS enderecoBUS = new EnderecoBUS();
		AdministradorBUS administradorBUS = new AdministradorBUS();
		
		
		try{
			
			ResultSet rs = cidadeBUS.BuscarCidade(cidade);
			while(rs.next()){	
				cidadeDTO.setCodigo(rs.getLong("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));
				pessoaDTO.setCidade(cidadeDTO);
				
			}
			
		}catch (Exception e){
			
			System.out.println(e.getMessage());
		}
		
		
		try{
			
			pessoaDTO.setCidade(cidadeDTO);
			enderecoDTO.setCidade(cidadeDTO);
			enderecoDTO.setPessoa(pessoaDTO);
			administradorDTO.setPessoa(pessoaDTO);
			
			pessoaBUS.Incluir(pessoaDTO, cidadeDTO);
			
			enderecoBUS.Incluir(enderecoDTO);
			
			administradorBUS.Incluir(administradorDTO);
			
			
		}catch (Exception e){
			
			System.out.println(e.getMessage());
		}
		
	}

}
