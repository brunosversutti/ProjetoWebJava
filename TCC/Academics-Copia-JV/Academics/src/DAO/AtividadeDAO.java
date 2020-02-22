package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.AtividadeDTO;
import DTO.ItensDisciplinaDTO;
import DTO.PessoaDTO;


public class AtividadeDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;
	private String comandoSql = "";
	List <AtividadeDTO> atividades = new ArrayList<AtividadeDTO>();


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

	public Long Incluir(AtividadeDTO atividadeDTO) throws Exception {
		long codigoAtividade = 0;
		try
		{
			if(!VerifiqueConexao())
				return codigoAtividade;

			comandoSql = "INSERT INTO ATIVIDADE(IDITDISCIPLINA, NOMEATIV, TIPOATIV, NOTA)"
					+ " VALUES (?,?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, atividadeDTO.getItenDisciplina().getCodigo());
			pst.setString(2, atividadeDTO.getNome());
			pst.setInt(3, atividadeDTO.getTipo());
			pst.setDouble(4, atividadeDTO.getNota());

			System.out.println("inclusao da atividade comando sql " + comandoSql);

			//return (pst.executeUpdate() > 0 ? true : false);
			if(pst.executeUpdate() > 0 ){
				st = (Statement)conexao.createStatement();
				comandoSql = "SELECT MAX(IDATIVIDADE) FROM ATIVIDADE";
				rs = st.executeQuery(comandoSql);
				while(rs.next()){
					codigoAtividade = (rs.getLong(1));
					System.out.println(codigoAtividade + " = IDPESSOA");
					atividadeDTO.setCodigo(codigoAtividade);
				}
		}
			return codigoAtividade;
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}

	public Boolean Alterar(AtividadeDTO atividadeDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE ATIVIDADE SET IDITDISCIPLINA=?, NOMEATIV=?, TIPOATIV=?, NOTA=?"
					+ " WHERE IDATIVIDADE = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, atividadeDTO.getItenDisciplina().getCodigo());
			pst.setString(2, atividadeDTO.getNome());
			pst.setInt(3, atividadeDTO.getTipo());
			pst.setDouble(4, atividadeDTO.getNota());
			pst.setLong(5, atividadeDTO.getCodigo());
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

			comandoSql = "DELETE FROM ATIVIDADE WHERE IDATIVIDADE = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}


	public List<AtividadeDTO> Listar() throws Exception {
		AtividadeDTO atividadeDTO;
		ItensDisciplinaDTO itenDiscDTO;

		List<AtividadeDTO> atividades = new ArrayList<AtividadeDTO>();

		try
		{
			if(!VerifiqueConexao())
				return atividades;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM ATIVIDADE ORDER BY TIPOATIV";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				itenDiscDTO = new ItensDisciplinaDTO();
				atividadeDTO = new AtividadeDTO();

				itenDiscDTO.setCodigo(rs.getLong("IDITDISCIPLINA"));
				atividadeDTO.setCodigo(rs.getLong("IDATIVIDADE"));
				atividadeDTO.setItenDisciplina(itenDiscDTO);
				atividadeDTO.setNome(rs.getString("NOMEATIV"));
				atividadeDTO.setTipo(rs.getInt("TIPOATIV"));
				atividadeDTO.setNota(rs.getDouble("NOTA"));

				atividades.add(atividadeDTO);

				System.out.println(atividadeDTO.getCodigo()+ " " + atividadeDTO.getNome() + atividadeDTO.getTipo() + 
						" " + atividadeDTO.getNota() + " " + atividadeDTO.getItenDisciplina().getCodigo() );
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return atividades;
	}

	public ResultSet BuscarAtividadesAluno(PessoaDTO pessoaDTO) throws Exception{

		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			
			comandoSql ="SELECT * FROM PESSOA, ALUNO, CURSO, CURSOPROFSEM, ITDISCIPLINA, DISCIPLINA, ATIVIDADE"
					+ " WHERE PESSOA.IDPESSOA = " + pessoaDTO.getCodigo()
					+ " AND ALUNO.IDPESSOA = " + pessoaDTO.getCodigo()
					+ " AND ALUNO.IDCURSO = CURSO.IDCURSO"
					+ " AND CURSOPROFSEM.IDCURSO = CURSO.IDCURSO"
					+ " AND CURSOPROFSEM.IDCURSOPROFSEM = ITDISCIPLINA.IDCURSOPROFSEM"
					+ " AND ITDISCIPLINA.IDDISCIPLINA = DISCIPLINA.IDDISCIPLINA";
			
			
			
			
			
			/**
			comandoSql =  "SELECT * FROM ATIVIDADE, DISCIPLINA, ITDISCIPLINA, CURSOPROFSEM, CURSO, ALUNO, ALUNOSEM, PESSOA"
					+" WHERE ATIVIDADE.IDITDISCIPLINA = ITDISCIPLINA.IDITDISCIPLINA"
					+" AND DISCIPLINA.IDDISCIPLINA = ITDISCIPLINA.IDDISCIPLINA"
					+" AND ITDISCIPLINA.IDCURSOPROFSEM = CURSOPROFSEM.IDCURSOPROFSEM"
					+" AND CURSOPROFSEM.IDCURSO = CURSO.IDCURSO"
					+" AND CURSO.IDCURSO = ALUNO.IDCURSO"
					+" AND ALUNO.IDPESSOA = " + pessoaDTO.getCodigo()
					+" AND PESSOA.IDPESSOA = " + pessoaDTO.getCodigo()
					+" AND ALUNO.IDALUNO = ALUNOSEM.IDALUNO";
					
				*/	

			/**
			comandoSql =  "SELECT * FROM ATIVIDADE, DISCIPLINA, ITDISCIPLINA, CURSOPROFSEM, CURSO, ALUNO, ALUNOSEM, PESSOA"
					+" WHERE ATIVIDADE.IDITDISCIPLINA = ITDISCIPLINA.IDITDISCIPLINA"
					+" AND DISCIPLINA.IDDISCIPLINA = ITDISCIPLINA.IDDISCIPLINA"
					+" AND ITDISCIPLINA.IDCURSOPROFSEM = CURSOPROFSEM.IDCURSOPROFSEM"
					+" AND CURSOPROFSEM.IDCURSO = CURSO.IDCURSO"
					+" AND CURSO.IDCURSO = ALUNO.IDCURSO"
					+" AND ALUNO.IDPESSOA =" + pessoaDTO.getCodigo()
					+" AND PESSOA.IDPESSOA =" + pessoaDTO.getCodigo()
					+" AND ALUNO.IDALUNO = ALUNOSEM.IDALUNO";
			*/

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
