package guiSistema;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class GUIPrincipal extends JPanel {
	
	String rutaImagen="imagenes/Imagen-cursos.jpg";
	private Image imagen;

	/**
	 * Create the panel.
	 */
	public GUIPrincipal() {
		setLayout(null);

	}
	
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.imagen = new ImageIcon(this.rutaImagen).getImage();
        
        // Dibuja la imagen ajustada al tamaño del panel
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
