package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class Projeto {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projeto window = new Projeto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Projeto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jarvis ");
		lblNewLabel.setBounds(233, 11, 31, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Projetos");
		lblNewLabel_1.setBounds(10, 30, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 484, 228);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Descri\u00E7\u00E3o", "Equpe"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.setBounds(10, 294, 152, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Entra com c\u00F3digo");
		btnNewButton_1.setBounds(180, 294, 152, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(342, 294, 152, 23);
		frame.getContentPane().add(btnDeletar);
	}
}
