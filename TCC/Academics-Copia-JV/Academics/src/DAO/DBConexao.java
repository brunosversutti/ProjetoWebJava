package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import DTO.ParametrosDTO;
import oracle.jdbc.pool.OracleDataSource;


public class DBConexao {

	private static Connection conexao = null;
	
	static public Connection Conectar()throws Exception{

		if(conexao == null){

			try
			{
				OracleDataSource ds = new OracleDataSource();
				ds.setURL("jdbc:oracle:thin:@localhost");
				ds.setUser("admin");
				ds.setPassword("admin");
				conexao = ds.getConnection();
			}
			catch (Exception e)
			{
				// TODO: handle exception
				throw new Exception("Erro ao Conectar ao Banco de Dados" + e.getMessage());
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

				throw new SQLException("Erro ao Desconectar do Banco de Dados" + e.getMessage());
			}	
		}	
	}

}
