package vuecontrole;

import metier.RequeteRegime;

import javax.swing.*;
import java.awt.*;


public class DerbyFrame extends JFrame {
	public RequeteRegime db;

	JPanel panel;


	public DerbyFrame(){
		panel = new JPanel();
		panel.setBackground(new Color(255, 208, 159));
		setResizable(false);
		setContentPane(panel);
	}

	public void initConnexion() {
		db = RequeteRegime.getInstance();
	}

	@Override
	public void setTitle(String title){
		super.setTitle("RegimeBox - " + title);
	}
}
