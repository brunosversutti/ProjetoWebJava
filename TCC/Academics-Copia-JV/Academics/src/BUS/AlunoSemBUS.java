package BUS;

import DAO.AlunoSemDAO;
import DTO.AlunoSemDTO;

public class AlunoSemBUS {

	AlunoSemDAO alunoSemDAO = new AlunoSemDAO();
	
	public Boolean Incluir(AlunoSemDTO alunoSemDTO){
		
		try {
			alunoSemDAO.Incluir(alunoSemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
}
