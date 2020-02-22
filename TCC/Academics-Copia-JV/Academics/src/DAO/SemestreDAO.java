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
import DTO.SemestreDTO;

public class SemestreDAO {

	
	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";
	List <SemestreDTO> semestres = new ArrayList<SemestreDTO>();
	
	
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
	
	public Boolean Incluir(SemestreDTO semestreDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO SEMESTRE(ANO, PERIODO, STATUS)"
					+ " VALUES (?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, semestreDTO.getAno());
			pst.setString(2, semestreDTO.getPeriodo());
			pst.setString(3, semestreDTO.getStatus());
			return (pst.executeUpdate() > 0 ? true : false);
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public Boolean Alterar(SemestreDTO semestreDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE SEMESTRE SET ANO=?,PERIODO=?, STATUS=?"
					+ " WHERE IDSEMESTRE=?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			
			pst.setInt(1, semestreDTO.getAno());
			pst.setString(2, semestreDTO.getPeriodo());
			pst.setString(3, semestreDTO.getStatus());
			pst.setLong(4, semestreDTO.getCodigo());
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

			comandoSql = "DELETE FROM SEMESTRE WHERE IDSEMESTRE = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	public List<SemestreDTO> Listar() throws Exception {
		SemestreDTO semestreDTO;
		List<SemestreDTO> semestres = new ArrayList<SemestreDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return semestres;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM SEMESTRE ORDER BY ANO,PERIODO";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				semestreDTO = new SemestreDTO();
				
				semestreDTO.setCodigo(rs.getLong("IDSEMESTRE"));
				semestreDTO.setAno(rs.getInt("ANO"));
				semestreDTO.setPeriodo(rs.getString("PERIODO"));
				semestreDTO.setStatus(rs.getString("STATUS"));
				

				semestres.add(semestreDTO);
				System.out.println(semestreDTO.getAno() + " " + semestreDTO.getPeriodo() + " " + semestreDTO.getStatus());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return semestres;
	}
	
	public ResultSet BuscarSemestre(SemestreDTO semestreDTO) throws Exception{
		
		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM SEMESTRE WHERE ANO = " + "'"+semestreDTO.getAno()+"'" + " AND PERIODO = "+"'"+semestreDTO.getPeriodo()+"'";
			
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
	
	
	public ResultSet ListaSemestre() throws Exception{
		
		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM SEMESTRE ";
			
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
	
	
	public List<SemestreDTO> ListaAlunoSemestre(PessoaDTO pessoaDTO) throws Exception {
		SemestreDTO semestreDTO;
		
		List<SemestreDTO> semestres = new ArrayList<SemestreDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return semestres;

			Statement st = (Statement)conexao.createStatement();
			//comandoSql =  "SELECT * FROM SEMESTRE ORDER BY ANO,PERIODO";
			comandoSql =  "SELECT * FROM PESSOA, ALUNO, ALUNOSEM, SEMESTRE"
			+ "WHERE PESSOA.IDPESSOA = ALUNO.IDPESSOA"
			+ "AND ALUNO.IDALUNO = ALUNOSEM.IDALUNO"
			+ "AND ALUNOSEM.IDSEMESTRE = SEMESTRE.IDSEMESTRE"
			+ "AND PESSOA.IDPESSOA =" + "'"+pessoaDTO.getCodigo()+ "'";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				semestreDTO = new SemestreDTO();
				
				semestreDTO.setCodigo(rs.getLong("IDSEMESTRE"));
				semestreDTO.setAno(rs.getInt("ANO"));
				semestreDTO.setPeriodo(rs.getString("PERIODO"));
				semestreDTO.setStatus(rs.getString("STATUS"));
				

				semestres.add(semestreDTO);
				System.out.println(semestreDTO.getAno() + " " + semestreDTO.getPeriodo() + " " + semestreDTO.getStatus());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return semestres;
	}
	
	
	
	

}
