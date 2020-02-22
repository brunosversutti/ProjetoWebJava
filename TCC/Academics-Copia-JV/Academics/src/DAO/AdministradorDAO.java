package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.AdministradorDTO;
import DTO.CursoDTO;
import DTO.PessoaDTO;

public class AdministradorDAO {


	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";
	List <AdministradorDTO> administradores = new ArrayList<AdministradorDTO>();
	
	
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
	
	public Boolean Incluir(AdministradorDTO administradorDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO ADMINISTRADOR(IDPESSOA, CARGO)"
					+ " VALUES (?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setLong(1, administradorDTO.getPessoa().getCodigo());
			pst.setString(2, administradorDTO.getCargo());
			return (pst.executeUpdate() > 0 ? true : false);
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	
	public Boolean Alterar(AdministradorDTO administradorDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;
			comandoSql = "UPDATE ADMINISTRADOR SET CARGO=?"
					+ " WHERE IDPESSOA = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			
			pst.setString(1, administradorDTO.getCargo());
			//pst.setLong(2, administradorDTO.getPessoa().getCodigo());
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

			comandoSql = "DELETE FROM ADMINISTRADOR WHERE IDADMINISTRADOR = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}
	
	
	public List<AdministradorDTO> Listar() throws Exception {
		AdministradorDTO administradorDTO;
		PessoaDTO pessoaDTO;
		List<AdministradorDTO> administradores = new ArrayList<AdministradorDTO>();
		
		try
		{
			if(!VerifiqueConexao())
				return administradores;

			Statement st = (Statement)conexao.createStatement();
			comandoSql = "SELECT * FROM PESSOA, ADMINISTRADOR WHERE PESSOA.IDPESSOA = ADMINISTRADOR.IDPESSOA ORDER BY PESSOA.NOME";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				administradorDTO = new AdministradorDTO();
				pessoaDTO = new PessoaDTO();
				administradorDTO.setCodigo(rs.getLong("IDADMINISTRADOR"));
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				pessoaDTO.setNome(rs.getString("NOME"));
				administradorDTO.setCargo(rs.getString("CARGO"));
				administradorDTO.setPessoa(pessoaDTO);
				

				administradores.add(administradorDTO);
				System.out.println(administradorDTO.getCodigo()+" " + administradorDTO.getCargo()+" "
						+ administradorDTO.getPessoa().getNome());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return administradores;
	}
	
	public ResultSet BuscarAdministrador() throws Exception{
		
		try
		{
			if(!VerifiqueConexao())
				return null;
			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM PESSOA, ADMINISTRADOR WHERE PESSOA.IDPESSOA = ADMINISTRADOR.IDPESSOA ORDER BY PESSOA.NOME";
			
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