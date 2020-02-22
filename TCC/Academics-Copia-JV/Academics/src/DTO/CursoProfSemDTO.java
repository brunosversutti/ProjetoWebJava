package DTO;

import java.io.Serializable;

public class CursoProfSemDTO implements Serializable {

	private long codigo;
	private CursoDTO curso;
	private ProfSemDTO profSemestre;
	
	
	public CursoProfSemDTO(){
		this.codigo = 0;
		this.curso = new CursoDTO();
		this.profSemestre = new ProfSemDTO();
		
	}
	
	public CursoProfSemDTO(long Codigo, CursoDTO Curso, ProfSemDTO ProfSemestre){
		this.codigo = Codigo;
		this.curso = Curso;
		this.profSemestre = ProfSemestre;
	}
	

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public CursoDTO getCurso() {
		return curso;
	}

	public void setCurso(CursoDTO curso) {
		this.curso = curso;
	}

	public ProfSemDTO getProfSemestre() {
		return profSemestre;
	}

	public void setProfSemestre(ProfSemDTO profSemestre) {
		this.profSemestre = profSemestre;
	}
	
}
