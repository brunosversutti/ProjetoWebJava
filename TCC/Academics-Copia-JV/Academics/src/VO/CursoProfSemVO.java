package VO;

import java.sql.ResultSet;
import java.util.List;

import BUS.CursoProfSemBUS;
import BUS.ProfSemBUS;
import DTO.CursoDTO;
import DTO.CursoProfSemDTO;
import DTO.PessoaDTO;
import DTO.ProfSemDTO;

public class CursoProfSemVO {

	private List<CursoProfSemDTO> cursoProfSemestres;
	
	
	public CursoProfSemVO(){
		
		CursoProfSemBUS cursoProfSemBUS = new CursoProfSemBUS();
		

		try {
			List<CursoProfSemDTO> cursoProfSemestres = cursoProfSemBUS.Listar();
			
			this.setCursoProfSemestre(cursoProfSemestres);
			
		} catch (Exception e) {
			
			System.out.println("RETORNOU NULO");
			this.setCursoProfSemestre(null);
		}
	}

	public List<CursoProfSemDTO> getCursoProfSemestre() {
		return cursoProfSemestres;
	}

	public void setCursoProfSemestre(List<CursoProfSemDTO> cursoProfSemestre) {
		this.cursoProfSemestres = cursoProfSemestre;
	}
	
}
