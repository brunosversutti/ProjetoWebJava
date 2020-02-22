package BUS;

import java.sql.ResultSet;
import java.util.List;

import DAO.CursoDAO;
import DAO.CursoProfSemDAO;
import DTO.CursoDTO;
import DTO.CursoProfSemDTO;
import DTO.PessoaDTO;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;

public class CursoProfSemBUS {


	private CursoProfSemDAO cursoProfSemDAO = new CursoProfSemDAO();


	public Boolean Incluir(ProfSemDTO profSemestreDTO, CursoDTO cursoDTO, CursoProfSemDTO cursoProfSemDTO){


		try{

			ResultSet rs = cursoProfSemDAO.BuscarCursoProfSem(profSemestreDTO, cursoDTO);

			if(rs.next() == false){

				cursoProfSemDAO.Incluir(profSemestreDTO, cursoDTO, cursoProfSemDTO);
			}
			else{

				return false;

			}

		}catch(Exception e){

			System.out.println("ERRO NA EXECUCAO DO PROCESSO DE INCLUSAO DO VINCULO CURSO PROF E SEMESTRE " + e.getMessage());
		}

		return true;
	}


	public List<CursoProfSemDTO> Listar() throws Exception {
		List<CursoProfSemDTO> cursoProfSemestres = null;
		

		try
		{
			if(!cursoProfSemDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			cursoProfSemestres = cursoProfSemDAO.Listar();
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return cursoProfSemestres;
	}

	public ResultSet BuscarProfCursoSemestre(PessoaDTO pessoaDTO) throws Exception{

		try{
			return cursoProfSemDAO.BuscarPessoaCursoProfSem(pessoaDTO);

		}catch (Exception e){

			throw new Exception(e.getMessage());
		}
	}

}
