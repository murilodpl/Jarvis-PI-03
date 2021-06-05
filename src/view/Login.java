package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import database.BD;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Login {

	JFrame frmLogin;
	private JTextField tfEmail;
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
					window.frmLogin.setVisible(true);
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
		frmLogin = new JFrame();
		frmLogin.setTitle("Jarvis - Login");
		frmLogin.setBounds(100, 100, 520, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 52, 103, 23);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Jarvis");
		lblNewLabel.setBounds(10, 11, 484, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 26));
		frmLogin.getContentPane().add(lblNewLabel);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(10, 80, 484, 20);
		frmLogin.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 111, 103, 23);
		frmLogin.getContentPane().add(lblNewLabel_2);
		
		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(10, 139, 484, 20);
		frmLogin.getContentPane().add(tfPass);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BD bd = new BD();

				String email = tfEmail.getText();
				String pass = tfPass.getText();
		        String sql = "SELECT * FROM usuario where emailUser = ? and passwordUser = ?";

		        boolean conn = false;
		        PreparedStatement pstm = null;

		        try {
		            // criar uma conex�o com o banco de dados
		            conn = bd.getConnection();

		            pstm = bd.con.prepareStatement(sql);
		            pstm.setString(1, email);
		            pstm.setString(2, pass);
		            bd.rs = pstm.executeQuery();

		            // iterate through the java resultset
		            if (bd.rs.next()) {
		                //if username and password are true
		            	frmLogin.dispose();
		            	Home hpage = new Home();
		            	hpage.frmHome.setVisible(true);
		            }else {
		            	JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos!");
		            	tfEmail.setText("");
		            	tfPass.setText("");
		            	tfEmail.requestFocus();
		            }
		        } catch (Exception error) {
		        	JOptionPane.showMessageDialog(null, error);
		        } finally {
		            // fechar as conex�es
		            try {
		                if (pstm != null) {
		                    pstm.close();
		                }
		                if (conn == true) {
		                    bd.close();
		                }
		            } catch (Exception error) {
		            	JOptionPane.showMessageDialog(null, error);
		            }
		        }
				
				
			}
		});
		btnLogin.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnLogin.setBounds(10, 188, 223, 35);
		frmLogin.getContentPane().add(btnLogin);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	 			frmLogin.dispose();
            	CadastroUsuario cpage = new CadastroUsuario();
            	cpage.frmRegister.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnCadastrar.setBounds(271, 188, 223, 35);
		frmLogin.getContentPane().add(btnCadastrar);
	}
}
