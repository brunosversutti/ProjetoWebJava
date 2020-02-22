package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




import DTO.CursoDTO;
import DTO.CursoProfSemDTO;
import DTO.DisciplinaDTO;
import DTO.ItensDisciplinaDTO;
import DTO.ProfSemDTO;



public class ItensDisciplinaDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;
	private String comandoSql = "";

	List <ItensDisciplinaDTO> itensDisciplina = new ArrayList<ItensDisciplinaDTO>();
	
	
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
	
	public Long Incluir(ItensDisciplinaDTO itensDisciplinaDTO) throws Exception {
		
		long codigodisciplina = 0;
		
		try
		{
			if(!VerifiqueConexao())
				return codigodisciplina;

			comandoSql = "INSERT INTO ITDISCIPLINA(IDDISCIPLINA, IDCURSOPROFSEM)"
					+ " VALUES (?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, itensDisciplinaDTO.getDisciplina().getCodigo());
			pst.setLong(2, itensDisciplinaDTO.getCursoprofsem().getCodigo());
			//return (pst.executeUpdate() > 0 ? true : false);
			if(pst.executeUpdate() > 0 ){
				st = (Statement)conexao.createStatement();
				comandoSql = "SELECT MAX(IDITDISCIPLINA) FROM ITDISCIPLINA";
				rs = st.executeQuery(comandoSql);
				while(rs.next()){
					codigodisciplina = (rs.getLong(1));
					itensDisciplinaDTO.setCodigo(codigodisciplina);
					
					System.out.println(codigodisciplina + " = IDDISCIPLINA");
				}
			}

			return codigodisciplina;
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public Boolean Alterar(ItensDisciplinaDTO itensDisciplinaDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE ITDISCIPLINA SET IDDISCIPLINA=?, IDCURSOPROFSEM=?"
					+ " WHERE IDITDISCIPLINA = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, itensDisciplinaDTO.getDisciplina().getCodigo());
			pst.setLong(2, itensDisciplinaDTO.getCursoprofsem().getCodigo());
			pst.setLong(3, itensDisciplinaDTO.getCodigo());
			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public Boolean Excluir(long codigo) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "DELETE FROM ITDISCIPLINA WHERE IDITDISCIPLINA = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	public List<ItensDisciplinaDTO> Listar() throws Exception {		
		ItensDisciplinaDTO itDisciplina;
		CursoProfSemDTO cursoProfSemDTO;
		DisciplinaDTO disciplinaDTO;
		
		List<ItensDisciplinaDTO> itensDisciplinas = new ArrayList<ItensDisciplinaDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return itensDisciplinas;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM ITDISCIPLINA ORDER BY IDITDISCIPLINA";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				itDisciplina = new ItensDisciplinaDTO();
				cursoProfSemDTO = new CursoProfSemDTO();
				disciplinaDTO = new DisciplinaDTO();
			
				itDisciplina.setCodigo(rs.getLong("IDITDISCIPLINA"));
				disciplinaDTO.setCodigo(rs.getLong("IDDISCIPLINA"));
				cursoProfSemDTO.setCodigo(rs.getLong("IDCURSOPROFSEM"));
				
				itDisciplina.setDisciplina(disciplinaDTO);
				itDisciplina.setCursoprofsem(cursoProfSemDTO);
				
				
				System.out.println(itDisciplina.getCodigo() + "-" + itDisciplina.getDisciplina().getCodigo() + "-" + itDisciplina.getCursoprofsem().getCodigo());
				
				
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return itensDisciplinas;
	}
	
	
	public ResultSet BuscarItensDisciplina() throws Exception{

		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CURSOPROFSEM, DISCIPLINA, ITDISCIPLINA WHERE CURSOPROFSEM.IDCURSOPROFSEM = ITDISCIPLINA.IDCURSOPROFSEM AND DISCIPLINA.IDDISCIPLINA = ITDISCIPLINA.IDITDISCIPLINA" ;

			System.out.println(comandoSql);
			rs = st.executeQuery(comandoSql);

		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}
		finally{
			System.out.println("NAO ENCONTROU NENHUM DADO OU CURSO CADASTRADOS");
		}

		return rs;
	}
	
	
	
	public ResultSet BuscarItensDisciplina(ItensDisciplinaDTO itensDisciplinaDTO) throws Exception{

		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CURSOPROFSEM, DISCIPLINA, ITDISCIPLINA WHERE "
					+ "CURSOPROFSEM.IDCURSOPROFSEM ="+"'"+itensDisciplinaDTO.getCursoprofsem().getCodigo()+"'"
					+"AND DISCIPLINA.IDDISCIPLINA ="+"'"+itensDisciplinaDTO.getDisciplina().getCodigo()+"'" ;

			System.out.println(comandoSql);
			rs = st.executeQuery(comandoSql);

		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}
		finally{
			System.out.println("NAO ENCONTROU NENHUM DADO OU CURSO CADASTRADOS");
		}

		return rs;
	}
	
	
}
