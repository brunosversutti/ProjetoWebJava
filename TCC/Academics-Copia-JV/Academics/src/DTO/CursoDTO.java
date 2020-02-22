package DTO;

import java.io.Serializable;

public class CursoDTO implements Serializable {

	private long codigo;
	private ProfSemDTO profSemestre;
	private String nome;
	private int duracao;
	private String titulo;
	private String periodo;
	
	
	public CursoDTO(){	
		
		this.codigo = 0;
		this.profSemestre = new ProfSemDTO();
		this.nome = "";
		this.duracao = 0;
		this.titulo = "";
		this.periodo = "";
	}
	
	
	public CursoDTO(long Codigo, ProfSemDTO ProfSemestre, String Nome, int Duracao,
			String Titulo, String Periodo){
		
		this.codigo = Codigo;
		this.profSemestre = ProfSemestre;
		this.nome = Nome;
		this.duracao = Duracao;
		this.titulo = Titulo;
		this.periodo = Periodo;
		
	}
	

	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public ProfSemDTO getProfSemestre() {
		return profSemestre;
	}


	public void setProfSemestre(ProfSemDTO profSemestre) {
		this.profSemestre = profSemestre;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getDuracao() {
		return duracao;
	}


	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
}
