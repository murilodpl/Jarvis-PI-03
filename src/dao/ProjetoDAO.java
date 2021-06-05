package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import classes.Projeto;
import database.BD;

public class ProjetoDAO {

	/*
	 * CRUD CREATE READ UPDATE DELETE
	 */

	// Create
	public void create(Projeto projeto) {
		BD bd = new BD();

		String sql = "INSERT INTO projeto(nameProj, descProj, equipeProj, emailUser) VALUES(?, ?, ?, ?)";

		boolean conn = false;
		PreparedStatement pstm = null;

		try {
			// criar uma conexão com o banco de dados
			conn = bd.getConnection();

			pstm = bd.con.prepareStatement(sql);
			pstm.setString(1, projeto.getNomeProjeto());
			pstm.setString(2, projeto.getDescricaoProjeto());
			pstm.setString(3, projeto.getEquipeProjeto());
			pstm.setString(4, projeto.getEmailUser());

			// executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn == true) {
					bd.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	// Read
	public void read(int codProjeto) {
		BD bd = new BD();

		String sql = "SELECT nameProj, descProj, equipeProj, emailUser FROM projeto where codProjeto = ?";

		boolean conn = false;
		PreparedStatement pstm = null;

		try {
			// criar uma conexão com o banco de dados
			conn = bd.getConnection();
			
			pstm = bd.con.prepareStatement(sql);
			pstm.setDouble(1, codProjeto);
			bd.rs = pstm.executeQuery();

			// iterate through the java resultset
			while (bd.rs.next()) {
				String nameProj = bd.rs.getString("nameProj");
				String descProj = bd.rs.getString("descProj");
				String equipeProj = bd.rs.getString("equipeProj");
				String emailUser = bd.rs.getString("emailUser");

				// print the results
				System.out.format("%s, %s, %s, %s, %s\n", codProjeto, nameProj, descProj, equipeProj, emailUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn == true) {
					bd.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// ReadAll
	public void readAll() {
		BD bd = new BD();

		String sql = "SELECT * FROM projeto";

		boolean conn = false;
		PreparedStatement pstm = null;

		try {
			// criar uma conexão com o banco de dados
			conn = bd.getConnection();

			pstm = bd.con.prepareStatement(sql);

			// execute the query, and get a java resultset
			bd.rs = pstm.executeQuery();

			// iterate through the java resultset
			while (bd.rs.next()) {
				int codProjeto = bd.rs.getInt("codProjeto");
				String nameProj = bd.rs.getString("nameProj");
				String descProj = bd.rs.getString("descProj");
				String equipeProj = bd.rs.getString("equipeProj");
				String emailUser = bd.rs.getString("emailUser");

				// print the results
				System.out.format("%s, %s, %s, %s, %s\n", codProjeto, nameProj, descProj, equipeProj, emailUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn == true) {
					bd.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	// Update
	public void update(Projeto projeto) {
		BD bd = new BD();

		String sqlRead = "SELECT nameProj, descProj, equipeProj, emailUser FROM projeto where codProjeto = ?";
		String sql = "UPDATE projeto SET nameProj = ?, descProj = ?, equipeProj = ?, emailUser = ? where codProjeto = ?";

		String nameProj = "", descProj = "", equipeProj = "", emailUser = "";
		boolean conn = false;
		PreparedStatement pstm = null, pstmRead = null;

		try {
			// criar uma conexão com o banco de dados
			conn = bd.getConnection();
			
			pstmRead = bd.con.prepareStatement(sqlRead);
			pstmRead.setDouble(1, projeto.getCodProjeto());
			bd.rs = pstmRead.executeQuery();

			// iterate through the java resultset
			while (bd.rs.next()) {
				nameProj = bd.rs.getString("nameProj");
				descProj = bd.rs.getString("descProj");
				equipeProj = bd.rs.getString("equipeProj");
				emailUser = bd.rs.getString("emailUser");
			}
			
			//Algumas condições caso o usuário não insira nada em algum campo, assim mantendo o que tinha anteriormente
			pstm = bd.con.prepareStatement(sql);
			if(projeto.getNomeProjeto() != null && projeto.getNomeProjeto() != "" && projeto.getNomeProjeto() != " ") {				
				pstm.setString(1, projeto.getNomeProjeto());
			}else {
				pstm.setString(1, nameProj);
			}
			
			if(projeto.getDescricaoProjeto() != null && projeto.getDescricaoProjeto() != "" && projeto.getDescricaoProjeto() != " ") {				
				pstm.setString(2, projeto.getDescricaoProjeto());
			}else {
				pstm.setString(2, descProj);
			}
			
			if(projeto.getEquipeProjeto() != null && projeto.getEquipeProjeto() != "" && projeto.getEquipeProjeto() != " ") {				
				pstm.setString(3, projeto.getEquipeProjeto());
			}else {
				pstm.setString(3, equipeProj);
			}
			
			if(projeto.getEmailUser() != null && projeto.getEmailUser() != "" && projeto.getEmailUser() != " ") {				
				pstm.setString(4, projeto.getEmailUser());
			}else {
				pstm.setString(4, emailUser);
			}
			
			pstm.setDouble(5, projeto.getCodProjeto());

			// executar a query
			pstm.executeUpdate();		      
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn == true) {
					bd.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// Delete
	public void delete(int codProjeto) {
		BD bd = new BD();

		String sql = "DELETE from projeto where codProjeto = ?";

		boolean conn = false;
		PreparedStatement pstm = null;

		try {
			// criar uma conexão com o banco de dados
			conn = bd.getConnection();

			pstm = bd.con.prepareStatement(sql);
			pstm.setInt(1, codProjeto);

			// executar a query
			pstm.executeUpdate();		      
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn == true) {
					bd.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
