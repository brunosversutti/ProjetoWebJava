package DTO;

import java.io.Serializable;

public class ItensDisciplinaDTO implements Serializable {
	
	private long codigo;
	private DisciplinaDTO disciplina;
	private CursoProfSemDTO cursoprofsem;
	
	public ItensDisciplinaDTO(){
		this.codigo = 0;
		this.disciplina = new DisciplinaDTO();
		this.cursoprofsem = new CursoProfSemDTO();
	}
	
	public ItensDisciplinaDTO(long Codigo, DisciplinaDTO Disciplina, CursoProfSemDTO CursoProfSemestre){
		this.codigo = Codigo;
		this.disciplina = Disciplina;
		this.cursoprofsem = CursoProfSemestre;
		
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public DisciplinaDTO getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaDTO disciplina) {
		this.disciplina = disciplina;
	}

	public CursoProfSemDTO getCursoprofsem() {
		return cursoprofsem;
	}

	public void setCursoprofsem(CursoProfSemDTO cursoprofsem) {
		this.cursoprofsem = cursoprofsem;
	}
}
