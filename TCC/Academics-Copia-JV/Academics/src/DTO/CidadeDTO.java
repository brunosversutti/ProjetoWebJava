package DTO;
import java.io.Serializable;


public class CidadeDTO implements Serializable {
	
	private long codigo;
	private String cidade;
	private String uf;
	
	
	public CidadeDTO(){
		
		this.codigo = 0;
		this.cidade = "";
		this.uf = "";
		
	}
	
	
	public CidadeDTO(long Codigo, String Cidade, String UF){
		
		this.codigo = Codigo;
		this.cidade = Cidade;
		this.uf = UF;
		
	}
	
	
	public CidadeDTO(String Cidade, String UF){
		
		this.cidade = Cidade;
		this.uf = UF;
	}


	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	
	
}
