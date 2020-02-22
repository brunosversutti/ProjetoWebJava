package BUS;

import java.util.List;

import DAO.ProfessorDAO;
import DTO.CursoDTO;
import DTO.ProfessorDTO;

public class ProfessorBUS {

	ProfessorDAO professorDAO = new ProfessorDAO();
	
	
	public Boolean Incluir(ProfessorDTO professorDTO) throws Exception {
		try
		{
			professorDAO.Incluir(professorDTO);
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}
	
	public List<ProfessorDTO> Listar() throws Exception {
		List<ProfessorDTO> professores = null;

		try
		{
			if(!professorDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			professores = professorDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return professores;
	}
	
	
}
