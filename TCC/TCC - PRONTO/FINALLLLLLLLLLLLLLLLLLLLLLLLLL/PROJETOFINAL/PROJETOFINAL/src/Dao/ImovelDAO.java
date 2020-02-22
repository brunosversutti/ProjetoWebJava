package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.ImovelDTO;

public class ImovelDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";

	public Boolean VerifiqueConexaoTeste() throws Exception {
		return true;
	}

	public Boolean VerifiqueConexao() throws Exception {
		try
		{
			conexao = DbConexao.getConexao();
			if(conexao == null)
				return false;
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return true;
	}

	
	
	
	public List<ImovelDTO> Listar() throws Exception {
		ImovelDTO imovelDTO;
		List<ImovelDTO> imoveis = new ArrayList<ImovelDTO>();

		try
		{
			if(!VerifiqueConexao())
				return imoveis;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM IMOVEL ORDER BY ENDERECO";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				imovelDTO = new ImovelDTO();
				imovelDTO.setIdimovel(rs.getInt("idimovel"));
				imovelDTO.setEndereco(rs.getString("endereco"));
				imovelDTO.setCep(rs.getString("cep"));
				imovelDTO.setPreco(rs.getString("preco"));
				imovelDTO.setMetragem(rs.getString("metragem"));
				imovelDTO.setQuadra(rs.getString("quadra"));
				imovelDTO.setLote(rs.getString("lote"));
				imovelDTO.setSituacao(rs.getString("situacao"));

				imoveis.add(imovelDTO);
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return imoveis;
	}

	public ImovelDTO BuscaRegistro(int idimovel) throws Exception, SQLException {

		ImovelDTO imovelDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return imovelDTO;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM IMOVEL WHERE idimovel = " + idimovel;
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				imovelDTO = new ImovelDTO();
				imovelDTO.setIdimovel(rs.getInt("idimovel"));
				imovelDTO.setEndereco(rs.getString("endereco"));
				imovelDTO.setCep(rs.getString("cep"));
				imovelDTO.setPreco(rs.getString("preco"));
				imovelDTO.setMetragem(rs.getString("metragem"));
				imovelDTO.setQuadra(rs.getString("quadra"));
				imovelDTO.setLote(rs.getString("lote"));
				imovelDTO.setSituacao(rs.getString("situacao"));
			}
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return imovelDTO;
	}

	public Boolean Incluir(ImovelDTO imovelDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO IMOVEL(ENDERECO,CEP,PRECO,METRAGEM,QUADRA,LOTE,SITUACAO) VALUES (?,?,?,?,?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, imovelDTO.getEndereco());
			pst.setString(2, imovelDTO.getCep());
			pst.setString(3, imovelDTO.getPreco());
			pst.setString(4, imovelDTO.getMetragem());
			pst.setString(5, imovelDTO.getQuadra());
			pst.setString(6, imovelDTO.getLote());
			pst.setString(7, imovelDTO.getSituacao());
			return (pst.executeUpdate() > 0 ? true : false);
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}

	public Boolean Alterar(ImovelDTO imovelDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "UPDATE IMOVEL SET ENDERECO=?,CEP=?, PRECO=?, METRAGEM=?, QUADRA=?, LOTE=?, SITUACAO=? WHERE idimovel = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, imovelDTO.getEndereco());
			pst.setString(2, imovelDTO.getCep());
			pst.setString(3, imovelDTO.getPreco());
			pst.setString(4, imovelDTO.getMetragem());
			pst.setString(5, imovelDTO.getQuadra());
			pst.setString(6, imovelDTO.getLote());
			pst.setString(7, imovelDTO.getSituacao());
			pst.setInt(8, imovelDTO.getIdimovel());
			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}

	public Boolean Excluir(int idimovel) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "DELETE FROM IMOVEL WHERE idimovel = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, idimovel);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	public ResultSet Relatorio(String filtro) throws Exception {
		try
		{
		    if(!VerifiqueConexao())
				return null;
			
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT idimovel, ENDERECO, CEP, PRECO, METRAGEM, QUADRA, LOTE, SITUACAO FROM IMOVEL";
			if(!filtro.isEmpty())
				comandoSql += " WHERE " + filtro;
			comandoSql +=  " ORDER BY ENDERECO";
			rs = st.executeQuery(comandoSql);
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return rs;
	}
}
