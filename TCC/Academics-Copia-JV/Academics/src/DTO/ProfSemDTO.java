package DTO;

import java.io.Serializable;


public class ProfSemDTO implements Serializable {

	private long codigo;
	private ProfessorDTO professor;
	private SemestreDTO semestre;
	
	
	public ProfSemDTO(){
		this.codigo = 0;
		this.professor = new ProfessorDTO();
		this.semestre = new SemestreDTO();
		
	}
	
	public ProfSemDTO(long Codigo, ProfessorDTO Professor, SemestreDTO Semestre){
		
		this.codigo = Codigo;
		this.professor = Professor;
		this.semestre = Semestre;
		
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public ProfessorDTO getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorDTO professor) {
		this.professor = professor;
	}

	public SemestreDTO getSemestre() {
		return semestre;
	}

	public void setSemestre(SemestreDTO semestre) {
		this.semestre = semestre;
	}
}
