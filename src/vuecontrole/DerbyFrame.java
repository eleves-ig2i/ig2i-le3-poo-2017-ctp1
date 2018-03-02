package vuecontrole;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import metier.RequeteRegime;

/**
 * TODO.
 * @author user
 */
public class DerbyFrame extends JFrame {
	public RequeteRegime db;

	JPanel panel;

	/**
	 * TODO.
	 */
	public DerbyFrame() {
		panel = new JPanel();
		panel.setBackground(new Color(255, 208, 159));
		setResizable(false);
		setContentPane(panel);
	}

	public void initConnexion() {
		db = RequeteRegime.getInstance();
	}

	@Override
	public void setTitle(String title) {
		super.setTitle("RegimeBox - " + title);
	}
}
