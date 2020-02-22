package Servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



import java.io.InputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;






import DAO.AlunoAtivDAO;
import DTO.AlunoAtivDTO;
import DTO.AlunoDTO;
import DTO.AtividadeDTO;
import DTO.CidadeDTO;
import DTO.CursoDTO;
import DTO.EnderecoDTO;
import DTO.PessoaDTO;


/**
 * Servlet implementation class ServletUploadFile
 */
@WebServlet("/ServletUploadFile")
public class ServletUploadFile extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public long codAluno, codAtividade = 0;
	String aln, atv = "";

	AlunoDTO aluno = new AlunoDTO();
	AtividadeDTO atividade = new AtividadeDTO();
	AlunoAtivDTO alunoAtivDTO = new AlunoAtivDTO();
	AlunoAtivDAO alunoAtivDAO = new AlunoAtivDAO();

	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sessao = request.getSession(true);
		
		codAluno = (Long)sessao.getAttribute("codAl");
		codAtividade = (Long)sessao.getAttribute("codAt");
		
		//codAtividade = Long.parseLong(request.getParameter("codAtiv"));
		System.out.println("CHAMOU REQUEST");
		
		boolean isMultiPart = FileUpload.isMultipartContent(request);

		if(isMultiPart){
			System.out.println("ENTROU MULTPART");

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			String formulario = "";

			try{

				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();

				while(iter.hasNext()){
					FileItem item = (FileItem)iter.next();
					if(item.getFieldName().equals("tipoForm")){

						formulario =  item.getString();
					}

					if(!item.isFormField()){
						if(item.getName().length()>0){
							//this.inserirImagem(item);
							this.inserirArquivo(item);

						}
					}

				}
			}catch (FileUploadException ex){
				ex.printStackTrace();
			}
			catch(Exception ex){

				ex.printStackTrace();
			}

		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DESVIO PARA DOGET");
		
		
		doGet(request, response);

	}


	private void inserirArquivo(FileItem item) throws IOException, 
	ClassNotFoundException, SQLException{

		
		String caminho = "E:\\UPLOAD";

		File diretorio = new File(caminho);
		if(!diretorio.exists()){
			diretorio.mkdir();
		}

		String nome = item.getName();
		String arq[] = nome.split("\\\\");

		for(int i=0; i<arq.length; i++){
			nome = arq[i];
		}

		File file = new File (diretorio,nome);
		FileOutputStream output = new FileOutputStream(file);
		InputStream is = item.getInputStream();
		byte[] buffer = new byte[4096];
		int nLidos;
		while((nLidos = is.read(buffer)) >=0){
			output.write(buffer, 0, nLidos); 
		}

		System.out.println("nome arquivo " + nome);

		output.flush();
		output.close();


		aluno.setCodigo(codAluno);
		atividade.setCodigo(codAtividade);
		alunoAtivDTO.setAluno(aluno);
		alunoAtivDTO.setAtividade(atividade);
		alunoAtivDTO.setNomeArquivo(nome);
		alunoAtivDTO.setItem(item);

		try {
			alunoAtivDAO.Incluir(alunoAtivDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
