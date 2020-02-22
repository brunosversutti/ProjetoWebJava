package BUS;

import java.sql.ResultSet;
import java.util.List;

import DTO.CidadeDTO;
import DAO.CidadeDAO;

public class CidadeBUS {
	private CidadeDAO cidadeDAO = new CidadeDAO();
	private CidadeDTO cidadeDTO = new CidadeDTO();

	public List<CidadeDTO> Listar() throws Exception {
		List<CidadeDTO> cidades = null;

		try
		{
			if(!cidadeDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			cidades = cidadeDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return cidades;
	}

	public CidadeDTO BuscaRegistro(int codigo) throws Exception {
		try
		{
			return cidadeDAO.Pesquisar(codigo);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	public Boolean Incluir(String nomeCidade, String UF) throws Exception {
		try
		{
			ResultSet rs = cidadeDAO.BuscarCidade(nomeCidade, UF);


			if(rs.next() == false){
				cidadeDTO.setCidade(nomeCidade);
				cidadeDTO.setUf(UF);
				cidadeDAO.Incluir(cidadeDTO);

			}
			else while(rs.next()){
				cidadeDTO.setCodigo(rs.getLong("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));

			}

		} catch (Exception e)

		{
			throw new Exception(e.getMessage());
		}

		return true;
	}

	public Boolean Alterar(CidadeDTO cidadeDTO) throws Exception {
		try
		{
			cidadeDAO.Alterar(cidadeDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}		
		return true;
	}

	public Boolean Excluir(long codigo) throws Exception {
		try
		{
			return cidadeDAO.Excluir(codigo);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}


	public ResultSet BuscarCidade (String nomeCidade) throws Exception{

		try{
			return cidadeDAO.BuscarCidade(nomeCidade);
		}catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}

	}

	public ResultSet BuscarCidade(String nomeCidade, String UF) throws Exception{

		try{
			return cidadeDAO.BuscarCidade(nomeCidade, UF);
		}catch (Exception e)
		{
			throw new Exception(e);
		}
	}



}
