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
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;
import DTO.SemestreDTO;


public class DisciplinaDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";

	List <DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();


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


	public Boolean Incluir(DisciplinaDTO disciplinaDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO DISCIPLINA(NOMEDISCIPLINA, DURACAO)"
					+ " VALUES (?,?)";      
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, disciplinaDTO.getNome());
			pst.setInt(2, disciplinaDTO.getDuracao());
			return (pst.executeUpdate() > 0 ? true : false);
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}



	public Boolean Alterar(DisciplinaDTO disciplinaDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE DISCIPLINA SET NOMEDISCIPLINA=? ,DURACAO=?"
					+ " WHERE IDDISCIPLINA = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, disciplinaDTO.getNome());
			pst.setInt(2, disciplinaDTO.getDuracao());
			pst.setLong(3, disciplinaDTO.getCodigo());

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

			comandoSql = "DELETE FROM DISCIPLINA WHERE IDDISCIPLINA = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}


	public List<DisciplinaDTO> Listar() throws Exception {
		DisciplinaDTO disciplinaDTO;

		List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();

		try
		{
			if(!VerifiqueConexao())
				return disciplinas;

			Statement st = (Statement)conexao.createStatement();
			//comandoSql =  "SELECT * FROM DISCIPLINA ORDER BY NOMEDISCIPLINA";
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
				disciplinaDTO = new DisciplinaDTO();

				disciplinaDTO.setCodigo(rs.getLong("IDDISCIPLINA"));
				disciplinaDTO.setNome(rs.getString("NOMEDISCIPLINA"));
				disciplinaDTO.setDuracao(rs.getInt("DURACAO"));
				disciplinas.add(disciplinaDTO);

				System.out.println(disciplinaDTO.getCodigo() + "-" + disciplinaDTO.getNome() + "-" +
						disciplinaDTO.getDuracao());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return disciplinas;
	}


	public ResultSet BuscarDisciplina(DisciplinaDTO disciplinaDTO) throws Exception{

		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM DISCIPLINA WHERE NOMEDISCIPLINA = " + "'"+disciplinaDTO.getNome()+"'";

			System.out.println(comandoSql);
			rs = st.executeQuery(comandoSql);

		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}
		finally{
			System.out.println("NAO ENCONTROU NENHUM DADO OU DISCIPLINA CADASTRADOS");
		}

		return rs;
	}

	public ResultSet BuscarDisciplinas() throws Exception, SQLException {

		try
		{
			if(!VerifiqueConexao())
				return null;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM DISCIPLINA ORDER BY NOMEDISCIPLINA";

			rs = st.executeQuery(comandoSql);
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return rs;
	}



}
