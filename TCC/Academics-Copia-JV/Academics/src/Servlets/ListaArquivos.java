package Servlets;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AlunoAtivDAO;
import DTO.AlunoAtivDTO;

/**
 * Servlet implementation class ListaArquivos
 */
@WebServlet("/ListaArquivos")
public class ListaArquivos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AlunoAtivDTO alunoAtivDTO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaArquivos() {
        super();
        // TODO Auto-generated constructor stub
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
