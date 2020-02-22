package Business;

import java.util.List;

import Dao.UsuarioDAO;
import Dto.UsuarioDTO;

public class UsuarioBusiness {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private UsuarioDTO usuarioDTO;

	public UsuarioDTO Login(String login, String senha) throws Exception {
		try
		{
			usuarioDTO = new UsuarioDTO(login,senha);
			return usuarioDAO.Login(usuarioDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	public List<UsuarioDTO> Listar() throws Exception {
		List<UsuarioDTO> usuarios = null;

		try
		{
			if(!usuarioDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			usuarios = usuarioDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return usuarios;
	}
	
	public UsuarioDTO BuscaRegistro(int idusuario) throws Exception {
		try
		{
			return usuarioDAO.BuscaRegistro(idusuario);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	public Boolean Incluir(UsuarioDTO usuarioDTO) throws Exception {
		try
		{
			usuarioDAO.Incluir(usuarioDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}

	public Boolean Alterar(UsuarioDTO usuarioDTO) throws Exception {
		try
		{
			usuarioDAO.Alterar(usuarioDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}
	
	public Boolean Excluir(int idusuario) throws Exception {
		try
		{
			return usuarioDAO.Excluir(idusuario);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

}
