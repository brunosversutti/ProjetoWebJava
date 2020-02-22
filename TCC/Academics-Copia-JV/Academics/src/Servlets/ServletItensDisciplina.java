package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.AtividadeDTO;
import DTO.CursoProfSemDTO;
import DTO.DisciplinaDTO;
import DTO.ItensDisciplinaDTO;

/**
 * Servlet implementation class ServletItensDisciplina
 */
@WebServlet("/ServletItensDisciplina")
public class ServletItensDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private long codDisciplina, codItensDisciplina, codCursoProfSem, codAtividade;
	private String nomeAtividade;
	
	private DisciplinaDTO disciplinaDTO;
	private ItensDisciplinaDTO itensDisciplinaDTO;
	private CursoProfSemDTO cursoProfSemDTO;
	private AtividadeDTO atividadeDTO;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletItensDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void RecebeValores(HttpServletRequest request){
    	
    	codDisciplina = Long.parseLong(request.getParameter("disciplina"));
    	nomeAtividade = request.getParameter("nomeAtividade");
    	
    	
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
	}

}
