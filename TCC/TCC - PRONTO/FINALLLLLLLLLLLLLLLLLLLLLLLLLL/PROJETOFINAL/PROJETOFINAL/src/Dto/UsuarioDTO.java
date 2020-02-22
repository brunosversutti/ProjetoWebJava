package Dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	private int idusuario;
	private String nome;
	private String login;
	private String senha;
	private String cpf;
	private String telefone;
	private String datanascimento;
	private String endereco;
	private String email;
	
	public UsuarioDTO() { 
		this.idusuario = 0;
		this.nome = "";
		this.login = "";
		this.senha = "";
		this.cpf = "";
		this.telefone = "";
		this.datanascimento = "";
		this.endereco = "";
		this.email = "";
		
	}
	
	public UsuarioDTO(String nome, String login, String senha, String cpf, String telefone, String datanascimento, String endereco, String email)
	{
		
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
		this.datanascimento = datanascimento;
		this.endereco = endereco;
		this.email = email;
	}
	
	public UsuarioDTO(String login, String senha)
	{
		this.login = login;
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
}
