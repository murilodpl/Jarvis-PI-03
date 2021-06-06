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

import classes.Tarefa;
import dao.TarefaDAO;
import database.BD;

public class TarefaGUI {

	JFrame frmTask;
	private JTable tableTask;
	private DefaultTableModel model;
	private JTextField tfNome;
	private JTextField tfDesc;
	private JTextField tfCod;
	
	Login lpage = new Login();
	TarefaDAO tarefaDao = new TarefaDAO();
	Tarefa tarefa = new Tarefa();
	private JTextField tfDataIni;
	private JTextField tfDataFinal;
	private JTextField tfCodProjeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarefaGUI window = new TarefaGUI();
					window.frmTask.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TarefaGUI() {
		initialize();
		atualizarTarefa();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTask = new JFrame();
		frmTask.setTitle("Jarvis - Tarefa");
		frmTask.setBounds(100, 100, 520, 623);
		frmTask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTask.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tarefas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 11, 484, 33);
		frmTask.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 484, 200);
		frmTask.getContentPane().add(scrollPane);
		tableTask = new JTable(model);
		tableTask.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Tarefa", "Nome", "Equipe", "Data inicial", "Data final", "C\u00F3digo Projeto"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableTask.getColumnModel().getColumn(0).setPreferredWidth(85);
		tableTask.getColumnModel().getColumn(1).setResizable(false);
		tableTask.getColumnModel().getColumn(2).setResizable(false);
		tableTask.getColumnModel().getColumn(5).setPreferredWidth(90);
		scrollPane.setViewportView(tableTask);
		
		JButton btnCreate = new JButton("Criar");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int c = 0;
				
		 		if(tfDesc.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			tarefa.setDescricaoTarefa(tfDesc.getText());
		 		}
		 		
		 		if(tfDataIni.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			tarefa.setDataInicio(tfDataIni.getText());
		 		}
		 		
		 		if(tfDataFinal.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			tarefa.setDataFim(tfDataFinal.getText());
		 		}
		 		
				if(tfCodProjeto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnCreate, "Digite o código do projeto!");
		 		}else {		 			
		 			tarefa.setCodProjeto(Integer.parseInt(tfCodProjeto.getText()));
		 			c++;
		 		}
		 		
		 		if(tfNome.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(btnCreate, "Digite um nome!");
		 		}else {		 			
		 			tarefa.setnomeTarefa(tfNome.getText());
		 			c++;
		 		}
		 		
		 		if(c == 2) {
		 			tarefa.setEmailUser(lpage.emailLogin);
		 			tarefaDao.create(tarefa);				
					JOptionPane.showMessageDialog(btnCreate, "Tarefa criado com sucesso!!");
		 			atualizarTarefa();
					clear();
		 		}
			}
		});
		btnCreate.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnCreate.setBounds(10, 497, 227, 32);
		frmTask.getContentPane().add(btnCreate);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfCod.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(btnDeletar, "Digite um código de tarefa!");
		 		}else {		 			
		 			tarefaDao.delete(Integer.parseInt(tfCod.getText()));
		 			JOptionPane.showMessageDialog(btnDeletar, "Tarefa deletado com sucesso!");
		 		}
				
				atualizarTarefa();
				clear();
			}
		});
		btnDeletar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnDeletar.setBounds(243, 266, 120, 32);
		frmTask.getContentPane().add(btnDeletar);
		
		JButton btnBackHome = new JButton("Voltar");
		btnBackHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTask.dispose();
				Home hpage = new Home();
				hpage.frmHome.setVisible(true);
			}
		});
		btnBackHome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnBackHome.setBounds(349, 540, 145, 32);
		frmTask.getContentPane().add(btnBackHome);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 348, 223, 20);
		frmTask.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 319, 34, 16);
		frmTask.getContentPane().add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblDescrio.setBounds(10, 379, 484, 16);
		frmTask.getContentPane().add(lblDescrio);
		
		tfDesc = new JTextField();
		tfDesc.setColumns(10);
		tfDesc.setBounds(10, 406, 484, 20);
		frmTask.getContentPane().add(tfDesc);
		
		JButton btnUpdate = new JButton("Atualizar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		if(tfDesc.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			tarefa.setDescricaoTarefa(tfDesc.getText());
		 		}
		 		
		 		if(tfDataIni.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			tarefa.setDataInicio(tfDataIni.getText());
		 		}
		 		
		 		if(tfDataFinal.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			tarefa.setDataFim(tfDataFinal.getText());
		 		}
		 		
		 		if(tfNome.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			tarefa.setnomeTarefa(tfNome.getText());
		 		}
		 		
				if(tfCodProjeto.getText().isEmpty()) {
		 			//Not set
		 		}else {		 			
		 			tarefa.setCodProjeto(Integer.parseInt(tfCodProjeto.getText()));
		 		}
				
				if(tfCod.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(null, "Digite o código da tarefa!");
		 		}else {		 			
		 			tarefa.setCodTarefa(Integer.parseInt(tfCod.getText()));
					tarefa.setEmailUser(lpage.emailLogin);
					
					tarefaDao.update(tarefa);
					JOptionPane.showMessageDialog(btnUpdate, "Tarefa atualizado com sucesso!");
					atualizarTarefa();
		 		}

			}
		});
		btnUpdate.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnUpdate.setBounds(267, 497, 227, 32);
		frmTask.getContentPane().add(btnUpdate);
		
		tfCod = new JTextField();
		tfCod.setBounds(138, 266, 95, 32);
		frmTask.getContentPane().add(tfCod);
		tfCod.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo da Tarefa:");
		lblCdigo.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblCdigo.setBounds(10, 274, 118, 16);
		frmTask.getContentPane().add(lblCdigo);
		btnDeletar.setBackground(Color.getHSBColor(0F,  0.4F,  1.0F));
		
		JButton btnClear = new JButton("Limpar Campos");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnClear.setBounds(10, 540, 145, 32);
		frmTask.getContentPane().add(btnClear);
		
		tfDataIni = new JTextField();
		tfDataIni.setColumns(10);
		tfDataIni.setBounds(10, 466, 227, 20);
		frmTask.getContentPane().add(tfDataIni);
		
		JLabel lblDataInicial = new JLabel("Data inicial (YYYY-MM-DD)");
		lblDataInicial.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblDataInicial.setBounds(10, 437, 227, 16);
		frmTask.getContentPane().add(lblDataInicial);
		
		JLabel lblDataFinal = new JLabel("Data final (YYYY-MM-DD)");
		lblDataFinal.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblDataFinal.setBounds(267, 437, 227, 16);
		frmTask.getContentPane().add(lblDataFinal);
		
		tfDataFinal = new JTextField();
		tfDataFinal.setColumns(10);
		tfDataFinal.setBounds(267, 466, 227, 20);
		frmTask.getContentPane().add(tfDataFinal);
		
		tfCodProjeto = new JTextField();
		tfCodProjeto.setColumns(10);
		tfCodProjeto.setBounds(267, 348, 227, 20);
		frmTask.getContentPane().add(tfCodProjeto);
		
		JLabel lblCdigoDoProjeto = new JLabel("C\u00F3digo do Projeto:");
		lblCdigoDoProjeto.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblCdigoDoProjeto.setBounds(267, 319, 188, 16);
		frmTask.getContentPane().add(lblCdigoDoProjeto);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnVer, tableTask.getValueAt(tableTask.getSelectedRow(), tableTask.getSelectedColumn()).toString());
			}
		});
		btnVer.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnVer.setBounds(374, 266, 120, 32);
		frmTask.getContentPane().add(btnVer);
	}
	
	//Limpa campos
	private void clear() {
		tfCod.setText("");
		tfNome.setText("");
		tfDesc.setText("");
		tfDataIni.setText("");
		tfDataFinal.setText("");
		tfCodProjeto.setText("");
		tfCod.requestFocus();
		tarefa.clear();
	}
	// Atualizar tabela
	private void atualizarTarefa() {
		model = (DefaultTableModel) tableTask.getModel();
		model.getDataVector().removeAllElements();
		BD bd = new BD();

		String sql = "SELECT codTarefa, nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, codProjeto FROM tarefa where emailUser = ? ";

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
				int codTarefa = bd.rs.getInt("codTarefa");
				String nameTarefa = bd.rs.getString("nameTarefa");
				String descTarefa = bd.rs.getString("descTarefa");
				String data_inic_tarefa = bd.rs.getString("data_inic_tarefa");
				String data_final_tarefa = bd.rs.getString("data_final_tarefa");
				int codProjeto = bd.rs.getInt("codProjeto");

				// print the results
				model.addRow(new Object[] { codTarefa, nameTarefa, descTarefa, data_inic_tarefa, data_final_tarefa, codProjeto });
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
