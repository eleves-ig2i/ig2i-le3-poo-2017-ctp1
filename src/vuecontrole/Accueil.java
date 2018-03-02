package vuecontrole;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import modele.Patient;


public class Accueil extends DerbyFrame {


	private JLabel rechercheLabel;
	private JTextField rechercheField;

	private JList<Patient> patientList;
	private JScrollPane scroll;

	private JButton afficherRegime;
	private DefaultListModel<Patient> listModel = new DefaultListModel<>();

	private static Accueil instance;

	public Accueil() {
		super();
		initConnexion();
		initComponent();
		setSize(400, 300);
		setTitle("Gestion des clients");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void dispose() {
		super.dispose();
		instance = null;
	}

	private void initComponent() {
		remplirListeClients("");
		panel.setLayout(null);

		rechercheLabel = new JLabel();
		rechercheLabel.setText("Recherche : ");
		rechercheLabel.setBounds(10, 15, 150, 20);
		panel.add(rechercheLabel);

		rechercheField = new JTextField();
		rechercheField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				remplirListeClients(rechercheField.getText());
			}
		});
		rechercheField.setBounds(100, 15, 150, 20);
		panel.add(rechercheField);

		patientList = new JList<>();
		patientList.setModel(listModel);
		patientList.setCellRenderer(new PatientCellRender());
		patientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroll = new JScrollPane(patientList);
		scroll.setBounds(10, 50, 240, 200);
		panel.add(scroll);


		afficherRegime = new JButton("Voir fiche régime");
		afficherRegime.setBounds(265, 215, 115, 25);
		afficherRegime.addActionListener(e -> new FicheRegime(patientList.getSelectedValue()));
		panel.add(afficherRegime);
	}

	private void remplirListeClients(String nomprenom) {
		listModel.clear();
		try {
			db.ensPatients(nomprenom).forEach(listModel::addElement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Accueil getInstance() {
		return instance == null ? instance = new Accueil() : instance;
	}
}
