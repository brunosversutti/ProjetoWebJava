package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.AlunoDTO;
import DTO.AlunoSemDTO;
import DTO.SemestreDTO;
import BUS.AlunoSemBUS;

/**
 * Servlet implementation class ServletAlunoSemestre
 */
@WebServlet("/ServletAlunoSemestre")
public class ServletAlunoSemestre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long codigo, codAluno, codSemestre;
	private SemestreDTO semestreDTO;
	private AlunoDTO alunoDTO;
	private AlunoSemDTO alunoSemDTO;
	private AlunoSemBUS alunoSemBUS;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlunoSemestre() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void RecebeValores(HttpServletRequest request){
    	
    	
    	//RECEBENDO ATRIBUTOS DA PAGINAS ATRAVES DO REQUEST
    	
    	codAluno = Integer.parseInt(request.getParameter("aluno"));
    	codSemestre = Integer.parseInt(request.getParameter("semestre"));
    	
    	
    	//INSTANCIANDO OS OBJETOS ALUNO E SEMESTRE
    	
    	alunoDTO = new AlunoDTO();
    	semestreDTO = new SemestreDTO();
    	alunoSemDTO = new AlunoSemDTO();
    	//VINCULANDO A ID DO ALUNO E DO SEMESTRE PARA OS OBJETOS
    	
    	alunoDTO.setCodigo(codAluno);
    	semestreDTO.setCodigo(codSemestre);
    	
    	//VINCULANDO OS ATRIBUTOS DAS CLASSES RELACIONADAS A CLASSE ATUAL
    	
    	alunoSemDTO.setAluno(alunoDTO);
    	alunoSemDTO.setSemestre(semestreDTO);
    	
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
		AlunoSemBUS alunoSemBUS = new AlunoSemBUS();
		
		try{
			
			alunoSemBUS.Incluir(alunoSemDTO);
		}catch (Exception e){
			
			System.out.println("ERRO AO VINCULAR ALUNO E SEMESTRE " + e.getMessage());
		}
		
		
	}

}
