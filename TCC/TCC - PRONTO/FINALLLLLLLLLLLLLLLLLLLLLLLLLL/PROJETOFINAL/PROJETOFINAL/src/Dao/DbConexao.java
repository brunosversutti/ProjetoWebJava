package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;


public class DbConexao {
	private static Connection conexao = null;

	static public Connection getConexao() throws Exception
	{
		if(conexao == null)
		{
			try
			{
				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setUser("sa");
				ds.setPassword("acesso55");
				ds.setServerName("BRUNO-NOT");
				ds.setPortNumber(Integer.parseInt("1433"));
				ds.setDatabaseName("PROJETOFINAL");				

				/*				ds.setURL(ParametrosDTO.url);
				ds.setPassword(ParametrosDTO.senha);
				ds.setUser(ParametrosDTO.usuario);*/
				conexao = ds.getConnection();
			}
			catch (Exception e)
			{
				conexao = null;
				throw new Exception("Não foi possível abrir conexão com o banco de dados: " + e.getMessage());
			}

		}

		return conexao; 
	}

	static public void Desconectar() throws SQLException
	{
		if(conexao != null)
		{
			try
			{
				conexao.close();
			} 
			catch (SQLException e) 
			{
				throw new SQLException("Não foi possível abrir conexão com o banco de dados: " + e.getMessage());
			}
		}
	}

}
