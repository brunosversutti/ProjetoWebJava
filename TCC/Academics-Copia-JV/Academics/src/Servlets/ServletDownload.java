package Servlets;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.AlunoAtivDAO;
import DTO.AlunoAtivDTO;

/**
 * Servlet implementation class ServletDownload
 */
@WebServlet("/ServletDownload")
public class ServletDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String nomeArquivo;
	private String idArquivo;
	private String caminho;
	private AlunoAtivDAO alunoAtivDAO = new AlunoAtivDAO();
	private AlunoAtivDTO alunoAtivDTO = new AlunoAtivDTO();



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDownload() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		



		try {
			idArquivo = request.getParameter("idArquivo");
			
			System.out.println("IDARQUIVO" + idArquivo);
			
			AlunoAtivDTO alunoAtivDTO = alunoAtivDAO.BaixarArquivos(idArquivo);
			
			String localArquivo = alunoAtivDTO.getNomeArquivo();
			
			System.out.println(localArquivo);
			
			
			caminho ="E:\\UPLOAD\\"+localArquivo;
			File arquivo = new File(caminho);
			
			String mimeType = "application/octet-stream";
			
			
			response.setContentType(mimeType);
			response.setContentLength((int) arquivo.length());
			
			
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", arquivo.getName());
	        response.setHeader(headerKey, headerValue);
			
	        /*byte[] buffer = new byte[4096];
	        buffer = alunoAtivDTO.getArquivo();
	        //int bytesRead = -1;
			FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
			fileOutputStream.write(alunoAtivDTO.getArquivo());
			fileOutputStream.close();*/

	        
	        OutputStream outStream = response.getOutputStream();
	        outStream.write(alunoAtivDTO.getArquivo());
	        
			/*while ((bytesRead = alunoAtivDTO.getArquivo(). read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }*/
	         
	        outStream.close();
			
		}
		catch (Exception e){
			System.out.println("ERRO " + e.toString());
			
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub






	}

}
