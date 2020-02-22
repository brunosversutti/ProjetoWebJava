package DTO;

import java.io.Serializable;
import java.util.Date;

public class SemestreDTO implements Serializable {

	private long codigo;
	private int ano;
	private String periodo;
	private String status;
	
	
	public SemestreDTO(){
		this.codigo = 0;
		this.ano = 0;
		this.periodo = "";
		this.status = "";
	}
	
	
	public SemestreDTO (long Codigo, int Ano, String Periodo, String Status){
		this.codigo = Codigo;
		this.ano = Ano;
		this.periodo = Periodo;
		this.status = Status;
	}
	

	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
		
}
