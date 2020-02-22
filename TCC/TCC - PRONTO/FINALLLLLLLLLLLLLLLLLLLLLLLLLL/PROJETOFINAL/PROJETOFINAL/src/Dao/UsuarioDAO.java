package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.UsuarioDTO;

public class UsuarioDAO {
	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";

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


	public UsuarioDTO Login(UsuarioDTO usuarioDTO) throws Exception {
		UsuarioDTO dto = null;
		
		try
		{
			if(!VerifiqueConexao())
				return dto;

			st = (Statement)conexao.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
			comandoSql =  "SELECT * FROM USUARIO WHERE";
			comandoSql += " LOGIN = '" + usuarioDTO.getLogin() + "'";
			comandoSql += " AND SENHA = '" + usuarioDTO.getSenha() + "'";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				if(rs.getString("login").equals(usuarioDTO.getLogin()) && rs.getString("senha").equals(usuarioDTO.getSenha()))
				{
					dto = new UsuarioDTO();
					dto.setIdusuario(rs.getInt("idusuario"));
					dto.setLogin(rs.getString("login"));
					dto.setSenha(rs.getString("senha"));	
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

	public List<UsuarioDTO> Listar() throws Exception {
		UsuarioDTO usuarioDTO;
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();

		try
		{
			if(!VerifiqueConexao())
				return usuarios;
			
			Statement st = (Statement)conexao.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
			comandoSql =  "SELECT * FROM USUARIO ORDER BY NOME";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				usuarioDTO = new UsuarioDTO();
				usuarioDTO.setIdusuario(rs.getInt("idusuario"));
				usuarioDTO.setEmail(rs.getString("email"));
				usuarioDTO.setNome(rs.getString("nome"));
				usuarioDTO.setCpf(rs.getString("cpf"));
				usuarioDTO.setEndereco(rs.getString("endereco"));
				usuarioDTO.setTelefone(rs.getString("telefone"));
				usuarioDTO.setDatanascimento(rs.getString("datanascimento"));
				usuarioDTO.setLogin(rs.getString("login"));
				
				
				
				
				

				usuarios.add(usuarioDTO);
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return usuarios;
	}

	public UsuarioDTO BuscaRegistro(int idusuario) throws Exception, SQLException {

		UsuarioDTO usuarioDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return usuarioDTO;
			
			Statement st = (Statement)conexao.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
			comandoSql =  "SELECT * FROM USUARIO WHERE IDUSUARIO = " + idusuario;
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				usuarioDTO = new UsuarioDTO();
				
				usuarioDTO.setIdusuario(rs.getInt("idusuario"));
				usuarioDTO.setEmail(rs.getString("email"));
				usuarioDTO.setNome(rs.getString("nome"));
				usuarioDTO.setCpf(rs.getString("cpf"));
				usuarioDTO.setEndereco(rs.getString("endereco"));
				usuarioDTO.setTelefone(rs.getString("telefone"));
				usuarioDTO.setDatanascimento(rs.getString("datanascimento"));
				usuarioDTO.setLogin(rs.getString("login"));
				usuarioDTO.setSenha(rs.getString("senha"));
			}
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return usuarioDTO;
	}

	public Boolean Incluir(UsuarioDTO usuarioDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO USUARIO(NOME,LOGIN,SENHA,EMAIL,CPF,ENDERECO,TELEFONE,DATA_NASCIMENTO) VALUES (?,?,?,?,?,?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, usuarioDTO.getNome());
			pst.setString(2, usuarioDTO.getLogin());
			pst.setString(3, usuarioDTO.getSenha());
			pst.setString(4, usuarioDTO.getEmail());
			pst.setString(5, usuarioDTO.getCpf());
			pst.setString(6, usuarioDTO.getEndereco());
			pst.setString(7, usuarioDTO.getTelefone());
			pst.setString(8, usuarioDTO.getDatanascimento());
			
			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}

	public Boolean Alterar(UsuarioDTO usuarioDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "UPDATE USUARIO SET EMAIL=?,NOME=?,CPF=?,ENDERECO=?,TELEFONE=?,DATA_NASCIMENTO=?,LOGIN=?,SENHA=? WHERE IDUSUARIO = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, usuarioDTO.getEmail());
			pst.setString(2, usuarioDTO.getNome());
			pst.setString(3, usuarioDTO.getCpf());
			pst.setString(4, usuarioDTO.getEndereco());
			pst.setString(5, usuarioDTO.getTelefone());
			pst.setString(6, usuarioDTO.getDatanascimento());
			pst.setString(7, usuarioDTO.getLogin());
			pst.setString(8, usuarioDTO.getSenha());
			pst.setInt(9, usuarioDTO.getIdusuario());
			
			
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

			comandoSql = "DELETE FROM USUARIO WHERE CODIGO = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, codigo);
			return (pst.executeUpdate() > 0?true:false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}


}
