package BUS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import DAO.ItensDisciplinaDAO;
import DTO.CursoDTO;
import DTO.CursoProfSemDTO;
import DTO.DisciplinaDTO;
import DTO.ItensDisciplinaDTO;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;

public class ItensDisciplinaBUS {

	
	ItensDisciplinaDAO  itensDisciplinaDAO = new ItensDisciplinaDAO();

	public Boolean Incluir(ItensDisciplinaDTO itensDisciplinaDTO){
		
		try{
			
			itensDisciplinaDAO.Incluir(itensDisciplinaDTO);
		}catch (Exception e){
			
			System.out.println(e.getMessage());
		}
		
		return true;
	}
	
	
	public List<ItensDisciplinaDTO> Listar() throws Exception {
		List<ItensDisciplinaDTO> itensDisciplinas = null;

		try
		{
			if(!itensDisciplinaDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			itensDisciplinas = itensDisciplinaDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return itensDisciplinas;
	}
	
	
	
}
