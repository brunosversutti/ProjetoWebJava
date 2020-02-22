package DTO;

import java.io.Serializable;

public class DisciplinaDTO implements Serializable {
	
	private long codigo;
	private String nome;
	private int duracao;
	
	public DisciplinaDTO(){
		
		this.codigo = 0;
		this.nome = "";
		this.duracao = 0;
		
	}
	
	public DisciplinaDTO (long Codigo, String Nome, int Duracao) {
		this.codigo = Codigo;
		this.nome = Nome;
		this.duracao = Duracao;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
}
