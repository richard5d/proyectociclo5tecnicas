package guiSistema;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GUIProfesores extends JPanel {

	/**
	 * Create the panel.
	 */
	public GUIProfesores() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE PROFESORES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 5, 636, 14);
		add(lblNewLabel);

	}

}
