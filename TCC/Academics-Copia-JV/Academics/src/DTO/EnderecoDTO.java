package DTO;

import java.io.Serializable;

public class EnderecoDTO implements Serializable {

	private long codigo;
	private CidadeDTO cidade;
	private PessoaDTO pessoa;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private int cep;
	
	
	public EnderecoDTO(){
		this.codigo = 0;
		this.cidade = new CidadeDTO();
		this.pessoa = new PessoaDTO();
		this.logradouro = "";
		this.numero = 0;
		this.complemento = "";
		this.bairro = "";
		this.cep = 0;
		
	}
	
	public EnderecoDTO(long Codigo,CidadeDTO Cidade,PessoaDTO Pessoa, String Logradouro, int Numero, String Complemento, 
			String Bairro, int CEP){
		this.codigo = Codigo;
		this.cidade = Cidade;
		this.pessoa = Pessoa;
		this.logradouro = Logradouro;
		this.numero = Numero;
		this.complemento = Complemento;
		this.bairro = Bairro;
		this.cep = CEP;
	}
	
	
	public EnderecoDTO(long Codigo,CidadeDTO Cidade,PessoaDTO Pessoa, String Logradouro, int Numero, 
			String Bairro, int CEP){
		this.codigo = Codigo;
		this.cidade = Cidade;
		this.pessoa = Pessoa;
		this.logradouro = Logradouro;
		this.numero = Numero;
		this.bairro = Bairro;
		this.cep = CEP;
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

	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}
}
