package Servlets;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.util.resources.LocaleData;
import BUS.AlunoBUS;
import BUS.CidadeBUS;
import BUS.EnderecoBUS;
import BUS.PessoaBUS;
import DAO.PessoaDAO;
import DTO.AlunoDTO;
import DTO.CidadeDTO;
import DTO.CursoDTO;
import DTO.EnderecoDTO;
import DTO.PessoaDTO;

/**
 * Servlet implementation class ServletAluno
 */
@WebServlet("/ServletAluno")
public class ServletAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String nome, nascimento, rg, cpf, telefone, logradouro, numero, complemento, bairro, cidade, estado, cep, ra, login, senha, curso;
	private CidadeDTO cidadeDTO;
	private PessoaDTO pessoaDTO;
	private AlunoDTO alunoDTO;
	private EnderecoDTO enderecoDTO;
	private PessoaDAO pessoaDAO;
	private CursoDTO cursoDTO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		curso = request.getParameter("cursos");
		ra = request.getParameter("ra");
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

		
		//ALIMENTANDO O OBJETO CURSO
		cursoDTO = new CursoDTO();
		cursoDTO.setCodigo(Integer.parseInt(curso));
		
		//ALIMENTANDO O OBJETO ALUNO
		
		alunoDTO = new AlunoDTO();
		alunoDTO.setrA(Integer.parseInt(ra));
		alunoDTO.setCurso(cursoDTO);
		alunoDTO.setSituacao(1);
		
		System.out.println("SERVLET " + alunoDTO.getrA() + alunoDTO.getCurso().getCodigo() + alunoDTO.getSituacao());

	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("METODO GET");


		//this.doPost(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("chamou metodo do post");
		this.recebeValores(request);


		CidadeBUS cidadeBUS = new CidadeBUS();
		PessoaBUS pessoaBUS  = new PessoaBUS();
		EnderecoBUS enderecoBUS = new EnderecoBUS();
		AlunoBUS alunoBUS = new AlunoBUS();
		
		/**
		try{
			cidadeBUS.Incluir(cidade, estado);
			ResultSet rs = cidadeBUS.BuscarCidade(cidade, estado);
			while(rs.next()){	
				cidadeDTO.setCodigo(rs.getLong("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));
				pessoaDTO.setCidade(cidadeDTO);
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		*/
		
		try{
			
			ResultSet rs = cidadeBUS.BuscarCidade(cidade);
			while(rs.next()){	
				cidadeDTO.setCodigo(rs.getLong("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));
				pessoaDTO.setCidade(cidadeDTO);
				
				System.out.println("RS-CIDADES-SERVLET " + cidadeDTO.getCodigo() + cidadeDTO.getCidade());
			}
			
		}catch (Exception e){
			
			System.out.println("CIDADE NAO ENCONTRADA " + e.getMessage());
		}
		
		
		
		try{
			
			pessoaDTO.setCidade(cidadeDTO);
			pessoaBUS.Incluir(pessoaDTO, cidadeDTO);

			enderecoDTO.setCidade(cidadeDTO);
			enderecoDTO.setPessoa(pessoaDTO);
			enderecoBUS.Incluir(enderecoDTO);
			
			alunoDTO.setPessoa(pessoaDTO);
			alunoDTO.setCurso(cursoDTO);

			//enderecoBUS.Incluir(enderecoDTO);
			alunoBUS.Incluir(alunoDTO);

		}catch(Exception e){
			System.out.println(e.getMessage());

		}

		
	}

}