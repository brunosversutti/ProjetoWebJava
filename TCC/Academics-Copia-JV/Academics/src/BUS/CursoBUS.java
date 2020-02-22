package BUS;

import java.sql.ResultSet;
import java.util.List;

import DAO.CursoDAO;
import DTO.CidadeDTO;
import DTO.CursoDTO;
import DTO.DisciplinaDTO;
import DTO.PessoaDTO;

public class CursoBUS {

	private CursoDAO cursoDAO = new CursoDAO();
	private PessoaDTO pessoaDTO;
	
	public Boolean Incluir(CursoDTO cursoDTO){


		try{

			ResultSet rs = cursoDAO.BuscarCurso(cursoDTO);

			if(rs.next() == false){

				cursoDAO.Incluir(cursoDTO);
			}
			else{

				return false;

			}

		}catch(Exception e){

			System.out.println("ERRO NA EXECUCAO DO PROCESSO DE INCLUSAO DA DISCIPLINA " + e.getMessage());
		}

		return true;
	}
	
	
	public List<CursoDTO> Listar() throws Exception {
		List<CursoDTO> cursos = null;

		try
		{
			if(!cursoDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			cursos = cursoDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return cursos;
	}
	
	
}
