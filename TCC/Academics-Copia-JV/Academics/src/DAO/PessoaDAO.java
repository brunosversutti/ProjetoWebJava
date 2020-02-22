package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import DTO.CidadeDTO;
import DTO.PessoaDTO;


public class PessoaDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;
	private String comandoSql = "";
	List <PessoaDTO> cidades = new ArrayList<PessoaDTO>();
	private String nomePessoa = "";
	
	
	
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
	
	
	public Long Incluir(PessoaDTO pessoaDTO, CidadeDTO cidadeDTO) throws Exception {
		
		long codigoPessoa = 0;
		
		try
		{
			if(!VerifiqueConexao())
				return codigoPessoa;

			comandoSql = "INSERT INTO PESSOA(IDCIDADE,NOME,NASCIMENTO,TELEFONE,LOGIN,SENHA,RG,CPF, NIVELUSUARIO)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, pessoaDTO.getCidade().getCodigo());
			pst.setString(2, pessoaDTO.getNome());
			pst.setString(3, (pessoaDTO.getNascimento()));
			pst.setString(4, pessoaDTO.getTelefone());
			pst.setString(5, pessoaDTO.getLogin());
			pst.setString(6, pessoaDTO.getSenha());
			pst.setString(7, pessoaDTO.getRg());
			pst.setString(8, pessoaDTO.getCpf());
			pst.setInt(9, pessoaDTO.getNivel());
			
			System.out.println(comandoSql + "INSERIR PESSOA");
			//return (pst.executeUpdate() > 0 ? true : false);
			if(pst.executeUpdate() > 0 ){
				st = (Statement)conexao.createStatement();
				comandoSql = "SELECT MAX(IDPESSOA) FROM PESSOA";
				rs = st.executeQuery(comandoSql);
				while(rs.next()){
					codigoPessoa = (rs.getLong(1));
					System.out.println(codigoPessoa + " = IDPESSOA");
					pessoaDTO.setCodigo(codigoPessoa);
				}
			}
			
			return codigoPessoa;
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public Boolean Alterar(PessoaDTO pessoaDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "UPDATE PESSOA SET IDCIDADE=?,NOME=?,NASCIMENTO=?,TELEFONE=?,LOGIN=?,SENHA=?,RG=?,CPF=?"
					+ " WHERE IDPESSOA = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			
			pst.setLong(1, pessoaDTO.getCidade().getCodigo());
			pst.setString(2, pessoaDTO.getNome());
			pst.setString(3, pessoaDTO.getNascimento());
			pst.setString(4, pessoaDTO.getTelefone());
			pst.setString(5, pessoaDTO.getLogin());
			pst.setString(6, pessoaDTO.getSenha());
			pst.setString(7, pessoaDTO.getRg());
			pst.setString(8, pessoaDTO.getCpf());
			pst.setLong(9, pessoaDTO.getCodigo());
			pst.setInt(10, pessoaDTO.getNivel());
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

			comandoSql = "DELETE FROM PESSOA WHERE IDPESSOA = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public List<PessoaDTO> Pesquisar(String NomePessoa) throws Exception {
		PessoaDTO pessoaDTO;
		CidadeDTO cidadeDTO;
		List<PessoaDTO> pessoas = new ArrayList<PessoaDTO>();

		nomePessoa = NomePessoa;
		//CidadeDTO cidadeDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return pessoas;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PESSOA WHERE NOME LIKE " +"'%"+nomePessoa+"%'";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				pessoaDTO = new PessoaDTO();
				cidadeDTO = new CidadeDTO();
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				cidadeDTO.setCodigo(rs.getLong("IDCIDADE"));
				pessoaDTO.setCidade(cidadeDTO);
				pessoaDTO.setNome(rs.getString("NOME"));
				pessoaDTO.setNascimento(rs.getString("NASCIMENTO"));
				pessoaDTO.setTelefone(rs.getString("TELEFONE"));
				pessoaDTO.setLogin(rs.getString("LOGIN"));
				pessoaDTO.setSenha(rs.getString("SENHA"));
				pessoaDTO.setRg(rs.getString("RG"));
				pessoaDTO.setCpf(rs.getString("CPF"));
				pessoaDTO.setNivel(rs.getInt("NIVELUSUARIO"));
				
				cidades.add(pessoaDTO);
				
				System.out.println(pessoaDTO.getNome());

			}
			
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return pessoas;
	}
	
	public PessoaDTO BuscaRegistro(int codigo) throws Exception, SQLException {

		PessoaDTO pessoaDTO = null;
		CidadeDTO cidadeDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return pessoaDTO;
			
			Statement st = (Statement)conexao.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
			comandoSql =  "SELECT * FROM PESSOA WHERE CODIGO = " + codigo;
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				pessoaDTO = new PessoaDTO();
				cidadeDTO = new CidadeDTO();
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				cidadeDTO.setCodigo(rs.getLong("IDCIDADE"));
				pessoaDTO.setCidade(cidadeDTO);
				pessoaDTO.setNome(rs.getString("NOME"));
				pessoaDTO.setNascimento(rs.getString("NASCIMENTO"));
				pessoaDTO.setTelefone(rs.getString("TELEFONE"));
				pessoaDTO.setLogin(rs.getString("LOGIN"));
				pessoaDTO.setSenha(rs.getString("SENHA"));
				pessoaDTO.setRg(rs.getString("RG"));
				pessoaDTO.setCpf(rs.getString("CPF"));
				pessoaDTO.setNivel(rs.getInt("NIVELUSUARIO"));
			}
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return pessoaDTO;
	}
	
	public List<PessoaDTO> Listar() throws Exception {
		PessoaDTO pessoaDTO;
		CidadeDTO cidadeDTO;
		List<PessoaDTO> pessoas = new ArrayList<PessoaDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return pessoas;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PESSOA ORDER BY NOME";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				pessoaDTO = new PessoaDTO();
				cidadeDTO = new CidadeDTO();
				pessoaDTO.setCodigo(rs.getInt("IDPESSOA"));
				cidadeDTO.setCodigo(rs.getLong("IDCIDADE"));
				pessoaDTO.setCidade(cidadeDTO);
				pessoaDTO.setNome(rs.getString("NOME"));
				pessoaDTO.setNascimento(rs.getString("NASCIMENTO"));
				pessoaDTO.setTelefone(rs.getString("TELEFONE"));
				pessoaDTO.setLogin("LOGIN");
				pessoaDTO.setSenha("SENHA");
				pessoaDTO.setRg("RG");
				pessoaDTO.setCpf(rs.getString("CPF"));
				pessoaDTO.setNivel(rs.getInt("NIVELUSUARIO"));
				

				pessoas.add(pessoaDTO);
				System.out.println(pessoaDTO.getNome()+" Nascimento: " + pessoaDTO.getNascimento());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return pessoas;
	}
	
	public PessoaDTO Login(PessoaDTO pessoaDTO) throws Exception {
		PessoaDTO dto = null;
		
		try
		{
			if(!VerifiqueConexao())
				return dto;

			st = (Statement)conexao.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
			comandoSql =  "SELECT * FROM PESSOA WHERE";
			comandoSql += " LOGIN = '" + pessoaDTO.getLogin() + "'";
			comandoSql += " AND SENHA = '" + pessoaDTO.getSenha() + "'";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				if(rs.getString("login").equals(pessoaDTO.getLogin()) && rs.getString("senha").equals(pessoaDTO.getSenha()))
				{
					dto = new PessoaDTO();
					dto.setCodigo(rs.getInt("IDPESSOA"));
					dto.setNome(rs.getString("NOME"));
					dto.setLogin(rs.getString("LOGIN"));
					dto.setSenha(rs.getString("SENHA"));
					dto.setNivel(rs.getInt("NIVELUSUARIO"));
					
					return dto;     
				}
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return dto;
	}
	
	public ResultSet BuscarPessoaCPFLogin(String CPF, String Login) throws Exception, SQLException {
		try
		{
			if(!VerifiqueConexao())
				return null;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PESSOA WHERE CPF = " + "'" + CPF + "'" + " AND LOGIN = " + "'" + Login + "'";
			
			System.out.println(comandoSql);
			rs = st.executeQuery(comandoSql);
			
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}
		finally{
			System.out.println("DADOS NAO ENCONTRADOS ");
		}

		return rs;
	}	
	
}
