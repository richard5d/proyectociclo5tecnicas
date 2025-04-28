package guiIniciarSesion;

import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import guiSistema.GUIAlumno;
import guiSistema.GUICursos;
import guiSistema.GUIPrincipal;
import guiSistema.GUIProfesores;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

public class GUISistema extends JPanel implements ActionListener{
	private CardLayout cardLayout;
	private JPanel panelContenedor;
	
	private JPanel guiPrincipal;
	private JPanel guiAlumnos;
	private JPanel guiCursos;
	private JPanel guiProfesores;
	
	
	private JMenuItem mntmRegistrar;
	private JMenuItem mntmPago;
	private JMenuItem mntmCursosInscritos;
	private JMenuItem mntmNewMenuItem;
	
	
	public JMenuItem mntmSalirSistema;
	public JMenuItem mntmCerrarSesion;
	/**
	 * Create the panel.
	 */
	public GUISistema() {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("Alumno");
		menuBar.add(mnNewMenu);
		
		mntmRegistrar = new JMenuItem("Registrar");
		mnNewMenu.add(mntmRegistrar);
		mntmRegistrar.addActionListener(this);
		
		mntmPago = new JMenuItem("Pago");
		mnNewMenu.add(mntmPago);
		
		
		mntmCursosInscritos = new JMenuItem("Cursos Inscritos");
		mnNewMenu.add(mntmCursosInscritos);
		mntmCursosInscritos.addActionListener(this);
		
		JMenu mnNewMenu_1 = new JMenu("Cursos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Elegir Cursos");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Profesores");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem = new JMenuItem("Ver Profesores");
		mnNewMenu_2.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);
		
		JMenu mnNewMenu_3 = new JMenu("Salir");
		menuBar.add(mnNewMenu_3);
		
		mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnNewMenu_3.add(mntmCerrarSesion);
		//mntmNewMenuItem_2.addActionListener(this);
		
		mntmSalirSistema = new JMenuItem("Salir Del Sistema");
		mnNewMenu_3.add(mntmSalirSistema);
		//mntmNewMenuItem_1.addActionListener(this);
		
		panelContenedor = new JPanel();
		panelContenedor.setBackground(Color.GREEN);
		add(panelContenedor, BorderLayout.CENTER);
		
		cardLayout = new CardLayout(0, 0);
		panelContenedor.setLayout(cardLayout);
		
		guiPrincipal=new GUIPrincipal();
		guiAlumnos=new GUIAlumno();
		guiCursos=new GUICursos();
		guiProfesores= new GUIProfesores();
		
		panelContenedor.add(guiPrincipal, "principal");
		panelContenedor.add(guiAlumnos, "alumnos");
		panelContenedor.add(guiCursos, "cursos");
		panelContenedor.add(guiProfesores, "profesores");
		this.addAncestorListener(new AncestorListener() {

			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub
				System.out.println("panel visible");
				cardLayout.show(panelContenedor, "principal");
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
		   
		});

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mntmRegistrar) {
			cardLayout.show(this.panelContenedor, "alumnos");
		}
		if(e.getSource()==mntmNewMenuItem) {
			cardLayout.show(this.panelContenedor, "profesores");
		}
		
		if(e.getSource()==mntmCursosInscritos) {
			cardLayout.show(this.panelContenedor, "cursos");
		}
		
		
		
	}
}
