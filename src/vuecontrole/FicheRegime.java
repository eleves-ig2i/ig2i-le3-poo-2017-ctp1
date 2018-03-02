package vuecontrole;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import modele.Aliment;
import modele.Patient;
import modele.Prescription;

/**
 * Project DerbyRegime.
 */
public class FicheRegime extends DerbyFrame {

	private transient Patient patient;
	private transient List<Aliment> alimentList;
	private int nbr = 0;

	private HashMap<Aliment, JSlider> sliders = new HashMap<>();

	private JTextArea regimeInfo;

	/**
	 * TODO.
	 * @param patient TODO
	 */
	public FicheRegime(Patient patient) {
		super();
		if (patient == null) {
			return;
		}
		initConnexion();
		this.patient = patient;
		try {
			db.addAllPrescriptionsToPatient(patient);
			alimentList = db.ensAliments();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initComponent();
		setSize(500, 54 + (nbr - 1) * 15 + nbr * 75);
		setTitle("Fiche régime de " + patient.getPrenom() + " " + patient.getPrenom());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponent() {
		this.panel.setLayout(null);

		for (Aliment aliment : this.alimentList) {
			JPanel pane = new JPanel();
			pane.setBackground(this.panel.getBackground());
			int value = getPrescriptionValue(aliment);
			int max = patient.getCaloriesMax() / aliment.getCalories();
			if (max > 10) {
				max = 10;
			}
			JSlider slider = new JSlider(0, max, value);
			sliders.put(aliment, slider);
			pane.add(slider);
			setSliderStyle(slider);
			pane.setBorder(BorderFactory.createTitledBorder(aliment.getNom() + " (100g)"));
			pane.setBounds(10, 30 + (nbr - 1) * 15 + nbr * 75, 300, 75);
			this.panel.add(pane);
			nbr++;
		}
		regimeInfo = new JTextArea();
		regimeInfo.setBounds(330, 15, 150, 100);
		regimeInfo.setEditable(false);
		panel.add(regimeInfo);
		updateIndicateurs();
	}


	/**
	 * Récupère la valeur actuelle de patient en fonction de ses prescription pour un aliment donné.
	 *
	 * @param aliment l'objet aliment a vérifier
	 * @return la valeur quantitée de la prescription pour l'aliment donné
	 */
	private int getPrescriptionValue(Aliment aliment) {
		for (Prescription prescription : patient.getPrescriptions()) {
			if (prescription.getAliment() == aliment.getId()) {
				return prescription.getQuantite();
			}
		}
		return 0;
	}

	/**
	 * Définit de style de slider.
	 *
	 * @param slider TODO
	 */
	private void setSliderStyle(JSlider slider) {
		slider.setBackground(panel.getBackground());
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(slider.getMaximum());
		slider.setBounds(5, 5, 290, 65);
		slider.addChangeListener(e -> updateIndicateurs());
	}

	private void updateIndicateurs() {
		int calories = 0;
		int calcium = 0;
		int vitamineC = 0;
		int fer = 0;
		int satisfaction = 0;
		for (Map.Entry<Aliment, JSlider> entry : sliders.entrySet()) {
			int qtt = entry.getValue().getValue();
			Aliment a = entry.getKey();
			calories += a.getCalories() * qtt;
			calcium += a.getCalcium() * qtt;
			vitamineC += a.getVitamineC() * qtt;
			fer += a.getFer() * qtt;
			satisfaction += a.getSatisfaction() * qtt;
		}
		String indic = "Calories : " + calories + " ("
				+ getComparator(calories, patient.getCaloriesMax())
				+ " " + patient.getCaloriesMax() + ")\n"
				+ "Calcium : " + calcium + " ("
				+ getComparator(calcium, patient.getCalciumMin())
				+ " " + patient.getCalciumMin() + ")\n"
				+ "Vitamines C : " + vitamineC + " ("
				+ getComparator(vitamineC, patient.getVitaminesCMin())
				+ " " + patient.getVitaminesCMin() + ")\n"
				+ "Fer : " + fer + " ("
				+ getComparator(fer, patient.getFerMin())
				+ " " + patient.getFerMin() + ")\n"
				+ "Satisfaction : " + satisfaction;
		regimeInfo.setText(indic);
	}

	private String getComparator(int a, int b) {
		if (a == b) {
			return "=";
		} else if (a > b) {
			return ">";
		} else {
			return "<";
		}
	}

}
