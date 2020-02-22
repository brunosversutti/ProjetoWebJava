package VO;

import java.util.List;

import BUS.CursoBUS;
import BUS.SemestreBUS;
import DTO.CursoDTO;
import DTO.SemestreDTO;

public class SemestreVO {

	private List<SemestreDTO> semestres;

	public SemestreVO()
	{
		SemestreBUS semestreBUS = new SemestreBUS();

		try {
			List<SemestreDTO> semestres = semestreBUS.Listar();
			this.setSemestres(semestres);
		} catch (Exception e) {
			this.setSemestres(null);
		}
	}

	public List<SemestreDTO> getSemestre() {
		return semestres;
	}

	public void setSemestres(List<SemestreDTO> semestre) {
		this.semestres = semestre;
	}
	
	
}
