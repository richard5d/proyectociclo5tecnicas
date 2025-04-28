package guiIniciarSesion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import arreglos.ArregloUsuarios;
import entidad.Usuario;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;

public class GUICrearCuenta extends JPanel implements ActionListener{
	public JButton btnIniciarSesion;
	private JButton btnCrearCuenta;
	private JTextField txtEmail;
	private JTextField txtPassword;
	
	

	/**
	 * Create the panel.
	 */
	public GUICrearCuenta() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREAR CUENTA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 101, 636, 31);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("¿Tienes Cuenta?");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(155, 314, 154, 14);
		add(lblNewLabel_2);
		
		btnIniciarSesion = new JButton("IR A INICIAR SESION");
		btnIniciarSesion.setBackground(Color.LIGHT_GRAY);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setBounds(302, 311, 178, 23);
		add(btnIniciarSesion);
		
		btnCrearCuenta = new JButton("CREAR CUENTA");
		btnCrearCuenta.setBackground(Color.LIGHT_GRAY);
		btnCrearCuenta.setBorderPainted(false);
		btnCrearCuenta.setBounds(223, 266, 181, 23);
		btnCrearCuenta.addActionListener(this);
		add(btnCrearCuenta);
		
		JLabel lblEmail = new JLabel("EMAIL : ");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(201, 168, 101, 14);
		add(lblEmail);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(201, 213, 101, 14);
		add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(291, 162, 147, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(291, 207, 147, 20);
		add(txtPassword);
		txtPassword.setColumns(10);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnCrearCuenta) {
			System.out.println("en crear cuenta");
			String email=this.txtEmail.getText();
			String password=this.txtPassword.getText();
			if(email.equals("") || password.equals("")) {
				System.out.println("Campos vacios");
				return;
			}
			
			Usuario usuario=new Usuario(email,password);
			
			ArregloUsuarios.adicionar(usuario);
			JOptionPane.showMessageDialog(null, "REGISTRADO CORRECTAMENTE");
			this.txtEmail.setText("");
			this.txtPassword.setText("");
			
		}
	}
}
