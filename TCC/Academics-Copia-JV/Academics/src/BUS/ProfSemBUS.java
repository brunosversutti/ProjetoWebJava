package BUS;

import java.sql.ResultSet;
import java.util.List;

import DTO.ProfSemDTO;
import DTO.ProfessorDTO;
import DAO.ProfSemDAO;

public class ProfSemBUS {

	ProfSemDAO profSemDAO = new ProfSemDAO();

	public Boolean Incluir(ProfSemDTO profSemDTO){

		try{

			profSemDAO.Incluir(profSemDTO);

		}catch(Exception e){

			System.out.println("ERRO NA EXECUCAO DO PROCESSO" + e.getMessage());
		}

		return true;

	}
	
	
	public List<ProfSemDTO> Listar() throws Exception {
		List<ProfSemDTO> professoresSemestre = null;

		try
		{
			if(!profSemDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			professoresSemestre = profSemDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return professoresSemestre;
	}
	



}
