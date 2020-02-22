package BUS;

import DAO.AdministradorDAO;
import DTO.AdministradorDTO;

public class AdministradorBUS {

	AdministradorDAO adminDAO = new AdministradorDAO();
	
	
	
	public Boolean Incluir(AdministradorDTO administradorDTO) throws Exception {
		try
		{
			adminDAO.Incluir(administradorDTO);
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}
	
}
