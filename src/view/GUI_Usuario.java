package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Usuario;
import dao.UsuarioDAO;
import database.BD;

import javax.swing.JScrollBar;

public class GUI_Usuario {

	private JFrame frmUsurioGui;
	private JTextField tfNomeUser;
	private JTextField tfPassUser;
	private JTextField tfEmailUser;
	private JTextField tfFoneUser;
	private JLabel lblTelefoneUser;
	
	private DefaultTableModel model;
	
	UsuarioDAO userDao = new UsuarioDAO();
	private JTable tableUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Usuario window = new GUI_Usuario();
					window.frmUsurioGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Usuario() {
		initialize();
		atualizar();
	}

	// Atualizar tabela
	private void atualizar() {
		DefaultTableModel model = (DefaultTableModel) tableUser.getModel();
		model.getDataVector().removeAllElements();
        BD bd = new BD();
		
        String sql = "SELECT * FROM usuario";

        boolean conn = false;
        PreparedStatement pstm = null;

        try {
            // criar uma conexï¿½o com o banco de dados
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
                model.addRow(new Object[]{emailUser, nameUser, passwordUser, foneUser});
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally {
            // fechar as conexï¿½es
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
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUsurioGui = new JFrame();
		frmUsurioGui.setTitle("Usu\u00E1rio GUI\r\n");
		frmUsurioGui.setBounds(100, 100, 450, 645);
		frmUsurioGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUsurioGui.getContentPane().setLayout(null);
		
		tfNomeUser = new JTextField();
		tfNomeUser.setBounds(10, 176, 414, 20);
		frmUsurioGui.getContentPane().add(tfNomeUser);
		tfNomeUser.setColumns(10);
		
		JLabel lbNomeUser = new JLabel("Nome do Usu\u00E1rio");
		lbNomeUser.setBounds(10, 153, 207, 14);
		frmUsurioGui.getContentPane().add(lbNomeUser);
		
		JLabel lbPassUser = new JLabel("Senha");
		lbPassUser.setBounds(10, 99, 207, 14);
		frmUsurioGui.getContentPane().add(lbPassUser);
		
		tfPassUser = new JTextField();
		tfPassUser.setColumns(10);
		tfPassUser.setBounds(10, 122, 414, 20);
		frmUsurioGui.getContentPane().add(tfPassUser);
		
		JLabel lbEmailUser = new JLabel("E-mail do Usu\u00E1rio");
		lbEmailUser.setBounds(10, 45, 207, 14);
		frmUsurioGui.getContentPane().add(lbEmailUser);
		
		tfEmailUser = new JTextField();
		tfEmailUser.setColumns(10);
		tfEmailUser.setBounds(10, 68, 414, 20);
		frmUsurioGui.getContentPane().add(tfEmailUser);
		
		tfFoneUser = new JTextField();
		tfFoneUser.setColumns(10);
		tfFoneUser.setBounds(10, 230, 414, 20);
		frmUsurioGui.getContentPane().add(tfFoneUser);
		
		lblTelefoneUser = new JLabel("Telefone");
		lblTelefoneUser.setBounds(10, 207, 207, 14);
		frmUsurioGui.getContentPane().add(lblTelefoneUser);
		
		
		JButton btnCreate = new JButton("Criar Novo");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		Usuario usuarioCreate = new Usuario();
		 		
		 		if(tfEmailUser.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(null, "Digite um e-mail!");
		 		}else {		
			 		usuarioCreate.setEmail(tfEmailUser.getText());
		 		}

		 		if(tfNomeUser.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(null, "Digite um nome!");
		 		}else {		
			 		usuarioCreate.setNome(tfNomeUser.getText());
		 		}
		 		
		 		if(tfPassUser.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(null, "Digite uma senha!");
		 		}else {		
			 		usuarioCreate.setSenha(tfPassUser.getText());
		 		}
		 		
		 		if(tfFoneUser.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(null, "Digite um telefone!");
		 		}else {		
			 		usuarioCreate.setTelefone(tfFoneUser.getText());
		 		}
		 		
				userDao.create(usuarioCreate); 
				atualizar();
			}
		});
		btnCreate.setBounds(10, 261, 186, 23);
		frmUsurioGui.getContentPane().add(btnCreate);
		
		JButton btnUpdate = new JButton("Atualizar (Por E-mail)");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		Usuario usuarioUpdate = new Usuario();
		 		
		 		if(tfEmailUser.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(null, "Digite um e-mail!");
		 		}else {		 			
		 			usuarioUpdate.setEmail(tfEmailUser.getText());
		 		}
		 		
		 		if(tfNomeUser.getText().isEmpty()) {
		 			//Não set
		 		}else {		 			
		 			usuarioUpdate.setNome(tfNomeUser.getText());
		 		}
		 		
		 		if(tfPassUser.getText().isEmpty()) {
		 			//Não set
		 		}else {		 			
		 			usuarioUpdate.setSenha(tfPassUser.getText());
		 		}
		 		
		 		if(tfFoneUser.getText().isEmpty()) {
		 			//Não set
		 		}else {		 			
		 			usuarioUpdate.setTelefone(tfFoneUser.getText());
		 		}
		 		
				userDao.update(usuarioUpdate);
				atualizar();
			}
		});
		btnUpdate.setBounds(238, 261, 186, 23);
		frmUsurioGui.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Deletar (Por E-mail)");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfEmailUser.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(null, "Digite um e-mail!");
		 		}else {		
					userDao.delete(tfEmailUser.getText());
					atualizar();
		 		} 
			}
		});
		btnDelete.setBounds(238, 295, 186, 23);
		frmUsurioGui.getContentPane().add(btnDelete);
		
		JButton btnReadName = new JButton("Visualizar (Por Nome)");
		btnReadName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarNome();
			}
		});
		btnReadName.setBounds(238, 572, 186, 23);
		frmUsurioGui.getContentPane().add(btnReadName);
		
		JButton btnReadAll = new JButton("Visualizar");
		btnReadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnReadAll.setBounds(10, 572, 186, 23);
		frmUsurioGui.getContentPane().add(btnReadAll);
		
		JLabel lbTitle = new JLabel("CRUD GUI - USU\u00C1RIO");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbTitle.setBounds(10, 11, 414, 30);
		frmUsurioGui.getContentPane().add(lbTitle);
		
		JButton btnClear = new JButton("Limpar Tudo");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Text Field Clear
				tfEmailUser.setText("");
				tfNomeUser.setText("");
				tfPassUser.setText("");
				tfFoneUser.setText("");
				tfEmailUser.requestFocus();
			}
		});
		btnClear.setBounds(10, 295, 186, 23);
		frmUsurioGui.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 414, 232);
		frmUsurioGui.getContentPane().add(scrollPane);
		
		tableUser = new JTable(model);
		scrollPane.setViewportView(tableUser);
		tableUser.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"E-mail", "Nome", "Senha", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}
	
	// Atualizar tabela by nome
	private void atualizarNome() {
		DefaultTableModel model = (DefaultTableModel) tableUser.getModel();
		model.getDataVector().removeAllElements();
        BD bd = new BD();
		
        String sql = "SELECT emailUser, passwordUser, foneUser FROM usuario where nameUser = ?";

        boolean conn = false;
        PreparedStatement pstm = null;

        try {
            // criar uma conexï¿½o com o banco de dados
            conn = bd.getConnection();

            pstm = bd.con.prepareStatement(sql);
            pstm.setString(1, tfNomeUser.getText());
            
            // execute the query, and get a java resultset
            bd.rs = pstm.executeQuery();

            // iterate through the java resultset
            while (bd.rs.next()) {
                String emailUser = bd.rs.getString("emailUser");
                String passwordUser = bd.rs.getString("passwordUser");
                String foneUser = bd.rs.getString("foneUser");

                // print the results
                model.addRow(new Object[]{emailUser, tfNomeUser.getText(), passwordUser, foneUser});
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally {
            // fechar as conexï¿½es
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
