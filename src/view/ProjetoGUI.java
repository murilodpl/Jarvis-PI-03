package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import classes.Projeto;
import dao.ProjetoDAO;
import database.BD;

public class ProjetoGUI {

	JFrame frmProjeto;
	private JTable table;
	private DefaultTableModel model;
	private JTextField tfNome;
	private JTextField tfEquipe;
	private JTextField tfDesc;
	private JTextField tfCod;
	
	Login lpage = new Login();
	ProjetoDAO projetoDao = new ProjetoDAO();
	Projeto projeto = new Projeto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjetoGUI window = new ProjetoGUI();
					window.frmProjeto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjetoGUI() {
		initialize();
		atualizarProj();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjeto = new JFrame();
		frmProjeto.setTitle("Jarvis - Projeto");
		frmProjeto.setBounds(100, 100, 520, 562);
		frmProjeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjeto.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Projetos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 11, 484, 33);
		frmProjeto.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 484, 200);
		frmProjeto.getContentPane().add(scrollPane);
		table = new JTable(model);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Descri\u00E7\u00E3o", "Equipe"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton btnCreate = new JButton("Criar");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfDesc.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			projeto.setDescricaoProjeto(tfDesc.getText());
		 		}
		 		
		 		if(tfEquipe.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			projeto.setEquipeProjeto(tfEquipe.getText());
		 		}
		 		
		 		if(tfNome.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(btnCreate, "Digite um nome!");
		 		}else {		 			
		 			projeto.setNomeProjeto(tfNome.getText());
		 			projeto.setEmailUser(lpage.emailLogin);
		 			projetoDao.create(projeto);				
					JOptionPane.showMessageDialog(btnCreate, "Projeto criado com sucesso!!");
		 			atualizarProj();
					clear();
		 		}
			}
		});
		btnCreate.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnCreate.setBounds(10, 437, 227, 32);
		frmProjeto.getContentPane().add(btnCreate);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfCod.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(btnDeletar, "Digite um código!");
		 		}else {		 			
		 			projetoDao.delete(Integer.parseInt(tfCod.getText()));
		 			JOptionPane.showMessageDialog(btnDeletar, "Projeto deletado com sucesso!");
		 		}
				
				atualizarProj();
				clear();
			}
		});
		btnDeletar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnDeletar.setBounds(164, 266, 162, 32);
		frmProjeto.getContentPane().add(btnDeletar);
		
		JButton btnBackHome = new JButton("Voltar");
		btnBackHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProjeto.dispose();
				Home hpage = new Home();
				hpage.frmHome.setLocationRelativeTo(null);
				hpage.frmHome.setVisible(true);
			}
		});
		btnBackHome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnBackHome.setBounds(349, 480, 145, 32);
		frmProjeto.getContentPane().add(btnBackHome);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 348, 227, 20);
		frmProjeto.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 319, 34, 16);
		frmProjeto.getContentPane().add(lblNewLabel);
		
		tfEquipe = new JTextField();
		tfEquipe.setColumns(10);
		tfEquipe.setBounds(267, 348, 227, 20);
		frmProjeto.getContentPane().add(tfEquipe);
		
		JLabel lblEquipe = new JLabel("Equipe");
		lblEquipe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblEquipe.setBounds(267, 319, 227, 16);
		frmProjeto.getContentPane().add(lblEquipe);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblDescrio.setBounds(10, 379, 484, 16);
		frmProjeto.getContentPane().add(lblDescrio);
		
		tfDesc = new JTextField();
		tfDesc.setColumns(10);
		tfDesc.setBounds(10, 406, 484, 20);
		frmProjeto.getContentPane().add(tfDesc);
		
		JButton btnUpdate = new JButton("Atualizar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfCod.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(btnUpdate, "Digite um código!");
		 		}else {		 			
		 			projeto.setCodProjeto(Integer.parseInt(tfCod.getText()));
		 		}

		 		if(tfDesc.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			projeto.setDescricaoProjeto(tfDesc.getText());
		 		}
		 		
		 		if(tfEquipe.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			projeto.setEquipeProjeto(tfEquipe.getText());
		 		}
		 		
		 		if(tfNome.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			projeto.setNomeProjeto(tfNome.getText());
		 			projeto.setEmailUser(lpage.emailLogin);
		 			
		 			projetoDao.update(projeto);
		 			JOptionPane.showMessageDialog(btnUpdate, "Projeto atualizado com sucesso!");
		 			atualizarProj();
		 		}
			}
		});
		btnUpdate.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnUpdate.setBounds(267, 437, 227, 32);
		frmProjeto.getContentPane().add(btnUpdate);
		
		tfCod = new JTextField();
		tfCod.setBounds(60, 266, 95, 32);
		frmProjeto.getContentPane().add(tfCod);
		tfCod.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblCdigo.setBounds(10, 274, 43, 16);
		frmProjeto.getContentPane().add(lblCdigo);
		btnDeletar.setBackground(Color.getHSBColor(0F,  0.4F,  1.0F));
		
		JButton btnClear = new JButton("Limpar Campos");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnClear.setBounds(10, 480, 145, 32);
		frmProjeto.getContentPane().add(btnClear);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnVer, table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString());
			}
		});
		btnVer.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnVer.setBounds(332, 266, 162, 32);
		frmProjeto.getContentPane().add(btnVer);
	}
	
	//Limpa campos
	private void clear() {
		tfCod.setText("");
		tfNome.setText("");
		tfDesc.setText("");
		tfEquipe.setText("");		
		tfCod.requestFocus();
		projeto.clear();
	}
	// Atualizar tabela
	private void atualizarProj() {
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
		BD bd = new BD();

		String sql = "SELECT codProjeto, nameProj, descProj, equipeProj FROM projeto where emailUser = ? ";

		boolean conn = false;

		PreparedStatement pstm = null;

		try {
			// criar uma conexï¿½o com o banco de dados
			conn = bd.getConnection();

			pstm = bd.con.prepareStatement(sql);
			pstm.setString(1, lpage.emailLogin);

			// execute the query, and get a java resultset
			bd.rs = pstm.executeQuery();

			// iterate through the java resultset
			while (bd.rs.next()) {
				int codProjeto = bd.rs.getInt("codProjeto");
				String nameProj = bd.rs.getString("nameProj");
				String descProj = bd.rs.getString("descProj");
				String equipeProj = bd.rs.getString("equipeProj");

				// print the results
				model.addRow(new Object[] { codProjeto, nameProj, descProj, equipeProj });
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
