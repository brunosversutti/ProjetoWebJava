package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.CidadeDTO;

public class CidadeDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";
	List <CidadeDTO> cidades = new ArrayList<CidadeDTO>();
	private String nomeCidade = "";


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


	public List<CidadeDTO> Listar() throws Exception {
		CidadeDTO cidadeDTO;
		List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return cidades;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE ORDER BY NOMECIDADE";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				cidadeDTO = new CidadeDTO();
				cidadeDTO.setCodigo(rs.getInt("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));

				cidades.add(cidadeDTO);
				System.out.println(cidadeDTO.getCidade());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return cidades;
	}
	
	
	
	public CidadeDTO Pesquisar(int codigo) throws Exception, SQLException {

		CidadeDTO cidadeDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return cidadeDTO;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE WHERE IDCIDADE = " + codigo;
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				cidadeDTO = new CidadeDTO();
				cidadeDTO.setCodigo(rs.getInt("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));
				
				System.out.println(cidadeDTO.getCidade());
			}
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return cidadeDTO;
	}
	
	
	public ResultSet BuscarCidade(String nomeCidade, String UF) throws Exception, SQLException {

//		CidadeDTO cidadeDTO = null;
		String nomeUpper, nomeLower;
		
		nomeLower = nomeCidade.toLowerCase();
		nomeUpper = nomeCidade.toUpperCase();
		
		try
		{
			if(!VerifiqueConexao())
				return null;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE WHERE NOMECIDADE = " +"'" + nomeCidade+ "' OR NOMECIDADE = '"+ nomeLower + "'"+ " OR NOMECIDADE = '"+ nomeUpper +"' " + " AND UF = " + "'" + UF +"'" ;
			
			rs = st.executeQuery(comandoSql);
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return rs;
	}
	
	public ResultSet BuscarCidade(String nomeCidade) throws Exception, SQLException {
		
		try
		{
			if(!VerifiqueConexao())
				return null;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE WHERE NOMECIDADE = " + "'" +nomeCidade + "'";
			
			rs = st.executeQuery(comandoSql);
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return rs;
	}
	
public ResultSet BuscarCidade() throws Exception, SQLException {
		
		try
		{
			if(!VerifiqueConexao())
				return null;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE ORDER BY NOMECIDADE";
			
			rs = st.executeQuery(comandoSql);
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return rs;
	}
	
	
	public List<CidadeDTO> Pesquisar(String NomeCidade) throws Exception {
		CidadeDTO cidadeDTO;
		List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();

		nomeCidade = NomeCidade;
		//CidadeDTO cidadeDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return cidades;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE WHERE NOMECIDADE LIKE " +"'%"+nomeCidade+"%'";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				cidadeDTO = new CidadeDTO();
				cidadeDTO.setCodigo(rs.getInt("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));
				
				cidades.add(cidadeDTO);
				
				System.out.println(cidadeDTO.getCidade());

			}
			
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return cidades;
	}
	
	
	public Long Incluir(CidadeDTO cidadeDTO) throws Exception {
		
		long codigoCidade = 0;
		
		try
		{
			if(!VerifiqueConexao())
				return codigoCidade;

			comandoSql = "INSERT INTO CIDADE(NOMECIDADE,UF) VALUES (?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, cidadeDTO.getCidade());
			pst.setString(2, cidadeDTO.getUf());
			//return (pst.executeUpdate() > 0 ? true : false);
			if(pst.executeUpdate() > 0 ){
				st = (Statement)conexao.createStatement();
				comandoSql = "SELECT MAX(IDCIDADE) FROM ENDERECO";
				rs = st.executeQuery(comandoSql);
				while(rs.next()){
					codigoCidade = (rs.getLong(1));
					cidadeDTO.setCodigo(codigoCidade);
					
					System.out.println(codigoCidade + " = IDCIDADE");
				}
			}
			
			return codigoCidade;
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	public Boolean Alterar(CidadeDTO cidadeDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "UPDATE CIDADE SET NOMECIDADE=?,UF=? WHERE IDCIDADE = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, cidadeDTO.getCidade());
			pst.setString(2, cidadeDTO.getUf());
			pst.setLong(3, cidadeDTO.getCodigo());
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

			comandoSql = "DELETE FROM CIDADE WHERE IDCIDADE = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	public List<CidadeDTO> ListarPorNome(String nomeCidade, String UF) throws Exception {
		CidadeDTO cidadeDTO;
		List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return cidades;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE ORDER BY NOMECIDADE";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				cidadeDTO = new CidadeDTO();
				cidadeDTO.setCodigo(rs.getInt("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));
				
				if((cidadeDTO.getCidade().equals(nomeCidade)) && cidadeDTO.getUf().equals(UF)){
					
					cidades.add(cidadeDTO);
					
				}
				
				System.out.println(cidadeDTO.getCidade());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return cidades;
	}
	
}
