package BUS;

import java.sql.ResultSet;
import java.util.List;

import DTO.DisciplinaDTO;
import DTO.SemestreDTO;
import DAO.DisciplinaDAO;

public class DisciplinaBUS {

	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();


	public Boolean Incluir(DisciplinaDTO disciplinaDTO){


		try{

			ResultSet rs = disciplinaDAO.BuscarDisciplina(disciplinaDTO);

			if(rs.next() == false){

				disciplinaDAO.Incluir(disciplinaDTO);
			}
			else{

				return false;

			}

		}catch(Exception e){

			System.out.println("ERRO NA EXECUCAO DO PROCESSO DE INCLUSAO DA DISCIPLINA " + e.getMessage());
		}

		return true;
	}
	
	public List<DisciplinaDTO> Listar() throws Exception {
		List<DisciplinaDTO> disciplinas = null;

		try
		{
			if(!disciplinaDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			disciplinas = disciplinaDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return disciplinas;
	}
	
	

}
