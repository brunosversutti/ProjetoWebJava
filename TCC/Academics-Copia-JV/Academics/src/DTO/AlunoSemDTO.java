package DTO;

import java.io.Serializable;

public class AlunoSemDTO implements Serializable {

	private long codigo;
	private AlunoDTO aluno;
	private SemestreDTO semestre;
	
	
	
	public AlunoSemDTO(){
		
		this.codigo = 0;
		this.aluno = new AlunoDTO();
		this.semestre = new SemestreDTO();
		
	}
	
	public AlunoSemDTO(long Codigo, AlunoDTO Aluno, SemestreDTO Semestre){
		
		this.codigo = Codigo;
		this.aluno = Aluno;
		this.semestre = Semestre;
		
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public AlunoDTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}

	public SemestreDTO getSemestre() {
		return semestre;
	}

	public void setSemestre(SemestreDTO semestre) {
		this.semestre = semestre;
	}
	
	
	
	
	
}
