package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.CursoDTO;
import DTO.DisciplinaDTO;
import DTO.PessoaDTO;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;


public class CursoDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";
	
	List <CursoDTO> cursos = new ArrayList<CursoDTO>();
	
	
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
	
	
	public Boolean Incluir(CursoDTO cursoDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO CURSO(NOMECURSO, DURACAO, TITULO, PERIODO)"
					+ " VALUES (?,?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, cursoDTO.getNome());
			pst.setInt(2, cursoDTO.getDuracao());
			pst.setString(3, cursoDTO.getTitulo());
			pst.setString(4, cursoDTO.getPeriodo());
			return (pst.executeUpdate() > 0 ? true : false);
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	
	public Boolean Alterar(CursoDTO cursoDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE CURSO SET IDPROFSEMESTRE=?,NOMECURSO=?,DURACAO=?,TITULO=?,PERIODO=?"
					+ " WHERE IDCURSO = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, cursoDTO.getProfSemestre().getCodigo());
			pst.setString(2, cursoDTO.getNome());
			pst.setInt(3, cursoDTO.getDuracao());
			pst.setString(4, cursoDTO.getTitulo());
			pst.setString(5, cursoDTO.getPeriodo());
			pst.setLong(6, cursoDTO.getCodigo());
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

			comandoSql = "DELETE FROM CURSO WHERE IDCURSO = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	/**
	public List<CursoDTO> Listar() throws Exception {
		CursoDTO cursoDTO;
		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return cursos;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CURSO ORDER BY NOMECURSO";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				cursoDTO = new CursoDTO();
				cursoDTO.setCodigo(rs.getLong("IDCURSO"));
				cursoDTO.setNome(rs.getString("NOMECURSO"));
				cursoDTO.setDuracao(rs.getInt("DURACAO"));
				cursoDTO.setTitulo(rs.getString("TITULO"));
				cursoDTO.setPeriodo(rs.getString("PERIODO"));
				
				cursos.add(cursoDTO);
				
				System.out.println(cursoDTO.getCodigo() + "-" + cursoDTO.getProfSemestre().getCodigo() + "-" +
				cursoDTO.getNome()+ "-" + cursoDTO.getDuracao() + "-" + cursoDTO.getTitulo() + "-" +
						cursoDTO.getPeriodo());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return cursos;
	}
	
	*/
public ResultSet BuscarCurso(CursoDTO cursoDTO) throws Exception{
		
		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CURSO WHERE NOMECURSO = " + "'"+cursoDTO.getNome()+"'"+" AND PERIODO = "+"'"+cursoDTO.getPeriodo()+"'";
			
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

	public ResultSet BuscarCursos() throws Exception{
	
		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CURSO ORDER BY NOMECURSO";
	
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
	
	public List<CursoDTO> Listar() throws Exception {
		CursoDTO cursoDTO;
		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return cursos;

			Statement st = (Statement)conexao.createStatement();
			//comandoSql =  "SELECT * FROM CURSO ORDER BY NOMECURSO";
			comandoSql =  "SELECT * FROM PESSOA, PROFESSOR, PROFSEMESTRE, SEMESTRE, CURSO, CURSOPROFSEM, DISCIPLINA, ITDISCIPLINA"
					+ " WHERE PESSOA.IDPESSOA = PROFESSOR.IDPESSOA"
					+" AND SEMESTRE.IDSEMESTRE = PROFSEMESTRE.IDSEMESTRE"
					+" AND PROFSEMESTRE.IDPROFESSOR = PROFESSOR.IDPROFESSOR"
					+" AND CURSO.IDCURSO = CURSOPROFSEM.IDCURSO"
					+" AND CURSOPROFSEM.IDPROFSEM = PROFSEMESTRE.IDPROFESSOR"
					+" AND ITDISCIPLINA.IDCURSOPROFSEM = CURSOPROFSEM.IDCURSOPROFSEM"
					+" AND ITDISCIPLINA.IDDISCIPLINA = DISCIPLINA.IDDISCIPLINA";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				cursoDTO = new CursoDTO();
				cursoDTO.setCodigo(rs.getLong("IDCURSO"));
				cursoDTO.setNome(rs.getString("NOMECURSO"));
				cursoDTO.setDuracao(rs.getInt("DURACAO"));
				cursoDTO.setTitulo(rs.getString("TITULO"));
				cursoDTO.setPeriodo(rs.getString("PERIODO"));
				
				cursos.add(cursoDTO);
				
				System.out.println(cursoDTO.getCodigo() + "-" + cursoDTO.getProfSemestre().getCodigo() + "-" +
				cursoDTO.getNome()+ "-" + cursoDTO.getDuracao() + "-" + cursoDTO.getTitulo() + "-" +
						cursoDTO.getPeriodo());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return cursos;
	}

	
		
}
