package VO;

import java.util.List;
import java.util.ArrayList;

import DTO.AlunoDTO;
import DTO.ProfessorDTO;
import BUS.AlunoBUS;


public class AlunoVO {

	private List<AlunoDTO> alunos;
	
	
	public AlunoVO(){
		
		AlunoBUS alunoBUS = new AlunoBUS();
		
		try {
			List<AlunoDTO> alunos = alunoBUS.Listar();
			this.setAluno(alunos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.setAluno(null);
			e.printStackTrace();
		}
		
	}
	
	public List<AlunoDTO> getAlunos(){
		return alunos;
	}
	
	public void setAluno(List<AlunoDTO> alunos) {
		this.alunos = alunos;
	}
	
	
}
