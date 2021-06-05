package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import classes.Usuario;
import database.BD;

public class UsuarioDAO {

    /*
     * CRUD CREATE READ UPDATE DELETE
     */

    // Create
    public void create(Usuario usuario) {
        BD bd = new BD();

        String sql = "INSERT INTO usuario(emailUser, passwordUser, nameUser, foneUser) VALUES(?, ?, ?, ?)";

        boolean conn = false;
        PreparedStatement pstm = null;

        try {
            // criar uma conex�o com o banco de dados
            conn = bd.getConnection();

            pstm = bd.con.prepareStatement(sql);
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getSenha());
            pstm.setString(3, usuario.getNome());
            pstm.setString(4, usuario.getTelefone());

            // executar a query
            pstm.execute();
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally {
            // fechar as conex�es
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
    public void read(String emailUser) {
        BD bd = new BD();

        String sql = "SELECT passwordUser, nameUser, foneUser FROM usuario where emailUser = ?";

        boolean conn = false;
        PreparedStatement pstm = null;

        try {
            // criar uma conex�o com o banco de dados
            conn = bd.getConnection();

            pstm = bd.con.prepareStatement(sql);
            pstm.setString(1, emailUser);
            bd.rs = pstm.executeQuery();

            // iterate through the java resultset
            while (bd.rs.next()) {
                String passwordUser = bd.rs.getString("passwordUser");
                String nameUser = bd.rs.getString("nameUser");
                String foneUser = bd.rs.getString("foneUser");

                // print the results
                System.out.format("%s, %s, %s, %s\n", emailUser, passwordUser, nameUser, foneUser);
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally {
            // fechar as conex�es
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
        
        String[] user;
        String sql = "SELECT * FROM usuario";

        boolean conn = false;
        PreparedStatement pstm = null;

        try {
            // criar uma conex�o com o banco de dados
            conn = bd.getConnection();

            pstm = bd.con.prepareStatement(sql);

            // execute the query, and get a java resultset
            bd.rs = pstm.executeQuery();

            // iterate through the java resultset
            while (bd.rs.next()) {
                String emailUser = bd.rs.getString("emailUser");
                String passwordUser = bd.rs.getString("passwordUser");
                String nameUser = bd.rs.getString("nameUser");
                String foneUser = bd.rs.getString("foneUser");

                // print the results
                System.out.format("%s, %s, %s, %s\n", emailUser, passwordUser, nameUser, foneUser);
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally {
            // fechar as conex�es
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
    public void update(Usuario usuario) {
        BD bd = new BD();

        String sqlRead = "SELECT passwordUser, nameUser, foneUser FROM usuario where emailUser = ?";
        String sql = "UPDATE usuario SET passwordUser = ?, nameUser = ?, foneUser = ? where emailUser = ?";

        String passwordUser = "", nameUser = "", foneUser = "";
        boolean conn = false;
        PreparedStatement pstm = null, pstmRead = null;

        try {
            // criar uma conex�o com o banco de dados
            conn = bd.getConnection();

            pstmRead = bd.con.prepareStatement(sqlRead);
            pstmRead.setString(1, usuario.getEmail());
            bd.rs = pstmRead.executeQuery();

            // iterate through the java resultset
            while (bd.rs.next()) {
                passwordUser = bd.rs.getString("passwordUser");
                nameUser = bd.rs.getString("nameUser");
                foneUser = bd.rs.getString("foneUser");
            }

            // Algumas condi��es caso o usu�rio n�o insira nada em algum campo, assim
            // mantendo o que tinha anteriormente
            pstm = bd.con.prepareStatement(sql);
            if (usuario.getSenha() != null && usuario.getSenha() != "" && usuario.getSenha() != " ") {
                pstm.setString(1, usuario.getSenha());
            } else {
                pstm.setString(1, passwordUser);
            }

            if (usuario.getNome() != null && usuario.getNome() != "" && usuario.getNome() != " ") {
                pstm.setString(2, usuario.getNome());
            } else {
                pstm.setString(2, nameUser);
            }

            if (usuario.getTelefone() != null && usuario.getTelefone() != "" && usuario.getTelefone() != " ") {
                pstm.setString(3, usuario.getTelefone());
            } else {
                pstm.setString(3, foneUser);
            }

            pstm.setString(4, usuario.getEmail());
            
            // executar a query
            pstm.executeUpdate();
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally {
            // fechar as conex�es
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
    public void delete(String emailUser) {
        BD bd = new BD();

        String sql = "DELETE from usuario where emailUser = ?";

        boolean conn = false;
        PreparedStatement pstm = null;

        try {
            // criar uma conex�o com o banco de dados
            conn = bd.getConnection();

            pstm = bd.con.prepareStatement(sql);
            pstm.setString(1, emailUser);

            // executar a query
            pstm.executeUpdate();
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally {
            // fechar as conex�es
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
