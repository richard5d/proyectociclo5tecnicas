package guiIniciarSesion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;

import javax.swing.SwingConstants;

import arreglos.ArregloUsuarios;
import entidad.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class GUIIniciarSesion extends JPanel implements ActionListener{
	
	public PropertyChangeSupport support = new PropertyChangeSupport(this);
	private Object[][] usuarios=new Object[100][2];
	private JTextField txtEmail;
	private JTextField txtPassword;
	public JButton btnIniciarSesion;
	public JButton btnCrearCuenta;
	public JButton btnSalirDelSistema;

	/**
	 * Create the panel.
	 */
	public GUIIniciarSesion() {
		setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("INICIAR SESION");
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesion.setFont(new Font("Arial", Font.BOLD, 15));
		lblIniciarSesion.setBounds(0, 26, 636, 58);
		add(lblIniciarSesion);
		
		JLabel lblEmail = new JLabel("EMAIL : ");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(168, 109, 70, 14);
		add(lblEmail);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(168, 140, 92, 14);
		add(lblPassword);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(273, 106, 171, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(273, 137, 171, 20);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setBackground(Color.LIGHT_GRAY);
		btnIniciarSesion.setBounds(170, 182, 274, 23);
		btnIniciarSesion.addActionListener(this);
		add(btnIniciarSesion);
		
		JLabel lblNoTienesCuenta = new JLabel("¿No tienes Cuenta?");
		lblNoTienesCuenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNoTienesCuenta.setBounds(168, 216, 153, 14);
		add(lblNoTienesCuenta);
		
		btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearCuenta.setBorder(null);
		btnCrearCuenta.setSelected(true);
		btnCrearCuenta.setBackground(Color.LIGHT_GRAY);
		btnCrearCuenta.setBounds(331, 210, 113, 29);
		add(btnCrearCuenta);
		
		btnSalirDelSistema = new JButton("SALIR");
		btnSalirDelSistema.setBorderPainted(false);
		btnSalirDelSistema.setBackground(Color.LIGHT_GRAY);
		btnSalirDelSistema.setBounds(537, 11, 89, 23);
		add(btnSalirDelSistema);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.btnIniciarSesion) {
			String email=this.txtEmail.getText();
			String password=this.txtPassword.getText();
			if(email.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "CAMPOS VACIOS");
				return;
			}
			try {
				
				Usuario usuario =ArregloUsuarios.buscar(email, password);
				if(usuario !=null) {
					support.firePropertyChange("botonPresionado", null, "¡Evento lanzado!");
				}else {
					JOptionPane.showMessageDialog(null, "CREDENCIALES INCORRECTOS");
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "ALGO SALIO MAL");
			}	
		}
	}
}
