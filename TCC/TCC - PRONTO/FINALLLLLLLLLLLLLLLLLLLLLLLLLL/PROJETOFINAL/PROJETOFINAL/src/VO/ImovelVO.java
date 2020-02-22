package VO;

import java.util.ArrayList;
import java.util.List;

import Business.ImovelBusiness;
import Dto.ImovelDTO;

public class ImovelVO {
	private List<ImovelDTO> imoveis;
	
	public ImovelVO()
	{
		ImovelBusiness imovelBusiness = new ImovelBusiness();
		
		try {
			List<ImovelDTO> imovel = imovelBusiness.Listar();
			this.setImovel(imovel);
		} catch (Exception e) {
			this.setImovel(null);
		}
	}

	public List<ImovelDTO> getImovel() {
		return imoveis;
	}

	public void setImovel(List<ImovelDTO> imoveis) {
		this.imoveis = imoveis;
	}
	
}
