package BUS;

import java.util.List;

import DAO.AtividadeDAO;
import DTO.AtividadeDTO;
import DTO.CursoDTO;

public class AtividadeBUS {

	AtividadeDAO atividadeDAO = new AtividadeDAO();
	
	
	public Boolean Incluir (AtividadeDTO atividadeDTO)throws Exception{
		
		try{
			
			atividadeDAO.Incluir(atividadeDTO);
			
		}catch (Exception e){
			
			throw new Exception(e.getMessage());
			
		}
		
	return true;
		
	}
	
	public List<AtividadeDTO> Listar() throws Exception {
		List<AtividadeDTO> atividades = null;

		try
		{
			if(!atividadeDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			atividades = atividadeDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return atividades;
	} 
	
}
