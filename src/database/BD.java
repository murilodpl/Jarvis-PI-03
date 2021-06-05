package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {
	public Connection con = null; // objeto de conexão
	public PreparedStatement st = null; // executa instruções em SQL
	public ResultSet rs = null; // recebe o resultado de uma query
	
	//é diferente para cada Driver (pacote.classe)
	private final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
	private final String BANCO = "pi3";
	private final String URL = "jdbc:mysql://localhost:3306/"+BANCO;
	private final String LOGIN = "root";
	private final String SENHA = "1234";
	
	//realizar a conexão
	
	/**
	 * Realiza a conexão ao banco de dados
	 * @return - um tipo booleano que indica o sucesso ou não da conexão
	 */
	public boolean getConnection() {
		try {
			Class.forName(DRIVER); //carregando o Driver para ser utilizado
			con = DriverManager.getConnection(URL,LOGIN,SENHA);
//			con = DriverManager.getConnection(URL);
			System.out.println("Conectou...");
			return true;
		}
		catch(ClassNotFoundException erro) {
			System.out.println("Falha no carregamento do driver");
		} 
		catch (SQLException erro) {
			System.out.println(erro.toString());
		}
		return false;
	}
	public void close() {
		try { if(rs!=null) rs.close(); }
		catch(SQLException erro) {}
		
		try { if(st!=null) st.close();	}
		catch(SQLException erro) {}
		
		try {
			if(con!=null) {
				con.close();
				System.out.println("Desconectou...");
			}
		}
		catch(SQLException erro) {}
	}
	
	
	/*public static void main(String[] args) {
		BD_Auth bd = new BD_Auth();
		bd.getConnection();
		bd.close();
	}*/
	
}
