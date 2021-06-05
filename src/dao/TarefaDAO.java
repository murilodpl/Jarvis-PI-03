package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import classes.Tarefa;
import database.BD;

public class TarefaDAO {

	/*
	 * CRUD CREATE READ UPDATE DELETE
	 */

	// Create
	public void create(Tarefa tarefa) {
		BD bd = new BD();

		String sql = "INSERT INTO tarefa(nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, codProjeto, emailUser) VALUES(?, ?, ?, ?, ?, ?)";

		boolean conn = false;
		PreparedStatement pstm = null;

		try {
			// criar uma conexão com o banco de dados
			conn = bd.getConnection();

			pstm = bd.con.prepareStatement(sql);
			pstm.setString(1, tarefa.getNomeTarefa());
			pstm.setString(2, tarefa.getDescricaoTarefa());
			pstm.setString(3, tarefa. getDataInicio());
			pstm.setString(4, tarefa. getDataFim());
			pstm.setDouble(5, tarefa. getCodProjeto());
			pstm.setString(6, tarefa.getEmailUser());

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
	public void read(int codTarefa) {
		BD bd = new BD();

		String sql = "SELECT nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, codProjeto, emailUser FROM tarefa where codTarefa = ?";

		boolean conn = false;
		PreparedStatement pstm = null;

		try {
			// criar uma conexão com o banco de dados
			conn = bd.getConnection();
			
			pstm = bd.con.prepareStatement(sql);
			pstm.setDouble(1, codTarefa);
			bd.rs = pstm.executeQuery();

			// iterate through the java resultset
			while (bd.rs.next()) {
				String nameTarefa = bd.rs.getString("nameTarefa");
				String descTarefa = bd.rs.getString("descTarefa");
				String data_inic_tarefa = bd.rs.getString("data_inic_tarefa");
				String data_final_tarefa = bd.rs.getString("data_final_tarefa");
				String codProjeto = bd.rs.getString("codProjeto");
				String emailUser = bd.rs.getString("emailUser");

				// print the results
				System.out.format("%s, %s, %s, %s, %s, %s, %s\n", codTarefa, nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, codProjeto, emailUser);
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
	
	// ReadByProject
	public void readByProjectID(int codProjeto) {
		BD bd = new BD();

		String sql = "SELECT codTarefa, nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, emailUser FROM tarefa where codProjeto = ?";

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
				String codTarefa = bd.rs.getString("codTarefa");
				String nameTarefa = bd.rs.getString("nameTarefa");
				String descTarefa = bd.rs.getString("descTarefa");
				String data_inic_tarefa = bd.rs.getString("data_inic_tarefa");
				String data_final_tarefa = bd.rs.getString("data_final_tarefa");
				String emailUser = bd.rs.getString("emailUser");

				// print the results
				System.out.format("%s, %s, %s, %s, %s, %s, %s\n", codTarefa, nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, codProjeto, emailUser);
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

		String sql = "SELECT * FROM tarefa";

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
				int codTarefa = bd.rs.getInt("codTarefa");
				String nameTarefa = bd.rs.getString("nameTarefa");
				String descTarefa = bd.rs.getString("descTarefa");
				String data_inic_tarefa = bd.rs.getString("data_inic_tarefa");
				String data_final_tarefa = bd.rs.getString("data_final_tarefa");
				String codProjeto = bd.rs.getString("codProjeto");
				String emailUser = bd.rs.getString("emailUser");

				// print the results
				System.out.format("%s, %s, %s, %s, %s, %s, %s\n", codTarefa, nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, codProjeto, emailUser);
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
	public void update(Tarefa tarefa) {
		BD bd = new BD();

		String sqlRead = "SELECT nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, codProjeto, emailUser FROM tarefa where codTarefa = ?";
		String sql = "UPDATE tarefa SET nameTarefa = ?, descTarefa = ?, data_inic_tarefa = ?, data_final_tarefa = ?, codProjeto = ?, emailUser = ? where codTarefa = ?";

		String nameTarefa = "", descTarefa = "", data_inic_tarefa = "", data_final_tarefa = "", emailUser = "";
		int codProjeto = 0;
		
		boolean conn = false;
		PreparedStatement pstm = null, pstmRead = null;

		try {
			// criar uma conexão com o banco de dados
			conn = bd.getConnection();
			
			pstmRead = bd.con.prepareStatement(sqlRead);
			pstmRead.setDouble(1, tarefa.getCodTarefa());
			bd.rs = pstmRead.executeQuery();

			// iterate through the java resultset
			while (bd.rs.next()) {
				nameTarefa = bd.rs.getString("nameTarefa");
				descTarefa = bd.rs.getString("descTarefa");
				data_inic_tarefa = bd.rs.getString("data_inic_tarefa");
				data_final_tarefa = bd.rs.getString("data_final_tarefa");
				codProjeto = bd.rs.getInt("codProjeto");
				emailUser = bd.rs.getString("emailUser");
			}
			
			//Algumas condições caso o usuário não insira nada em algum campo, assim mantendo o que tinha anteriormente
			pstm = bd.con.prepareStatement(sql);
			if(tarefa.getNomeTarefa() != null && tarefa.getNomeTarefa() != "" && tarefa.getNomeTarefa() != " ") {				
				pstm.setString(1, tarefa.getNomeTarefa());
			}else {
				pstm.setString(1, nameTarefa);
			}
			
			if(tarefa.getDescricaoTarefa() != null && tarefa.getDescricaoTarefa() != "" && tarefa.getDescricaoTarefa() != " ") {				
				pstm.setString(2, tarefa.getDescricaoTarefa());
			}else {
				pstm.setString(2, descTarefa);
			}
			
			if(tarefa.getDataInicio() != null && tarefa.getDataInicio() != "" && tarefa.getDataInicio() != " ") {				
				pstm.setString(3, tarefa.getDataInicio());
			}else {
				pstm.setString(3, data_inic_tarefa);
			}
			
			if(tarefa.getDataFim() != null && tarefa.getDataFim() != "" && tarefa.getDataFim() != " ") {				
				pstm.setString(4, tarefa.getDataFim());
			}else {
				pstm.setString(4, data_final_tarefa);
			}

			if(tarefa.getCodProjeto() != 0) {				
				pstm.setInt(5, tarefa.getCodProjeto());
			}else {
				pstm.setInt(5, codProjeto);
			}

			if(tarefa.getEmailUser() != null && tarefa.getEmailUser() != "" && tarefa.getEmailUser() != " ") {				
				pstm.setString(6, tarefa.getEmailUser());
			}else {
				pstm.setString(6, emailUser);
			}
			
			pstm.setDouble(7, tarefa.getCodTarefa());

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
	public void delete(int codTarefa) {
		BD bd = new BD();

		String sql = "DELETE from tarefa where codTarefa = ?";

		boolean conn = false;
		PreparedStatement pstm = null;

		try {
			// criar uma conexão com o banco de dados
			conn = bd.getConnection();

			pstm = bd.con.prepareStatement(sql);
			pstm.setInt(1, codTarefa);

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
