package BUS;

import java.sql.ResultSet;
import java.util.List;

import sun.util.logging.resources.logging;
import DAO.CidadeDAO;
import DAO.PessoaDAO;
import DTO.CidadeDTO;
import DTO.PessoaDTO;

public class PessoaBUS {

	private PessoaDTO pessoaDTO; //= new PessoaDTO();
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private CidadeDAO cidadeDAO = new CidadeDAO();
	private CidadeDTO cidadeDTO; //= new CidadeDTO();


	public PessoaDTO Login(String usuario, String senha) throws Exception {
		try
		{
			pessoaDTO = new PessoaDTO("", usuario, senha);
			System.out.println("usuario bus = " + usuario + senha);
			return pessoaDAO.Login(pessoaDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}


	public List<PessoaDTO> Listar() throws Exception {
		List<PessoaDTO> pessoas = null;

		try
		{
			if(!pessoaDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			pessoas = pessoaDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return pessoas;
	}


	public PessoaDTO Pesquisar(int codigo) throws Exception {
		try
		{
			return pessoaDAO.BuscaRegistro(codigo);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	public Boolean Incluir(PessoaDTO pessoaDTO, CidadeDTO cidadeDTO) throws Exception {
		
		try{
			ResultSet rs = pessoaDAO.BuscarPessoaCPFLogin(pessoaDTO.getCpf(), pessoaDTO.getLogin());
			
			
			if(rs.next() == false){
								
				pessoaDAO.Incluir(pessoaDTO, cidadeDTO);
				
			}
			else{
				
				return false;
				
			}
			
		}
		catch (Exception e){
			throw new Exception(e.getMessage());
		}
		return true;
	}

	public Boolean Alterar(PessoaDTO pessoaDTO) throws Exception {
		try
		{
			pessoaDAO.Alterar(pessoaDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}

	public Boolean Excluir(int codigo) throws Exception {
		try
		{
			return pessoaDAO.Excluir(codigo);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	public ResultSet BuscarPessoa(String Login, String Cpf) throws Exception{

		try{
			return pessoaDAO.BuscarPessoaCPFLogin(Cpf, Login);
		}catch (Exception e)
		{
			throw new Exception(e);
		}
	}

}
