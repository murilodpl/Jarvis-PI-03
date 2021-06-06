package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import classes.Usuario;
import dao.UsuarioDAO;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CadastroUsuario {

	JFrame frmRegister;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JTextField tfUsername;
	
	Usuario usuario = new Usuario();
	UsuarioDAO userDao = new UsuarioDAO();	
	Login lpage = new Login();
	private JPasswordField tfPass;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario window = new CadastroUsuario();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setTitle("Jarvis - Cadastro");
		frmRegister.setBounds(100, 100, 520, 400);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 484, 27);
		frmRegister.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail*");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 49, 484, 14);
		frmRegister.getContentPane().add(lblNewLabel_1);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(10, 74, 484, 20);
		frmRegister.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha*");
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 161, 484, 14);
		frmRegister.getContentPane().add(lblNewLabel_1_1);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(10, 242, 484, 20);
		frmRegister.getContentPane().add(tfPhone);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefone*");
		lblNewLabel_1_1_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 217, 484, 14);
		frmRegister.getContentPane().add(lblNewLabel_1_1_1);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(10, 130, 484, 20);
		frmRegister.getContentPane().add(tfUsername);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome do Usu\u00E1rio*");
		lblNewLabel_1_2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 105, 484, 14);
		frmRegister.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c = 0; 
				
		 		if(tfEmail.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(btnRegister, "Digite um e-mail!");
		 		}else {		
		 			usuario.setEmail(tfEmail.getText());
		 			c++;
		 		}

		 		if(tfUsername.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(btnRegister, "Digite um nome!");
		 		}else {		
		 			usuario.setNome(tfUsername.getText());
		 			c++;
		 		}
		 		
		 		if(tfPass.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(btnRegister, "Digite uma senha!");
		 		}else {		
		 			usuario.setSenha(tfPass.getText());
		 			c++;
		 		}
		 		
		 		if(tfPhone.getText().isEmpty()) {
		 			JOptionPane.showMessageDialog(btnRegister, "Digite um telefone!");
		 		}else {		
		 			usuario.setTelefone(tfPhone.getText());
		 			c++;
		 		}
		 		
		 		if(c == 4) {
		 			frmRegister.dispose();
		 			lpage.frmLogin.setLocationRelativeTo(null);
	            	lpage.frmLogin.setVisible(true);
		 		}
				userDao.create(usuario); 
			}
		});
		btnRegister.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnRegister.setBounds(10, 289, 233, 37);
		frmRegister.getContentPane().add(btnRegister);
		
		JButton btnBack = new JButton("Voltar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	 			frmRegister.dispose();
	 			lpage.frmLogin.setLocationRelativeTo(null);
            	lpage.frmLogin.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnBack.setBounds(261, 289, 233, 37);
		frmRegister.getContentPane().add(btnBack);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(10, 186, 484, 20);
		frmRegister.getContentPane().add(tfPass);
	}

}
