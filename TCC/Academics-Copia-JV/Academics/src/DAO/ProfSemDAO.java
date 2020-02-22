package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.PessoaDTO;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;
import DTO.SemestreDTO;


public class ProfSemDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";
	private String nomePessoa = "";
	List <ProfSemDTO> professoresSemestre = new ArrayList<ProfSemDTO>();
	
	
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

	public Boolean Incluir(ProfSemDTO profSemDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO PROFSEMESTRE(IDPROFESSOR, IDSEMESTRE)"
					+ " VALUES (?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, profSemDTO.getProfessor().getCodigo());
			pst.setLong(2, profSemDTO.getSemestre().getCodigo());
			return (pst.executeUpdate() > 0 ? true : false);
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	public Boolean Alterar(ProfSemDTO profSemDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE PROFSEMESTRE SET IDPROFESSOR=?,IDSEMESTRE=?"
					+ " WHERE IDPROFSEMESTRE = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, profSemDTO.getProfessor().getCodigo());
			pst.setLong(2, profSemDTO.getSemestre().getCodigo());
			pst.setLong(3, profSemDTO.getCodigo());
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

			comandoSql = "DELETE FROM PROFSEMESTRE WHERE IDPROFSEMESTRE = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	
	public List<ProfSemDTO> Listar() throws Exception {		
		ProfSemDTO profSemDTO;
		ProfessorDTO professorDTO;
		SemestreDTO semestreDTO;
		PessoaDTO pessoaDTO;
		List<ProfSemDTO> professoresSemestre = new ArrayList<ProfSemDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return professoresSemestre;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PESSOA, PROFESSOR, PROFSEMESTRE WHERE PESSOA.IDPESSOA = PROFESSOR.IDPESSOA AND PROFESSOR.IDPROFESSOR = PROFSEMESTRE.IDPROFESSOR ORDER BY PESSOA.NOME";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				profSemDTO = new ProfSemDTO();
				professorDTO = new ProfessorDTO();
				semestreDTO = new SemestreDTO();
				pessoaDTO = new PessoaDTO();
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				pessoaDTO.setNome(rs.getString("NOME"));
				
				professorDTO.setCodigo(rs.getLong("IDPROFESSOR"));
				professorDTO.setEspecialidade(rs.getString("ESPECIALIDADE"));
				semestreDTO.setCodigo(rs.getLong("IDSEMESTRE"));
				profSemDTO.setCodigo(rs.getLong("IDPROFSEMESTRE"));
				professorDTO.setPessoa(pessoaDTO);
				profSemDTO.setProfessor(professorDTO);
				profSemDTO.setSemestre(semestreDTO);
				professoresSemestre.add(profSemDTO);
				
				
			System.out.println(profSemDTO.getCodigo() + " " + profSemDTO.getProfessor().getCodigo() + 
				" " + profSemDTO.getSemestre().getCodigo());
				
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return professoresSemestre;
	}
	
	
	public ResultSet BuscaProfSemestre() throws Exception{
		
		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PROFSEMESTRE ORDER BY IDPROFESSOR ";
			
			System.out.println(comandoSql);
			rs = st.executeQuery(comandoSql);
			
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}
		finally{
			System.out.println("NAO ENCONTROU NENHUM DADO OU SEMESTRE");
		}

		return rs;
	}
	
	
	
}
