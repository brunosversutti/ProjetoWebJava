package DTO;

import java.io.Serializable;

public class NotaAlunoDTO implements Serializable {

	private double nota;
	private AlunoDTO aluno;
	private AtividadeDTO atividade;
	
	public NotaAlunoDTO(){
		this.nota = 0;
		this.aluno = null;
		this.atividade = null;
		
	}
	
	public NotaAlunoDTO(double Nota, AlunoDTO Aluno, AtividadeDTO Atividade){
		this.nota = Nota;
		this.aluno = Aluno;
		this.atividade = Atividade;
		
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public AlunoDTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}

	public AtividadeDTO getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadeDTO atividade) {
		this.atividade = atividade;
	}
	
}
