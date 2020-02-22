package VO;

import java.util.List;

import BUS.ProfessorBUS;
import DTO.ProfessorDTO;



public class ProfessorVO {

	private List<ProfessorDTO> professores;

	public ProfessorVO()
	{
		ProfessorBUS professorBUS = new ProfessorBUS();

		try {
			List<ProfessorDTO> professores = professorBUS.Listar();
			this.setProfessor(professores);
		} catch (Exception e) {
			this.setProfessor(null);
		}
	}

	public List<ProfessorDTO> getProfessor() {
		return professores;
	}

	public void setProfessor(List<ProfessorDTO> professores) {
		this.professores = professores;
	}
	
	
	
	
}
