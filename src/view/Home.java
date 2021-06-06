package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import database.BD;

import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Home {

	JFrame frmHome;
	private JTable tableTasks;
	private DefaultTableModel model;
	
	Login lpage = new Login();
	String orderBy = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
		atualizar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setTitle("Jarvis - Home");
		frmHome.setBounds(100, 100, 520, 532);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Jarvis");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 484, 46);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 40));
		frmHome.getContentPane().add(lblNewLabel);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.dispose();
				lpage.emailLogin = "";
				lpage.frmLogin.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnLogout.setBounds(344, 448, 150, 34);
		frmHome.getContentPane().add(btnLogout);
		btnLogout.setBackground(Color.getHSBColor(0F,  0.4F,  1.0F));
		
		JButton btnCreateProj = new JButton("Criar Projeto");
		btnCreateProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.dispose();
				ProjetoGUI cProjpage = new ProjetoGUI();
				cProjpage.frmProjeto.setVisible(true);
			}
		});
		btnCreateProj.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnCreateProj.setBounds(10, 448, 150, 34);
		frmHome.getContentPane().add(btnCreateProj);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 484, 184);
		frmHome.getContentPane().add(scrollPane);

		tableTasks = new JTable(model);
		scrollPane.setViewportView(tableTasks);
		tableTasks.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Tarefa", "Nome Tarefa", "Descri\u00E7\u00E3o", "Data Inicio", "Data Final", "C\u00F3digo Projeto"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTasks.getColumnModel().getColumn(0).setResizable(false);
		tableTasks.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableTasks.getColumnModel().getColumn(1).setResizable(false);
		tableTasks.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableTasks.getColumnModel().getColumn(2).setResizable(false);
		tableTasks.getColumnModel().getColumn(2).setPreferredWidth(90);
		tableTasks.getColumnModel().getColumn(3).setResizable(false);
		tableTasks.getColumnModel().getColumn(3).setPreferredWidth(65);
		tableTasks.getColumnModel().getColumn(4).setResizable(false);
		tableTasks.getColumnModel().getColumn(4).setPreferredWidth(65);
		tableTasks.getColumnModel().getColumn(5).setResizable(false);
		tableTasks.getColumnModel().getColumn(5).setPreferredWidth(85);
		scrollPane.setViewportView(tableTasks);
		
		JButton btnOrderByNome = new JButton("Nome");
		btnOrderByNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderBy = "order by nameTarefa";
				atualizar();
			}
		});
		btnOrderByNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnOrderByNome.setBounds(344, 315, 150, 34);
		frmHome.getContentPane().add(btnOrderByNome);
		
		JButton btnOrderByCod = new JButton("C\u00F3digo Tarefa");
		btnOrderByCod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderBy = "order by codTarefa";
				atualizar();
			}
		});
		btnOrderByCod.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnOrderByCod.setBounds(10, 315, 150, 34);
		frmHome.getContentPane().add(btnOrderByCod);
		
		JLabel lblNewLabel_1 = new JLabel("Ordenar por:");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 293, 77, 16);
		frmHome.getContentPane().add(lblNewLabel_1);
		
		JButton btnCdigoProjeto = new JButton("C\u00F3digo Projeto");
		btnCdigoProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderBy = "order by codProjeto";
				atualizar();
			}
		});
		btnCdigoProjeto.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnCdigoProjeto.setBounds(170, 315, 164, 34);
		frmHome.getContentPane().add(btnCdigoProjeto);
		
		JButton btnCreateTarefa = new JButton("Criar Tarefa");
		btnCreateTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.dispose();
				TarefaGUI cTaskpage = new TarefaGUI();
				cTaskpage.frmTask.setVisible(true);
			}
		});
		btnCreateTarefa.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnCreateTarefa.setBounds(170, 448, 164, 34);
		frmHome.getContentPane().add(btnCreateTarefa);
		
		JButton btnSee = new JButton("Ver");
		btnSee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnSee, tableTasks.getValueAt(tableTasks.getSelectedRow(), tableTasks.getSelectedColumn()).toString());
			}
		});
		btnSee.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnSee.setBounds(10, 387, 484, 34);
		frmHome.getContentPane().add(btnSee);
		
		JLabel lblNewLabel_1_1 = new JLabel("Selecione uma celula e veja ela inteira:");
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 360, 255, 16);
		frmHome.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tarefas com a data final pr\u00F3xima:");
		lblNewLabel_1_2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 68, 484, 25);
		frmHome.getContentPane().add(lblNewLabel_1_2);
	}

	// Atualizar tabela
	private void atualizar() {
		model = (DefaultTableModel) tableTasks.getModel();
		model.getDataVector().removeAllElements();
		BD bd = new BD();

		String sql = "SELECT codTarefa, nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, codProjeto FROM tarefa where emailUser = ? and data_final_tarefa between curdate() and curdate()+7 " + orderBy;

		boolean conn = false;
		PreparedStatement pstm = null;

		try {
			// criar uma conex�o com o banco de dados
			conn = bd.getConnection();

			pstm = bd.con.prepareStatement(sql);
			pstm.setString(1, lpage.emailLogin);

			// execute the query, and get a java resultset
			bd.rs = pstm.executeQuery();

			// iterate through the java resultset
			while (bd.rs.next()) {
				int codTarefa = bd.rs.getInt("codTarefa");
				String nameTarefa = bd.rs.getString("nameTarefa");
				String descTarefa = bd.rs.getString("descTarefa");
				Date data_inic_tarefa = bd.rs.getDate("data_inic_tarefa");
				Date data_final_tarefa = bd.rs.getDate("data_final_tarefa");
				int codProjeto = bd.rs.getInt("codProjeto");

				// print the results
				model.addRow(new Object[] { codTarefa, nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa,
						codProjeto });
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
}