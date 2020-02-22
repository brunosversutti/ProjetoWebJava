package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUS.SemestreBUS;
import DTO.SemestreDTO;

/**
 * Servlet implementation class ServletSemestre
 */
@WebServlet("/ServletSemestre")
public class ServletSemestre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int ano;
	private String periodo, situacao, ativo;
	//private boolean ativo;
	private SemestreDTO semestreDTO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSemestre() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void RecebeValores(HttpServletRequest request){
    	ano = Integer.parseInt(request.getParameter("ano"));
    	periodo = request.getParameter("periodo");
    	ativo = request.getParameter("situacao");
    	
    	semestreDTO =  new SemestreDTO();
    	semestreDTO.setAno(ano);
    	semestreDTO.setPeriodo(periodo);
    	semestreDTO.setStatus(ativo);
    	
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
		SemestreBUS semestreBUS = new SemestreBUS();
		
		try{
			
			semestreBUS.Incluir(semestreDTO);
			
		}catch (Exception e){
			
			System.out.println(e.getMessage());
		}
		
		
	}

}
