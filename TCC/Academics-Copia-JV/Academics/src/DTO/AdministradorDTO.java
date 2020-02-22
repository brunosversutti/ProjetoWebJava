package DTO;
import java.io.Serializable;


public class AdministradorDTO extends PessoaDTO implements Serializable {

	private long codigo;
	private String cargo;
	private PessoaDTO pessoa;
	
	
	public AdministradorDTO(){
		
		this.codigo = 0;
		this.cargo = "";
		this.pessoa = new PessoaDTO();
	}
	
	public AdministradorDTO(long Codigo, String Cargo, PessoaDTO Pessoa){
		
		this.codigo = Codigo;
		this.cargo = Cargo;
		this.pessoa = Pessoa;
	}

	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	
}
