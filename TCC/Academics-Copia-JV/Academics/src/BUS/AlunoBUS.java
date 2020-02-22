package BUS;


import java.util.List;

import DAO.AlunoDAO;
import DAO.PessoaDAO;
import DTO.AlunoDTO;
import DTO.PessoaDTO;
import DTO.ProfessorDTO;

public class AlunoBUS {

	private AlunoDAO alunoDAO = new AlunoDAO();


	public Boolean Incluir(AlunoDTO alunoDTO) throws Exception {
		try
		{

			alunoDAO.Incluir(alunoDTO);

		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}


	public List<AlunoDTO> Listar() throws Exception {
		List<AlunoDTO> alunos = null;

		try
		{
			if(!alunoDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			alunos = alunoDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return alunos;
	}

}



