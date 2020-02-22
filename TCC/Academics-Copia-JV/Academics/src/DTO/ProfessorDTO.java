package DTO;

import java.io.Serializable;

public class ProfessorDTO extends PessoaDTO implements Serializable  {

	private PessoaDTO pessoa;
	private long codigo;
	private String titulo;
	private String especialidade;
	
	
	public ProfessorDTO(){
		
		this.codigo = 0;
		this.pessoa = new PessoaDTO();
		this.titulo = "";
		this.especialidade = "";
	
	}
	
	
	public ProfessorDTO(long Codigo,PessoaDTO Pessoa, String Titulo, String Especialidade){
		this.codigo = Codigo;
		this.pessoa = Pessoa;
		this.titulo = Titulo;
		this.especialidade = Especialidade;
	
	}
	


	public long getCodigo() {
		return codigo;
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


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
}



