package Servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AlunoAtivDAO;
import DTO.AlunoAtivDTO;

/**
 * Servlet implementation class Testes
 */
@WebServlet("/Testes")
public class Testes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String html, nome;
	private AlunoAtivDAO alunoAtivDAO;
	private AlunoAtivDTO alunoAtivDTO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Testes() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void init(ServletConfig config) throws ServletException {

		System.out.println("Executou Servlet Teste");

	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("EXECUTOU DO-GET");
		
		String filePath = "E:/curso-java/Java_Basico_Modulo_10-swing.pdf";
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		// if you want to use a relative path to context root:
		//String relativePathh = getServletContext().getRealPath("");
		//System.out.println("relativePath = " + relativePath);
		
		// obtains ServletContext
		ServletContext context = getServletContext();
		
		// gets MIME type of the file
		String mimeType = context.getMimeType(filePath);
		if (mimeType == null) {			
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);
		
		// modifies response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		
		// forces download
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);
		
		// obtains response's output stream
		OutputStream outStream = response.getOutputStream();
		
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while ((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		
		inStream.close();
		outStream.close();				
	}
	
	private void teste()
	{
//try{
			
			//String idDownload = request.getParameter("idArquivo");
	
			
			/**
			
			ResultSet rs = alunoAtivDAO.ListaDownloads();
			String fileName = rs.getString("NOMEARQUIVO");
			String filePath ="E:\\DOWNLOAD\\";
			
			
			alunoAtivDAO.BaixarArquivos(idDownload);


			response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader("Content-Disposition","attachment; fileName=\"" + fileName + "\"");

			java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filePath + fileName);

			//int i;
/**
			PrintWriter out = response.getWriter();

			while((i=fileInputStream.read())!= -1){
				
				out.write(i);

			}

			fileInputStream.close();
*/
			
/*			OutputStream outStream = response.getOutputStream();
			byte[] buffer = new byte[2048];
			int bytesRead = -1;
			while((bytesRead = fileInputStream.read(buffer))!= -1){
				
				outStream.write(buffer, 0, bytesRead);
			}
			
			fileInputStream.close();
			outStream.close();
			
		}catch(Exception e){

			System.out.println("Erro: " + e.toString());
		}	*/

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("EXECUTOU DO-POST");
		
		
	}

}