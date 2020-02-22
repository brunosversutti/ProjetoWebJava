package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.AdministradorDTO;
import DTO.PessoaDTO;
import DTO.ProfessorDTO;


public class ProfessorDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";
	private String nomePessoa = "";
	List <ProfessorDTO> professores = new ArrayList<ProfessorDTO>();
	
	
	public Boolean VerifiqueConexao() throws Exception {
		try
		{
			conexao = DBConexao.Conectar();
			if(conexao == null)
				return false;
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return true;
	}
	
	public Boolean Incluir(ProfessorDTO professorDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO PROFESSOR(IDPESSOA, TITULO, ESPECIALIDADE)"
					+ " VALUES (?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, professorDTO.getPessoa().getCodigo());
			pst.setString(2, professorDTO.getTitulo());
			pst.setString(3, professorDTO.getEspecialidade());
			return (pst.executeUpdate() > 0 ? true : false);
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public Boolean Alterar(ProfessorDTO professorDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE PROFESSOR SET IDPESSOA=?,TITULO=?,ESPECIALIDADE=?"
					+ " WHERE IDPROFESSOR = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, professorDTO.getPessoa().getCodigo());
			pst.setString(2, professorDTO.getTitulo());
			pst.setString(3, professorDTO.getEspecialidade());
			pst.setLong(4, professorDTO.getCodigo());
			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	public Boolean Excluir(int codigo) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "DELETE FROM PROFESSOR WHERE IDPROFESSOR = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public List<ProfessorDTO> Listar() throws Exception {
		ProfessorDTO professorDTO;
		PessoaDTO pessoaDTO;
		List<ProfessorDTO> professores = new ArrayList<ProfessorDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return professores;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE,PESSOA,PROFESSOR WHERE PESSOA.IDCIDADE = CIDADE.IDCIDADE AND PESSOA.IDPESSOA = PROFESSOR.IDPESSOA ORDER BY PESSOA.NOME";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				professorDTO = new ProfessorDTO();
				pessoaDTO = new PessoaDTO();
				professorDTO.setCodigo(rs.getLong("IDPROFESSOR"));
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				pessoaDTO.setNome(rs.getString("NOME"));
				professorDTO.setTitulo(rs.getString("TITULO"));
				professorDTO.setEspecialidade(rs.getString("ESPECIALIDADE"));
				professorDTO.setPessoa(pessoaDTO);
				professores.add(professorDTO);
				
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return professores;
	}
	
	
	public List<ProfessorDTO> Listar(PessoaDTO pessoaDTO) throws Exception {
		ProfessorDTO professorDTO;
		//PessoaDTO pessoaDTO;
		List<ProfessorDTO> professores = new ArrayList<ProfessorDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return professores;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE,PESSOA,PROFESSOR WHERE PESSOA.IDCIDADE = CIDADE.IDCIDADE AND PESSOA.IDPESSOA = PROFESSOR.IDPESSOA ORDER BY PESSOA.NOME";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				professorDTO = new ProfessorDTO();
				pessoaDTO = new PessoaDTO();
				professorDTO.setCodigo(rs.getLong("IDPROFESSOR"));
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				pessoaDTO.setNome(rs.getString("NOME"));
				professorDTO.setTitulo(rs.getString("TITULO"));
				professorDTO.setEspecialidade(rs.getString("ESPECIALIDADE"));
				professorDTO.setPessoa(pessoaDTO);
				professores.add(professorDTO);
				
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return professores;
	}
	
	
	
	
	
	public List<ProfessorDTO> Pesquisar(String NomePessoa) throws Exception {
		PessoaDTO pessoaDTO;
		ProfessorDTO professorDTO;
		List<ProfessorDTO> professores = new ArrayList<ProfessorDTO>();

		nomePessoa = NomePessoa;
		//CidadeDTO cidadeDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return professores;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PESSOA,PROFESSOR WHERE PESSOA.NOME LIKE " +"'%"+nomePessoa+"%'";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				pessoaDTO = new PessoaDTO();
				professorDTO = new ProfessorDTO();
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				pessoaDTO.setNome(rs.getString("NOME"));
				professorDTO.setTitulo(rs.getString("TITULO"));
				professorDTO.setEspecialidade(rs.getString("ESPECIALIDADE"));
				professores.add(professorDTO);
				
				System.out.println(pessoaDTO.getCodigo() + " " +pessoaDTO.getNome() + " "
				+ professorDTO.getTitulo()+ " " + professorDTO.getEspecialidade());
			}
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return professores;
	}
	
	
public ResultSet BuscarPessoaProfessor() throws Exception, SQLException {
		
		try
		{
			if(!VerifiqueConexao())
				return null;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE,PESSOA,PROFESSOR WHERE PESSOA.IDCIDADE = CIDADE.IDCIDADE AND PESSOA.IDPESSOA = PROFESSOR.IDPESSOA ORDER BY PESSOA.NOME";
			
			rs = st.executeQuery(comandoSql);
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return rs;
	}

	
	
	
	
}
