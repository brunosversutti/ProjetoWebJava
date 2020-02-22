package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUS.CursoProfSemBUS;
import BUS.ItensDisciplinaBUS;
import DTO.CursoDTO;
import DTO.CursoProfSemDTO;
import DTO.DisciplinaDTO;
import DTO.ItensDisciplinaDTO;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;
import DTO.SemestreDTO;

/**
 * Servlet implementation class ServletCursoProfSem
 */
@WebServlet("/ServletCursoProfSem")
public class ServletCursoProfSem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private long codigo, codProfSem, codCurso, codDisciplina;
	
	private ProfSemDTO profSemestreDTO;
	private ProfessorDTO professorDTO;
	private CursoDTO cursoDTO;
	private CursoProfSemDTO cursoProfSemDTO;
	private DisciplinaDTO disciplinaDTO;
	private ItensDisciplinaDTO itensDisciplinaDTO;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCursoProfSem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void RecebeValores(HttpServletRequest request){

		
		
		codProfSem = Long.parseLong(request.getParameter("profSemestre"));
		codCurso = Long.parseLong(request.getParameter("curso"));
		codDisciplina =  Long.parseLong(request.getParameter("disciplina"));
	
		disciplinaDTO = new DisciplinaDTO();
		profSemestreDTO = new ProfSemDTO();
		cursoDTO = new CursoDTO();
		cursoProfSemDTO = new CursoProfSemDTO();
		itensDisciplinaDTO = new ItensDisciplinaDTO();
	
		profSemestreDTO.setCodigo(codProfSem);
		cursoDTO.setCodigo(codCurso);
		
		cursoProfSemDTO.setCurso(cursoDTO);
		cursoProfSemDTO.setProfSemestre(profSemestreDTO);
		
		disciplinaDTO.setCodigo(codDisciplina);
		itensDisciplinaDTO.setCursoprofsem(cursoProfSemDTO);
		itensDisciplinaDTO.setDisciplina(disciplinaDTO);


	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.RecebeValores(request);

		CursoProfSemBUS cursoProfSemBUS = new CursoProfSemBUS();
		ItensDisciplinaBUS itensDisciplinaBUS = new ItensDisciplinaBUS();

		try{

			cursoProfSemBUS.Incluir(profSemestreDTO, cursoDTO, cursoProfSemDTO);

		}catch (Exception e){

			System.out.println(e.getMessage());

		}
		
		try{
			
			itensDisciplinaBUS.Incluir(itensDisciplinaDTO);
			
		}catch (Exception e){

			System.out.println(e.getMessage());

		}
		
	}

}
