package BUS;

import java.sql.ResultSet;

import DTO.AlunoDTO;
import DTO.EnderecoDTO;
import DTO.PessoaDTO;
import DAO.EnderecoDAO;


public class EnderecoBUS {

	private EnderecoDTO enderecoDTO;
	
	
	
	EnderecoDAO enderecoDAO = new EnderecoDAO();
	
	public Boolean Incluir(EnderecoDTO enderecoDTO) throws Exception {
		try
		{
			enderecoDAO.Incluir(enderecoDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}
	
	public ResultSet BuscarEndereco(PessoaDTO pessoaDTO) throws Exception{

		try{
			return enderecoDAO.BuscarEnderecos(pessoaDTO);
		}catch (Exception e)
		{
			throw new Exception(e);
		}
	}

}
