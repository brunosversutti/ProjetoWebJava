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
import DTO.PessoaDTO;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;
import DTO.SemestreDTO;



public class CursoProfSemDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";

	List <CursoProfSemDTO> alunosSemestre = new ArrayList<CursoProfSemDTO>();


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

	public Long Incluir(ProfSemDTO profSemDTO, CursoDTO cursoDTO, CursoProfSemDTO cursoProfSemDTO) throws Exception {
		
		long codigoCursoProfSem = 0;
		
		try
		{
			if(!VerifiqueConexao())
				return codigoCursoProfSem;

			comandoSql = "INSERT INTO CURSOPROFSEM(IDCURSO, IDPROFSEM)"
					+ " VALUES (?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, cursoDTO.getCodigo());;
			pst.setLong(2, profSemDTO.getCodigo());
			if(pst.executeUpdate() > 0 ){
				st = (Statement)conexao.createStatement();
				comandoSql = "SELECT MAX(IDCURSOPROFSEM) FROM CURSOPROFSEM";
				rs = st.executeQuery(comandoSql);
				while(rs.next()){
					codigoCursoProfSem = (rs.getLong(1));
					System.out.println(codigoCursoProfSem + " = IDCURSOPROFSEM");
					cursoProfSemDTO.setCodigo(codigoCursoProfSem);
				}
			}
			
			return codigoCursoProfSem;
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	public Boolean Alterar(CursoProfSemDTO cursoProfSemDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE CURSOPROFSEM SET IDCURSO=?, IDPROFSEM=?"
					+ " WHERE IDCURSOPROFSEM = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, cursoProfSemDTO.getCurso().getCodigo());
			pst.setLong(2, cursoProfSemDTO.getProfSemestre().getCodigo());
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

			comandoSql = "DELETE FROM CURSOPROFSEM WHERE IDCURSOPROFSEM = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}

	public List<CursoProfSemDTO> Listar() throws Exception {		
		CursoProfSemDTO cursoProfSemDTO;
		ProfessorDTO professorDTO;
		CursoDTO cursoDTO;
		SemestreDTO semestreDTO;
		List<CursoProfSemDTO> cursosProfSemDTO = new ArrayList<CursoProfSemDTO>();
		
		List<DisciplinaDTO> disciplinas;
		

		try
		{
			if(!VerifiqueConexao())
				return cursosProfSemDTO;

			Statement st = (Statement)conexao.createStatement();
			//comandoSql =  "SELECT * FROM CURSOPROFSEM ORDER BY IDCURSOPROFSEM";
			
			comandoSql =  "SELECT * FROM PESSOA, PROFESSOR, PROFSEMESTRE, SEMESTRE, CURSO, CURSOPROFSEM, DISCIPLINA, ITDISCIPLINA"
					+ " WHERE PESSOA.IDPESSOA = PROFESSOR.IDPESSOA"
					+" AND SEMESTRE.IDSEMESTRE = PROFSEMESTRE.IDSEMESTRE"
					+" AND PROFSEMESTRE.IDPROFESSOR = PROFESSOR.IDPROFESSOR"
					+" AND CURSO.IDCURSO = CURSOPROFSEM.IDCURSO"
					+" AND CURSOPROFSEM.IDPROFSEM = PROFSEMESTRE.IDPROFESSOR"
					+" AND ITDISCIPLINA.IDCURSOPROFSEM = CURSOPROFSEM.IDCURSOPROFSEM"
					+" AND ITDISCIPLINA.IDDISCIPLINA = DISCIPLINA.IDDISCIPLINA";
			System.out.println("Executou o comando sql cursoprofsemDAO " + comandoSql);
			
			
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				/**
				cursoProfSemDTO = new CursoProfSemDTO();
				professorDTO = new ProfessorDTO();
				cursoDTO = new CursoDTO();

				cursoProfSemDTO.setCodigo(rs.getLong("IDCURSOPROFSEM"));
				cursoDTO.setCodigo(rs.getLong("IDCURSO"));
				cursoProfSemDTO.setCodigo(rs.getLong("IDPROFSEM"));
				cursoProfSemDTO.setCurso(cursoDTO);
				professorDTO.setCodigo(rs.getLong("IDPROFESSOR"));
				*/
				List<CursoDTO> cursos = new ArrayList<CursoDTO>();
				List<SemestreDTO> semestres = new ArrayList<SemestreDTO>();
				List<ProfSemDTO> profSemestres = new ArrayList<ProfSemDTO>();
				//List<CursoProfSemDTO> cursoProfSemestres = new ArrayList<CursoProfSemDTO>();
				disciplinas = new ArrayList<DisciplinaDTO>();
				List<ItensDisciplinaDTO> itensDisciplinas = new ArrayList<ItensDisciplinaDTO>();
				PessoaDTO pessoaDTO = new PessoaDTO();
				professorDTO = new ProfessorDTO();
				semestreDTO = new SemestreDTO();
				ProfSemDTO profSemestreDTO = new ProfSemDTO();
				cursoDTO = new CursoDTO();
				cursoProfSemDTO = new CursoProfSemDTO();
				ItensDisciplinaDTO itDisciplinaDTO = new ItensDisciplinaDTO();
				DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
				
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				pessoaDTO.setNome(rs.getString("NOME"));
				
				
				professorDTO.setCodigo(rs.getLong("IDPROFESSOR"));
				professorDTO.setPessoa(pessoaDTO);
				professorDTO.setTitulo(rs.getString("TITULO"));
				professorDTO.setEspecialidade(rs.getString("ESPECIALIDADE"));
				
				semestreDTO.setCodigo(rs.getLong("IDSEMESTRE"));
				semestreDTO.setAno(rs.getInt("ANO"));
				semestreDTO.setPeriodo(rs.getString("PERIODO"));
				
				profSemestreDTO.setCodigo(rs.getLong("IDPROFSEMESTRE"));
				profSemestreDTO.setProfessor(professorDTO);
				profSemestreDTO.setSemestre(semestreDTO);
				
				cursoDTO.setCodigo(rs.getLong("IDCURSO"));
				cursoDTO.setNome(rs.getString("NOMECURSO"));
				cursoDTO.setPeriodo(rs.getString("PERIODO"));
					
				disciplinaDTO.setCodigo(rs.getLong("IDDISCIPLINA"));
				disciplinaDTO.setNome(rs.getString("NOMEDISCIPLINA"));
				
				cursoProfSemDTO.setCodigo(rs.getLong("IDCURSOPROFSEM"));
				cursoProfSemDTO.setCurso(cursoDTO);
				cursoProfSemDTO.setProfSemestre(profSemestreDTO);
				
				
				itDisciplinaDTO.setCodigo(rs.getLong("IDITDISCIPLINA"));
				itDisciplinaDTO.setDisciplina(disciplinaDTO);
				
				semestres.add(semestreDTO);
				profSemestres.add(profSemestreDTO);
				cursos.add(cursoDTO);
				disciplinas.add(disciplinaDTO);
				//cursoProfSemestres.add(cursoProfSemDTO);
				cursosProfSemDTO.add(cursoProfSemDTO);
				itensDisciplinas.add(itDisciplinaDTO);


			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return cursosProfSemDTO;
	}


	public ResultSet BuscarCursoProfSem(ProfSemDTO profSemDTO, CursoDTO cursoDTO) throws Exception{

		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CURSOPROFSEM WHERE CURSOPROFSEM.IDCURSO = " +"'"+cursoDTO.getCodigo()+"'"
					+" AND CURSOPROFSEM.IDPROFSEM = "+ "'"+profSemDTO.getCodigo()+"'" ;

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


	public ResultSet BuscarCursoProfSem() throws Exception{

		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CURSOPROFSEM ORDER BY IDCURSO";

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


	public ResultSet BuscarPessoaCursoProfSem(PessoaDTO pessoaDTO) throws Exception{

		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PESSOA, PROFESSOR, PROFSEMESTRE, SEMESTRE, CURSO, CURSOPROFSEM, DISCIPLINA, ITDISCIPLINA"
					+ " WHERE PESSOA.IDPESSOA ="+ pessoaDTO.getCodigo()
					+" AND PROFESSOR.IDPESSOA ="+ pessoaDTO.getCodigo()
					+" AND SEMESTRE.IDSEMESTRE = PROFSEMESTRE.IDSEMESTRE"
					+" AND PROFSEMESTRE.IDPROFESSOR = PROFESSOR.IDPROFESSOR"
					+" AND CURSO.IDCURSO = CURSOPROFSEM.IDCURSO"
					+" AND CURSOPROFSEM.IDPROFSEM = PROFSEMESTRE.IDPROFESSOR"
					+" AND ITDISCIPLINA.IDCURSOPROFSEM = CURSOPROFSEM.IDCURSOPROFSEM"
					+" AND ITDISCIPLINA.IDDISCIPLINA = DISCIPLINA.IDDISCIPLINA";

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
