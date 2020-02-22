package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUS.CursoBUS;
import DTO.CursoDTO;

/**
 * Servlet implementation class ServletCurso
 */
@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nomeCurso,titulo,periodo;
	private int duracao;
	private CursoDTO cursoDTO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCurso() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void RecebeValores(HttpServletRequest request){
    	
    	
    	//RECEBE OS VALORES DOS CAMPOS DO FORMULARIO ATRAVES DO REQUEST
    	
    	nomeCurso = request.getParameter("nome");
    	titulo = request.getParameter("titulo");
    	periodo = request.getParameter("periodo");
    	duracao = Integer.parseInt(request.getParameter("duracao"));
    	
    	//ALIMENTANDO O OBJETO CURSO
    	
    	cursoDTO = new CursoDTO();
    	cursoDTO.setNome(nomeCurso);
    	cursoDTO.setTitulo(titulo);
    	cursoDTO.setPeriodo(periodo);
    	cursoDTO.setDuracao(duracao);
    	
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
		CursoBUS cursoBUS = new CursoBUS();
		cursoBUS.Incluir(cursoDTO);
		
		
	}

}
