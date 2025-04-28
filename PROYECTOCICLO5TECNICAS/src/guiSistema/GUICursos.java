package guiSistema;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GUICursos extends JPanel {

	/**
	 * Create the panel.
	 */
	public GUICursos() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE CURSOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 11, 636, 14);
		add(lblNewLabel);

	}

}
