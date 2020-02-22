package DAO;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.CidadeDTO;
import DTO.PessoaDTO;
import DTO.EnderecoDTO;


public class EnderecoDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";
	List <PessoaDTO> cidades = new ArrayList<PessoaDTO>();
	private String nomePessoa = "";
	private CidadeDTO cidadeDTO;
	
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
	
	
	public Long Incluir(EnderecoDTO enderecoDTO) throws Exception {
		try
		{
			long codigoEndereco = 0;
			
			if(!VerifiqueConexao())
				return codigoEndereco;

			comandoSql = "INSERT INTO ENDERECO(IDCIDADE,IDPESSOA,LOGRADOURO,NUMERO,COMPLEMENTO,BAIRRO,CEP)"
					+ " VALUES (?,?,?,?,?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, enderecoDTO.getCidade().getCodigo());
			pst.setLong(2, enderecoDTO.getPessoa().getCodigo());
			pst.setString(3, enderecoDTO.getLogradouro());
			pst.setInt(4, enderecoDTO.getNumero());
			pst.setString(5, enderecoDTO.getComplemento());
			pst.setString(6, enderecoDTO.getBairro());
			pst.setDouble(7, enderecoDTO.getCep());
			
			//return (pst.executeUpdate() > 0 ? true : false);
			
			if(pst.executeUpdate() > 0 ){
				st = (Statement)conexao.createStatement();
				comandoSql = "SELECT MAX(IDENDERECO) FROM ENDERECO";
				rs = st.executeQuery(comandoSql);
				while(rs.next()){
					codigoEndereco = (rs.getLong(1));
					System.out.println(codigoEndereco + " = IDENDERECO");
				}
			}
			
			return codigoEndereco;		
			
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public Boolean Alterar(EnderecoDTO enderecoDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			
			comandoSql = "UPDATE ENDERECO SET IDCIDADE=?,IDPESSOA=?,LOGRADOURO=?,NUMERO=?,COMPLEMENTO=?,BAIRRO=?,CEP=?"
					+ " WHERE IDPESSOA = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			
			pst.setLong(1, enderecoDTO.getCidade().getCodigo());
			pst.setLong(2, enderecoDTO.getPessoa().getCodigo());
			pst.setString(3, enderecoDTO.getLogradouro());
			pst.setInt(4, enderecoDTO.getNumero());
			pst.setString(5, enderecoDTO.getComplemento());
			pst.setString(6, enderecoDTO.getBairro());
			pst.setInt(7, enderecoDTO.getCep());
			pst.setLong(8, enderecoDTO.getPessoa().getCodigo());
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

			comandoSql = "DELETE FROM ENDERECO WHERE IDENDERECO = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	public List<EnderecoDTO> Pesquisar(String NomePessoa) throws Exception {
		PessoaDTO pessoaDTO;
		EnderecoDTO enderecoDTO;
		List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();

		nomePessoa = NomePessoa;
		//CidadeDTO cidadeDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return enderecos;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PESSOA, ENDERECO WHERE PESSOA.NOME LIKE " +"'%"+nomePessoa+"%'";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				pessoaDTO = new PessoaDTO();
				enderecoDTO = new EnderecoDTO();
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
				enderecoDTO.setCodigo(rs.getLong("IDENDERECO"));
				enderecoDTO.setLogradouro(rs.getString("LOGRADOURO"));
				enderecoDTO.setNumero(rs.getInt("NUMERO"));
				enderecoDTO.setComplemento(rs.getString("COMPLEMENTO"));
				enderecoDTO.setBairro(rs.getString("BAIRRO"));
				enderecoDTO.setCep(rs.getInt("CEP"));
				
				cidades.add(pessoaDTO);
				
				System.out.println(pessoaDTO.getNome()+" "+ enderecoDTO.getLogradouro()+" " + enderecoDTO.getNumero()+" " + enderecoDTO.getBairro());

			}
			
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return enderecos;
	}
	
	
	
	
	
	public List<EnderecoDTO> Pesquisar(int codigoPessoa) throws Exception {
		PessoaDTO pessoaDTO;
		EnderecoDTO enderecoDTO;
		CidadeDTO cidadeDTO;
		List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();

		//CidadeDTO cidadeDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return enderecos;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PESSOA, ENDERECO WHERE PESSOA.IDPESSOA = " + codigoPessoa + "AND ENDERECO.IDPESSOA = " + codigoPessoa;
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				pessoaDTO = new PessoaDTO();
				enderecoDTO = new EnderecoDTO();
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
				enderecoDTO.setCodigo(rs.getLong("IDENDERECO"));
				enderecoDTO.setLogradouro(rs.getString("LOGRADOURO"));
				enderecoDTO.setNumero(rs.getInt("NUMERO"));
				enderecoDTO.setComplemento(rs.getString("COMPLEMENTO"));
				enderecoDTO.setBairro(rs.getString("BAIRRO"));
				enderecoDTO.setCep(rs.getInt("CEP"));
				
				cidades.add(pessoaDTO);
				
				System.out.println(pessoaDTO.getNome()+" "+ enderecoDTO.getLogradouro()+" " + enderecoDTO.getNumero()+" " + enderecoDTO.getBairro());

			}
			
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return enderecos;
	}
	
	
	
	public ResultSet BuscarEnderecos(PessoaDTO pessoaDTO) throws Exception, SQLException {
		try
		{
			if(!VerifiqueConexao())
				return null;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE, ENDERECO WHERE ENDERECO.PESSOA = " + "' "+ pessoaDTO.getCodigo() + "'";
			
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
