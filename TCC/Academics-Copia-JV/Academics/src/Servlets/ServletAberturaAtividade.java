package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUS.AtividadeBUS;
import DTO.AtividadeDTO;
import DTO.CursoProfSemDTO;
import DTO.DisciplinaDTO;
import DTO.ItensDisciplinaDTO;

/**
 * Servlet implementation class ServletAberturaAtividade
 */
@WebServlet("/ServletAberturaAtividade")
public class ServletAberturaAtividade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long codigo, idItensDisciplina, idCursoProfSem;
	private int tipoAtividade;
	private String nomeAtividade;
	private double nota;
	private ItensDisciplinaDTO itensDisciplina;
	private CursoProfSemDTO cursoProfSemDTO;
	private AtividadeDTO atividadeDTO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAberturaAtividade() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void RecebeValores(HttpServletRequest request){
    	
    	
    	//RECEBENDO OS VALORES DO FORMULARIO
    	
    	idCursoProfSem = Long.parseLong(request.getParameter("curso"));
    	nomeAtividade = request.getParameter("nomeAtividade");
    	tipoAtividade = Integer.parseInt(request.getParameter("tipo"));
    	idItensDisciplina = Long.parseLong(request.getParameter("disciplina"));
    	nota = 0;
    	
    	// ALIMENTANDO OS OBJETOS DA CLASSE COM OS VALORES RECEBIDOS
    	
    	cursoProfSemDTO = new CursoProfSemDTO();
    	itensDisciplina = new ItensDisciplinaDTO();
    	atividadeDTO = new AtividadeDTO();
    	
    	cursoProfSemDTO.setCodigo(idCursoProfSem);
    	itensDisciplina.setCodigo(idItensDisciplina);
    	atividadeDTO.setItenDisciplina(itensDisciplina);
    	atividadeDTO.setNome(nomeAtividade);
    	atividadeDTO.setNota(nota);
    	atividadeDTO.setTipo(tipoAtividade);
    	
    	
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
		
		AtividadeBUS atividadeBUS = new AtividadeBUS();
		
		try{
			
			atividadeBUS.Incluir(atividadeDTO);
		
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}
		
	}

}
