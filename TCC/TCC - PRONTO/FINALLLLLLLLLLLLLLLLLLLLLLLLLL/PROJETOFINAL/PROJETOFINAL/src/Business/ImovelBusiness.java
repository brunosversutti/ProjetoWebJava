package Business;

import java.sql.ResultSet;
import java.util.List;

import Dao.ImovelDAO;
import Dto.ImovelDTO;

public class ImovelBusiness {

	private ImovelDAO imovelDAO = new ImovelDAO();

	public List<ImovelDTO> Listar() throws Exception {
		List<ImovelDTO> imoveis = null;

		try
		{
			if(!imovelDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			imoveis = imovelDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return imoveis;
	}
	
	public ImovelDTO BuscaRegistro(int idimovel) throws Exception {
		try
		{
			return imovelDAO.BuscaRegistro(idimovel);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	public Boolean Incluir(ImovelDTO imovelDTO) throws Exception {
		try
		{
			imovelDAO.Incluir(imovelDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}

	public Boolean Alterar(ImovelDTO imovelDTO) throws Exception {
		try
		{
			imovelDAO.Alterar(imovelDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}
	
	public Boolean Excluir(int idimovel) throws Exception {
		try
		{
			return imovelDAO.Excluir(idimovel);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	public ResultSet Relatorio(String filtro) throws Exception {
		ResultSet rsImovel;
		
		try
		{
			rsImovel = imovelDAO.Relatorio(filtro);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return rsImovel;
	}
	
}
