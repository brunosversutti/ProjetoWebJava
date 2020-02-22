package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUS.ProfSemBUS;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;
import DTO.SemestreDTO;

/**
 * Servlet implementation class ServletProfSemestre
 */
@WebServlet("/ServletProfSemestre")
public class ServletProfSemestre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long codigo, codProfessor, codSemestre;
	private ProfessorDTO professorDTO;
	private SemestreDTO semestreDTO;
	private ProfSemDTO profSemDTO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfSemestre() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void RecebeValores(HttpServletRequest request){
    	
    	//RECEBENDO ATRIBUDOS DA PAGINA
    	
    	codProfessor = Long.parseLong(request.getParameter("professor"));
    	codSemestre = Long.parseLong(request.getParameter("semestre"));
    	
    	//CRIANDO OBJETOS PROFESSOR, SEMESTRE E PROFESSOR DO SEMESTRE
    	professorDTO = new ProfessorDTO();
    	semestreDTO = new SemestreDTO();
    	profSemDTO = new ProfSemDTO();
    	
    	//PASSANDO A ID DO PROFESSOR E SEMESTRE PARA VINCULAR AO PROFESSOR DO SEMESTRE
    	professorDTO.setCodigo(codProfessor);
    	semestreDTO.setCodigo(codSemestre);
    	
    	//VINCULANDO O PROFESSOR E SEMESTRE AO PROFESSOR DO SEMESTRE
    	
    	profSemDTO.setProfessor(professorDTO);
    	profSemDTO.setSemestre(semestreDTO);
    	
    	
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
		
		ProfSemBUS profSemBUS = new ProfSemBUS();
		
		try{
			
			profSemBUS.Incluir(profSemDTO);
		
		}catch(Exception e){
			
			System.out.println("ERRO AO VINCULAR PROFESSOR E SEMESTRE " + e.getMessage());
			
		}
		
		
		
	}

}
