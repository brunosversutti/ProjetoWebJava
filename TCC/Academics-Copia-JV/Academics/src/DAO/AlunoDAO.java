package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.AlunoDTO;
import DTO.CidadeDTO;
import DTO.CursoDTO;
import DTO.PessoaDTO;
import DTO.ProfessorDTO;

public class AlunoDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";
	
	List <AlunoDTO> cursos = new ArrayList<AlunoDTO>();
	
	
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
	
	
	public Long Incluir(AlunoDTO alunoDTO) throws Exception {
		
		long codigoAluno = 0;
		
		System.out.println("ALUNO - CURSO" + alunoDTO.getCurso().getCodigo());
		
		try
		{
			if(!VerifiqueConexao())
				return codigoAluno;

			comandoSql = "INSERT INTO ALUNO(IDPESSOA, IDCURSO, RA, SITUACAO)"
					+ " VALUES (?,?,?,?)";
			
			System.out.println(comandoSql);
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, alunoDTO.getPessoa().getCodigo());
			pst.setLong(2, alunoDTO.getCurso().getCodigo());
			pst.setInt(3, alunoDTO.getrA());
			pst.setInt(4, alunoDTO.getSituacao());
			//return (pst.executeUpdate() > 0 ? true : false);
			
			if(pst.executeUpdate() > 0 ){
				st = (Statement)conexao.createStatement();
				comandoSql = "SELECT MAX(IDALUNO) FROM ALUNO";
				
				rs = st.executeQuery(comandoSql);
				System.out.println(comandoSql);
				while(rs.next()){
					codigoAluno = (rs.getLong(1));
					System.out.println(codigoAluno + " = IDALUNO");
					alunoDTO.setCodigo(codigoAluno);
				}
			}
			return codigoAluno;
			
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public Boolean Alterar(AlunoDTO alunoDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE ALUNO SET IDPESSOA=?,IDCURSO=?,RA=?,SITUACAO=?"
					+ " WHERE IDALUNO = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, alunoDTO.getPessoa().getCodigo());
			pst.setLong(2, alunoDTO.getCurso().getCodigo());
			pst.setInt(3, alunoDTO.getrA());
			pst.setInt(4, alunoDTO.getSituacao());
			pst.setLong(5, alunoDTO.getCodigo());
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

			comandoSql = "DELETE FROM ALUNO WHERE IDALUNO = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public List<AlunoDTO> Listar() throws Exception {
		AlunoDTO alunoDTO;
		CursoDTO cursoDTO;
		CidadeDTO cidadeDTO;
		PessoaDTO pessoaDTO;
		List<AlunoDTO> alunos = new ArrayList<AlunoDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return alunos;

			Statement st = (Statement)conexao.createStatement();
			//comandoSql =  "SELECT * FROM PESSOA,ALUNO ORDER BY PESSOA.NOME";
			comandoSql =  "SELECT * FROM CIDADE,PESSOA,ALUNO,CURSO WHERE PESSOA.IDCIDADE = CIDADE.IDCIDADE AND PESSOA.IDPESSOA = ALUNO.IDPESSOA AND ALUNO.IDCURSO = CURSO.IDCURSO ORDER BY PESSOA.NOME";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				alunoDTO = new AlunoDTO();
				pessoaDTO = new PessoaDTO();
				cidadeDTO = new CidadeDTO();
				cursoDTO = new CursoDTO();
				
				cidadeDTO.setCodigo(rs.getLong("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));
				
				pessoaDTO.setCidade(cidadeDTO);
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				pessoaDTO.setNome(rs.getString("NOME"));
				pessoaDTO.setNascimento(rs.getString("NASCIMENTO"));
				pessoaDTO.setTelefone(rs.getString("TELEFONE"));
				pessoaDTO.setLogin(rs.getString("LOGIN"));
				pessoaDTO.setSenha(rs.getString("SENHA"));
				pessoaDTO.setRg(rs.getString("RG"));
				pessoaDTO.setCpf(rs.getString("CPF"));
				pessoaDTO.setNivel(rs.getInt("NIVELUSUARIO"));
				
				cursoDTO.setCodigo(rs.getLong("IDCURSO"));
				cursoDTO.setNome(rs.getString("NOME"));
				cursoDTO.setDuracao(rs.getInt("DURACAO"));
				cursoDTO.setTitulo(rs.getString("TITULO"));
				cursoDTO.setPeriodo(rs.getString("PERIODO"));
				
				alunoDTO.setCodigo(rs.getLong("IDALUNO"));
				alunoDTO.setPessoa(pessoaDTO);
				alunoDTO.setrA(rs.getInt("RA"));
				alunoDTO.setCurso(cursoDTO);
				
				
				//alunoDTO.setCurso(cursoDTO);
				//alunoDTO.setCurso(cursoDTO);
				
				
				
				alunos.add(alunoDTO);
				System.out.println(alunoDTO.getCodigo() + " codigo " + alunoDTO.getrA()+" RA " +
				alunoDTO.getPessoa().getCodigo() + " pessoa " + alunoDTO.getPessoa().getNome() + " nome " + alunoDTO.getCurso().getCodigo() + " CURSO");
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return alunos;
	}
	
	public ResultSet BuscarPessoaAluno() throws Exception, SQLException {
		
		try
		{
			if(!VerifiqueConexao())
				return null;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE,PESSOA,ALUNO,CURSO WHERE PESSOA.IDCIDADE = CIDADE.IDCIDADE AND PESSOA.IDPESSOA = ALUNO.IDPESSOA AND CURSO.IDCURSO = ALUNO.IDCURSO ORDER BY PESSOA.NOME";
			
			rs = st.executeQuery(comandoSql);
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return rs;
	}
	
	
	
}
