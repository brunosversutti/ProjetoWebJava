package VO;

import java.util.List;

import BUS.CursoBUS;
import DTO.CursoDTO;
import DTO.PessoaDTO;

public class CursoVO {

	private List<CursoDTO> cursos;
	

	public CursoVO()
	{
		CursoBUS cursoBUS = new CursoBUS();

		try {
			List<CursoDTO> cursos = cursoBUS.Listar();
			this.setCursos(cursos);
		} catch (Exception e) {
			this.setCursos(null);
		}
	}

	public List<CursoDTO> getCursos() {
		return cursos;
	}

	public void setCursos(List<CursoDTO> cursos) {
		this.cursos = cursos;
	}

}
