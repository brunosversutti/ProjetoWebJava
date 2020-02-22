package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.AlunoDTO;
import DTO.AlunoSemDTO;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;
import DTO.SemestreDTO;


public class AlunoSemDAO {


	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";
	private String nomePessoa = "";
	List <AlunoSemDTO> alunosSemestre = new ArrayList<AlunoSemDTO>();
	
	
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
	
	public Boolean Incluir(AlunoSemDTO alunoSemDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO ALUNOSEM(IDALUNO, IDSEMESTRE)"
					+ " VALUES (?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, alunoSemDTO.getAluno().getCodigo());
			pst.setLong(2, alunoSemDTO.getSemestre().getCodigo());
			return (pst.executeUpdate() > 0 ? true : false);
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public Boolean Alterar(AlunoSemDTO alunoSemDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE ALUNOSEM SET IDALUNO=?,IDSEMESTRE=?"
					+ " WHERE IDALUNOSEM = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, alunoSemDTO.getAluno().getCodigo());
			pst.setLong(2, alunoSemDTO.getSemestre().getCodigo());
			pst.setLong(3, alunoSemDTO.getCodigo());
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

			comandoSql = "DELETE FROM ALUNOSEM WHERE IDALUNOSEM = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	public List<AlunoSemDTO> Listar() throws Exception {		
		AlunoSemDTO alunoSemDTO;
		AlunoDTO alunoDTO;
		SemestreDTO semestreDTO;
		List<AlunoSemDTO> alunosSemestre = new ArrayList<AlunoSemDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return alunosSemestre;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM ALUNOSEM ORDER BY IDALUNOSEM";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				alunoSemDTO = new AlunoSemDTO();
				alunoDTO = new AlunoDTO();
				semestreDTO = new SemestreDTO();
				alunoSemDTO.setCodigo(rs.getLong("IDALUNOSEM"));
				alunoDTO.setCodigo(rs.getLong("IDALUNO"));
				semestreDTO.setCodigo(rs.getLong("IDSEMESTRE"));
				alunoSemDTO.setAluno(alunoDTO);
				alunoSemDTO.setSemestre(semestreDTO);
				
				
				
			System.out.println(alunoSemDTO.getCodigo() + " " + alunoSemDTO.getAluno().getCodigo() + 
				" " + alunoSemDTO.getSemestre().getCodigo());
				
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return alunosSemestre;
	}
		
}	
