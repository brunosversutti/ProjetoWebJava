package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUS.DisciplinaBUS;
import DTO.DisciplinaDTO;

/**
 * Servlet implementation class ServletDisciplina
 */
@WebServlet("/ServletDisciplina")
public class ServletDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nomeDisciplina, cargaHoraria;
	private DisciplinaDTO disciplinaDTO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void RecebeValores(HttpServletRequest request){
    	
    	nomeDisciplina = request.getParameter("nome");
    	cargaHoraria = request.getParameter("carga");
    	
    	//ALIMENTANDO O OBJETO DISCIPLINA
    	
    	disciplinaDTO = new DisciplinaDTO();
    	disciplinaDTO.setNome(nomeDisciplina);
    	disciplinaDTO.setDuracao(Integer.parseInt(cargaHoraria));
    	
    	
    	
    	
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
		DisciplinaBUS disciplinaBUS = new DisciplinaBUS();
		
		try{
			
			disciplinaBUS.Incluir(disciplinaDTO);
			
		}catch (Exception e){
			
			System.out.println(e.getMessage());
		}
		
		
	}

}
