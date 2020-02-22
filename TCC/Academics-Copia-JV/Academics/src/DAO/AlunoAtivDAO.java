package DAO;

import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;












import javax.servlet.ServletContext;

import DTO.AlunoAtivDTO;
import DTO.AlunoDTO;
import DTO.AtividadeDTO;
import DTO.DisciplinaDTO;



public class AlunoAtivDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;
	private String comandoSql = "";
	List <AlunoAtivDTO> atividadesAluno = new ArrayList<AlunoAtivDTO>();


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


	public Boolean Incluir(AlunoAtivDTO alunoAtivDTO) throws Exception {

		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO ATIVALUNO(IDATIVIDADE, IDALUNO, NOMEARQUIVO, ARQUIVO)"
					+ " VALUES (?,?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, alunoAtivDTO.getAtividade().getCodigo());
			pst.setLong(2, alunoAtivDTO.getAluno().getCodigo());
			pst.setString(3, alunoAtivDTO.getNomeArquivo());
			pst.setBinaryStream(4, alunoAtivDTO.getItem().getInputStream(), (int)alunoAtivDTO.getItem().getSize());
			System.out.println(comandoSql);

			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}


	public List<AlunoAtivDTO> Listar() throws Exception {

		AlunoAtivDTO alunoAtivDTO;
		AtividadeDTO atividadeDTO;
		AlunoDTO alunoDTO;
		List<AlunoAtivDTO> atividades = new ArrayList<AlunoAtivDTO>();

		System.out.println("CHAMOU ALUNOATIVDAO - LISTAR");
		try
		{
			if(!VerifiqueConexao())
				return atividades;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM ATIVALUNO, PESSOA, ALUNO WHERE ALUNO.IDALUNO"
					+ " = ATIVALUNO.IDALUNO AND ALUNO.IDPESSOA = PESSOA.IDPESSOA ORDER BY IDATIVALUNO";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				alunoAtivDTO = new AlunoAtivDTO();
				alunoDTO = new AlunoDTO();
				atividadeDTO = new AtividadeDTO();

				alunoAtivDTO.setCodigo(rs.getLong("IDATIVALUNO"));;
				atividadeDTO.setCodigo(rs.getLong("IDATIVIDADE"));
				alunoDTO.setCodigo(rs.getLong("IDALUNO"));
				alunoDTO.setNome(rs.getString("NOME"));
				alunoAtivDTO.setNomeArquivo(rs.getString("NOMEARQUIVO"));
				alunoAtivDTO.setArquivo(rs.getBytes("ARQUIVO"));


				alunoAtivDTO.setAtividade(atividadeDTO);
				alunoAtivDTO.setAluno(alunoDTO);

				//System.out.println(alunoAtivDTO.getNomeArquivo()+ " Nome: " + alunoAtivDTO.getAluno().getNome());

			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return atividades;
	} 


	public AlunoAtivDTO BaixarArquivos(String idArquivo) throws Exception {

		AlunoAtivDTO alunoAtivDTO;
		AtividadeDTO atividadeDTO;
		AlunoDTO alunoDTO;
		//List<AlunoAtivDTO> atividades = new ArrayList<AlunoAtivDTO>();
		System.out.println("CHAMOU O METODO BAIXAR ARQUIVOS");

		try
		{
			if(!VerifiqueConexao())
				return null;

			alunoAtivDTO = new AlunoAtivDTO();

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM ATIVALUNO, PESSOA, ALUNO WHERE ALUNO.IDALUNO = "
					+ "ATIVALUNO.IDALUNO AND ALUNO.IDPESSOA = PESSOA.IDPESSOA" +" AND IDATIVALUNO = "+ idArquivo;
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				alunoAtivDTO = new AlunoAtivDTO();
				alunoDTO = new AlunoDTO();
				atividadeDTO = new AtividadeDTO();

				alunoAtivDTO.setCodigo(rs.getLong("IDATIVALUNO"));;
				atividadeDTO.setCodigo(rs.getLong("IDATIVIDADE"));
				alunoDTO.setCodigo(rs.getLong("IDALUNO"));
				alunoDTO.setNome(rs.getString("NOME"));
				alunoAtivDTO.setNomeArquivo(rs.getString("NOMEARQUIVO"));
				alunoAtivDTO.setArquivo(rs.getBytes("ARQUIVO"));

				alunoAtivDTO.setAtividade(atividadeDTO);
				alunoAtivDTO.setAluno(alunoDTO);
				
				
				System.out.println(alunoAtivDTO.getNomeArquivo()+ " Nome: " + alunoAtivDTO.getAluno().getNome());

			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return alunoAtivDTO;
	}
	
	
	
	public ResultSet ListaDownloads() throws Exception{
		
		try
		{
		    if(!VerifiqueConexao())
				return null;
			
			Statement st = (Statement)conexao.createStatement();
			
			comandoSql =  "SELECT * FROM ATIVALUNO, PESSOA, ALUNO WHERE ALUNO.IDALUNO"
					+ " = ATIVALUNO.IDALUNO AND ALUNO.IDPESSOA = PESSOA.IDPESSOA ORDER BY IDATIVALUNO";
			rs = st.executeQuery(comandoSql);
			System.out.println("Executou o metodo");
			
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return rs;
	}


}
