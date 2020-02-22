package DTO;
import java.io.Serializable;
import java.util.Date;
public class PessoaDTO implements Serializable {

	private long codigo;
	private CidadeDTO cidade;
	private long endereco;
	private String nome;
	private String nascimento;
	private String telefone;
	private String login;
	private String senha;
	private String rg;
	private String cpf;
	private int nivel;
	
	public PessoaDTO(){
		
		this.codigo = 0;
		this.cidade = new CidadeDTO();
		this.endereco = 0;
		this.nome = "";
		this.nascimento = "";
		this.telefone = "";
		this.login = "";
		this.senha = "";
		this.rg = "";
		this.cpf = "";
		this.nivel = 0;
		
	}
	
	
	
	
	public PessoaDTO(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;

	}
	
	public PessoaDTO (String nome, String login, String senha, int nivel){
		
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.nivel = nivel;
		
	}




	public PessoaDTO (long Codigo, CidadeDTO Cidade, long Endereco, String Nome, String Nascimento, String Telefone,
			String Login, String Senha, String RG, String CPF, int Nivel){
		
		this.codigo = Codigo;
		this.cidade = Cidade;
		this.endereco = Endereco;
		this.nome = Nome;
		this.nascimento = Nascimento;
		this.telefone = Telefone;
		this.login = Login;
		this.senha = Senha;
		this.rg = RG;
		this.cpf = CPF;	
		this.nivel = Nivel;
	}
	

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}

	public long getEndereco() {
		return endereco;
	}

	public void setEndereco(long endereco) {
		this.endereco = endereco;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
