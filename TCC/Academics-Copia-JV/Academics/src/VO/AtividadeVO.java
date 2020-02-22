package VO;

import java.util.List;

import BUS.AtividadeBUS;
import DTO.AtividadeDTO;

public class AtividadeVO {

	private List<AtividadeDTO> atividades;
	
	public AtividadeVO(){
		
		AtividadeBUS atividadeBUS = new AtividadeBUS();
		
		try{
			
			List<AtividadeDTO> atividades = atividadeBUS.Listar();
			this.setAtividades(atividades);
		}catch (Exception e){
			this.setAtividades(null);
		}
		
	}
	
	public List<AtividadeDTO> getAtividades(){
		
		return atividades;
	}
	
	public void setAtividades(List<AtividadeDTO> atividades){
		this.atividades = atividades;
	}
	
	
	
}
