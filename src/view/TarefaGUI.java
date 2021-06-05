package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TarefaGUI {

	JFrame frmTask;
	private JTable table;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTask = new JFrame();
		frmTask.setTitle("Jarvis - Tarefa");
		frmTask.setBounds(100, 100, 520, 525);
		frmTask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTask.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jarvis");
		lblNewLabel.setBounds(234, 11, 28, 14);
		frmTask.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tarefas");
		lblNewLabel_1.setBounds(10, 32, 46, 14);
		frmTask.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 484, 253);
		frmTask.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Descri\u00E7\u00E3o", "Data In\u00EDcio", "Data Entrega", "Email Usu\u00E1rio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnBackHome = new JButton("Voltar");
		btnBackHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTask.dispose();
				Home hpage = new Home();
				hpage.frmHome.setVisible(true);
			}
		});
		btnBackHome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnBackHome.setBounds(393, 450, 101, 25);
		frmTask.getContentPane().add(btnBackHome);
	}

}
