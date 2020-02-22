package VO;

import java.util.List;

import BUS.ProfSemBUS;
import BUS.ProfessorBUS;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;

public class ProfSemVO {

	private List<ProfSemDTO> professoresSemestre;

	public ProfSemVO()
	{
		ProfSemBUS profSemBUS = new ProfSemBUS();

		try {
			List<ProfSemDTO> professoresSemestre = profSemBUS.Listar();
			this.setProfSemestre(professoresSemestre);
		} catch (Exception e) {
			this.setProfSemestre(null);
		}
	}

	public List<ProfSemDTO> getProfSemestre() {
		return professoresSemestre;
	}

	public void setProfSemestre(List<ProfSemDTO> professoresSemestre) {
		this.professoresSemestre = professoresSemestre;
	}
	
	
}
