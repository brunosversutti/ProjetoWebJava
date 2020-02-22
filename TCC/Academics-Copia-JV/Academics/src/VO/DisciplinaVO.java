package VO;

import java.util.List;

import BUS.DisciplinaBUS;
import BUS.SemestreBUS;
import DTO.DisciplinaDTO;
import DTO.SemestreDTO;

public class DisciplinaVO {

	private List<DisciplinaDTO> disciplinas;

	public DisciplinaVO()
	{
		DisciplinaBUS disciplinaBUS = new DisciplinaBUS();

		try {
			List<DisciplinaDTO> disciplinas = disciplinaBUS.Listar();
			this.setDisciplinas(disciplinas);
		} catch (Exception e) {
			this.setDisciplinas(null);
		}
	}

	public List<DisciplinaDTO> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<DisciplinaDTO> disciplina) {
		this.disciplinas = disciplina;
	}
	
	
}
