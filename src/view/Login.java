package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

	private JFrame frmJarvis;
	private JTextField tfUser;
	private JLabel lblNewLabel_2;
	private JTextField tfPass;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmJarvis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJarvis = new JFrame();
		frmJarvis.setTitle("Jarvis");
		frmJarvis.setBounds(100, 100, 520, 300);
		frmJarvis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJarvis.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 52, 103, 23);
		frmJarvis.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Jarvis - Login");
		lblNewLabel.setBounds(10, 11, 484, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 26));
		frmJarvis.getContentPane().add(lblNewLabel);
		
		tfUser = new JTextField();
		tfUser.setBounds(10, 80, 484, 20);
		frmJarvis.getContentPane().add(tfUser);
		tfUser.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 111, 103, 23);
		frmJarvis.getContentPane().add(lblNewLabel_2);
		
		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(10, 139, 484, 20);
		frmJarvis.getContentPane().add(tfPass);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnLogin.setBounds(10, 188, 223, 35);
		frmJarvis.getContentPane().add(btnLogin);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnCadastrar.setBounds(271, 188, 223, 35);
		frmJarvis.getContentPane().add(btnCadastrar);
	}
}
