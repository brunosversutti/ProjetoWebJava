package Dto;

import java.io.Serializable;

public class ImovelDTO implements Serializable{
	private int idimovel;
	private String endereco;
	private String cep;
	private String preco;
	private String metragem;
	private String quadra;
	private String lote;
	private String situacao;
	
	public ImovelDTO() { 
		this.idimovel = 0;
		this.endereco = "";
		this.cep = "";
		this.preco = "";
		this.metragem = "";
		this.quadra = "";
		this.lote = "";
		this.situacao = "";
	}
	public ImovelDTO(int idimovel, String endereco, String cep, String preco, String metragem, String quadra, String lote, String situacao)
	{
		this.idimovel = idimovel;
		this.endereco = endereco;
		this.cep = cep;
		this.preco = preco;
		this.metragem = metragem;
		this.quadra = quadra;
		this.lote = lote;
		this.situacao = situacao;
	}
	
	public ImovelDTO(String endereco, String cep, String preco, String metragem, String quadra, String lote, String situacao)
	{
		this.endereco = endereco;
		this.cep = cep;
		this.preco = preco;
		this.metragem = metragem;
		this.quadra = quadra;
		this.lote = lote;
		this.situacao = situacao;
	}
	
	public int getIdimovel() {
		return idimovel;
	}
	public void setIdimovel(int idimovel) {
		this.idimovel = idimovel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getMetragem() {
		return metragem;
	}
	public void setMetragem(String metragem) {
		this.metragem = metragem;
	}
	public String getQuadra() {
		return quadra;
	}
	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}	