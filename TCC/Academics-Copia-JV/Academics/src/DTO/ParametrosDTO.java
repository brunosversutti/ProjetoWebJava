package DTO;
import javax.servlet.ServletConfig;
public class ParametrosDTO {

	public static String url;
	public static String usuario;
	public static String senha;
	
	
	
	public static void setParametros(ServletConfig config){
		
		url = config.getServletContext().getInitParameter("stringConexao");
		usuario = config.getServletContext().getInitParameter("usuario");
		senha = config.getServletContext().getInitParameter("senha");
		
	}
	
	
}
