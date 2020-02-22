package DTO;

import java.io.Serializable;

public class AlunoDTO extends PessoaDTO implements Serializable {

	private long codigo;
	private PessoaDTO pessoa;
	private int rA;
	private int situacao;
	private SemestreDTO semestre;
	private CursoDTO curso;
	
	
	public AlunoDTO(){
		this.codigo = 0;
		this.pessoa = new PessoaDTO();
		this.rA = 0;
		this.situacao = 0;
		this.semestre = new SemestreDTO();
		this.curso = new CursoDTO();
	}
	
	public AlunoDTO(long Codigo, PessoaDTO Pessoa, int RA, int Situacao, SemestreDTO Semestre, CursoDTO Curso){
		this.codigo = Codigo;
		this.pessoa = Pessoa;
		this.rA = RA;
		this.situacao = Situacao;
		this.semestre = Semestre;
		this.curso = Curso;
	}
	
	

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	
	public long getCodigo() {
		return codigo;
	}
	

	public int getrA() {
		return rA;
	}

	public void setrA(int rA) {
		this.rA = rA;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public SemestreDTO getSemestre() {
		return semestre;
	}

	public void setSemestre(SemestreDTO semestre) {
		this.semestre = semestre;
	}

	public CursoDTO getCurso() {
		return curso;
	}

	public void setCurso(CursoDTO curso) {
		this.curso = curso;
	}
	
}
