package VO;

import java.util.List;

import BUS.CidadeBUS;
import DTO.CidadeDTO;

public class CidadeVO {
	
		private List<CidadeDTO> cidades;
		
		public CidadeVO()
		{
			CidadeBUS cidadeBusiness = new CidadeBUS();
			
			try {
				List<CidadeDTO> cidades = cidadeBusiness.Listar();
				this.setCidades(cidades);
			} catch (Exception e) {
				this.setCidades(null);
			}
		}

		public List<CidadeDTO> getCidades() {
			return cidades;
		}

		public void setCidades(List<CidadeDTO> cidades) {
			this.cidades = cidades;
		}

}
