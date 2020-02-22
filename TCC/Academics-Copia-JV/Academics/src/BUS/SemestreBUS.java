package BUS;


import java.sql.ResultSet;
import java.util.List;

import DTO.CursoDTO;
import DTO.PessoaDTO;
import DTO.SemestreDTO;
import DAO.SemestreDAO;

public class SemestreBUS {

	SemestreDAO semestreDAO = new SemestreDAO();
	
	public Boolean Incluir(SemestreDTO semestreDTO){
		
		try{
			
			ResultSet rs = semestreDAO.BuscarSemestre(semestreDTO);
			
			if(rs.next() == false){
				
				semestreDAO.Incluir(semestreDTO);
			}
			else{
				
				return false;
				
			}
						
		}catch(Exception e){
			
			System.out.println("ERRO NA EXECUCAO DO PROCESSO" + e.getMessage());
		}

		return true;
		
	}
	
	public List<SemestreDTO> Listar() throws Exception {
		List<SemestreDTO> semestres = null;

		try
		{
			if(!semestreDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			semestres = semestreDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return semestres;
	}
	
	
	public List<SemestreDTO> ListarPorAluno(PessoaDTO pessoaDTO) throws Exception {
		List<SemestreDTO> semestres = null;

		try
		{
			if(!semestreDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			semestres = semestreDAO.ListaAlunoSemestre(pessoaDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return semestres;
	}
	
	
}
