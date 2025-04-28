package guiIniciarSesion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class GUIContenedor extends JFrame implements ActionListener{

	private CardLayout cardLayout;
	private JPanel contentPane;
	
	private JPanel guiIniciarSesion;
	private JPanel guiCrearCuenta;
	private JPanel guiSistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIContenedor frame = new GUIContenedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIContenedor() {
		setTitle("SISTEMA DE INSCRIPCION DE CURSOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		guiIniciarSesion=new GUIIniciarSesion();
		guiCrearCuenta=new GUICrearCuenta();
		guiSistema= new GUISistema();
		
		contentPane.add(guiIniciarSesion, "iniciarsesion");
		contentPane.add(guiCrearCuenta, "crearcuenta");
		contentPane.add(guiSistema, "sistema");
		
		//((GUIIniciarSesion) this.guiIniciarSesion).btnIniciarSesion.addActionListener(this);
		((GUIIniciarSesion) this.guiIniciarSesion).support.addPropertyChangeListener("botonPresionado", evt -> {
            System.out.println("Escuchado evento: " + evt.getNewValue());
            cardLayout.show(this.contentPane, "sistema");
        });
		((GUIIniciarSesion) this.guiIniciarSesion).btnCrearCuenta.addActionListener(this);
		((GUIIniciarSesion) this.guiIniciarSesion).btnSalirDelSistema.addActionListener(this);
		
		
		((GUICrearCuenta) this.guiCrearCuenta).btnIniciarSesion.addActionListener(this);
		
		((GUISistema) this.guiSistema).mntmCerrarSesion.addActionListener(this);
		((GUISistema) this.guiSistema).mntmSalirSistema.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*if(e.getSource()==((GUIIniciarSesion) this.guiIniciarSesion).btnIniciarSesion) {
			cardLayout.show(this.contentPane, "sistema");
			int ancho = contentPane.getWidth();
			int alto = contentPane.getHeight();
			System.out.println(ancho);
			System.out.println(alto);

		}*/
		if(e.getSource()==((GUIIniciarSesion) this.guiIniciarSesion).btnCrearCuenta) cardLayout.show(this.contentPane, "crearcuenta");
		if(e.getSource()==((GUICrearCuenta) this.guiCrearCuenta).btnIniciarSesion) cardLayout.show(this.contentPane, "iniciarsesion");

		
		//salir del sistema osea del programa, cerrar todo
		if(e.getSource()==((GUISistema) this.guiSistema).mntmSalirSistema) {
			int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta Seguro de salir?","--ALERTA--",JOptionPane.YES_NO_OPTION);
			if(respuesta==JOptionPane.YES_OPTION) {
				System.out.println("Saliendo del programa o sistema");
				//System.exit(0);
				dispose();
			}else {
				System.out.println("se nego a salir");
			}
		}
		//cerrar sesion
		if(e.getSource()==((GUISistema) this.guiSistema).mntmCerrarSesion) {
			System.out.println("Cerrando Sesion");
			int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta Seguro de Cerrar Sesion?","--ALERTA--",JOptionPane.YES_NO_OPTION);
			if(respuesta==JOptionPane.YES_OPTION) {
				System.out.println("Cerrando Sesion");
				//System.exit(0);
				//dispose();
				cardLayout.show(this.contentPane, "iniciarsesion");
			}else {
				System.out.println("se nego a cerrar sesion");
			}
					
		}
		if(e.getSource()==((GUIIniciarSesion) this.guiIniciarSesion).btnSalirDelSistema) {
			int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta Seguro de salir?","--ALERTA--",JOptionPane.YES_NO_OPTION);
			if(respuesta==JOptionPane.YES_OPTION) {
				System.out.println("Saliendo del programa o sistema");
				//System.exit(0);
				dispose();
			}else {
				System.out.println("se nego a salir");
			}
		}
	}

}
