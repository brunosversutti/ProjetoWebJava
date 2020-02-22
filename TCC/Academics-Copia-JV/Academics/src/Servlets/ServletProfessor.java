package Servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUS.CidadeBUS;
import BUS.EnderecoBUS;
import BUS.PessoaBUS;
import BUS.ProfessorBUS;
import DTO.AdministradorDTO;
import DTO.CidadeDTO;
import DTO.EnderecoDTO;
import DTO.PessoaDTO;
import DTO.ProfessorDTO;

/**
 * Servlet implementation class ServletProfessor
 */
@WebServlet("/ServletProfessor")
public class ServletProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String nome, nascimento, rg, cpf, telefone, logradouro, numero, complemento, bairro, cidade, estado, cep, titulo, especialidade, login, senha;
	private CidadeDTO cidadeDTO;
	private PessoaDTO pessoaDTO;
	private EnderecoDTO enderecoDTO;
	private ProfessorDTO professorDTO;

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfessor() {
        super();
        // TODO Auto-generated constructor stub
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
		titulo = request.getParameter("titulo");
		especialidade = request.getParameter("especialidade");
		login = request.getParameter("login");
		senha = request.getParameter("senha");

		
		
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
		pessoaDTO.setNivel(2);



		//ALIMENTANDO O OJETO ENDERECO

		enderecoDTO = new EnderecoDTO();
		enderecoDTO.setLogradouro(logradouro);
		enderecoDTO.setNumero(Integer.parseInt(numero));
		enderecoDTO.setComplemento(complemento);
		enderecoDTO.setBairro(bairro);
		enderecoDTO.setCep(Integer.parseInt(cep));
		enderecoDTO.setCidade(cidadeDTO);
		enderecoDTO.setPessoa(pessoaDTO);
		
		
		//ALIMENTANDO O OBJETO PROFESSOR
		
		professorDTO = new ProfessorDTO();
		professorDTO.setTitulo(titulo);
		professorDTO.setEspecialidade(especialidade);
		professorDTO.setPessoa(pessoaDTO);
	
		
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
		ProfessorBUS professorBUS = new ProfessorBUS();
		
		
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
			professorDTO.setPessoa(pessoaDTO);
			
			pessoaBUS.Incluir(pessoaDTO, cidadeDTO);
			
			enderecoBUS.Incluir(enderecoDTO);
			
			professorBUS.Incluir(professorDTO);
			
			
		}catch (Exception e){
			
			System.out.println(e.getMessage());
		}
		
	}
		


}
