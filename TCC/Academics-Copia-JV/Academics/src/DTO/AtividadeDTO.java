package DTO;

import java.io.Serializable;

public class AtividadeDTO implements Serializable {

	private long codigo;
	private String nome;
	private int tipo;
	private double nota;
	private ItensDisciplinaDTO itenDisciplina;
	
	public AtividadeDTO(){
		this.codigo = 0;
		this.nome = "";
		this.tipo = 0;
		this.nota = 0;
		this.itenDisciplina = new ItensDisciplinaDTO();
	
	}
	
	public AtividadeDTO(long Codigo, String Nome, int Tipo, double Nota, ItensDisciplinaDTO ItenDisciplina){
		this.codigo = Codigo;
		this.nome = Nome;
		this.tipo = Tipo;
		this.nota = Nota;
		this.itenDisciplina = ItenDisciplina;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public ItensDisciplinaDTO getItenDisciplina() {
		return itenDisciplina;
	}

	public void setItenDisciplina(ItensDisciplinaDTO itenDisciplina) {
		this.itenDisciplina = itenDisciplina;
	}
	
	
	
	
	
}
