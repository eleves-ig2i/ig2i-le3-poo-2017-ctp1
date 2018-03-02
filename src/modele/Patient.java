package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO.
 * @author user TODO
 */
public class Patient {

	private int id;
	private String nom;
	private String prenom;
	private int caloriesMax;
	private int calciumMin;
	private int vitaminesCMin;
	private int ferMin;

	private ArrayList<Prescription> prescriptions = new ArrayList<>(); //immutable

	/**
	 * TODO.
	 * @param id TODO
	 * @param nom TODO
	 * @param prenom TODO
	 * @param caloriesMax TODO
	 * @param calciumMin TODO
	 * @param vitaminesCMin TODO
	 * @param ferMin TODO
	 */
	public Patient(
					int id,
					String nom,
					String prenom,
					int caloriesMax,
					int calciumMin,
					int vitaminesCMin,
					int ferMin
	) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.caloriesMax = caloriesMax;
		this.calciumMin = calciumMin;
		this.vitaminesCMin = vitaminesCMin;
		this.ferMin = ferMin;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getCaloriesMax() {
		return caloriesMax;
	}

	public int getCalciumMin() {
		return calciumMin;
	}

	public int getVitaminesCMin() {
		return vitaminesCMin;
	}

	public int getFerMin() {
		return ferMin;
	}

	/**
	 * Le but de cette copie de liste est de rendre immutable la liste prescription.
	 * Elle est cependant éditable via les méthodes 
	 * {@link #addPrescription} et {@link #removePrescription}.
	 *
	 * @return Une copie de la liste des prescriptions
	 */
	public List<Prescription> getPrescriptions() {
		return new ArrayList<>(prescriptions);
	}

	/**
	 * TODO.
	 * @param prescription TODO
	 */
	public void addPrescription(Prescription prescription) {
		if (!prescriptions.contains(prescription)) {
			prescriptions.add(prescription);
		}
	}

	/**
	 * TODO.
	 * @param prescription TODO
	 */
	public void removePrescription(Prescription prescription) {
		prescriptions.remove(prescription);
	}

	@Override
	public String toString() {
		return "Patient{"
				+ "nom='" + nom + '\''
				+ ", prenom='" + prenom + '\''
				+ ", caloriesMax=" + caloriesMax
				+ ", calciumMin=" + calciumMin
				+ ", vitaminesCMin=" + vitaminesCMin
				+ ", ferMin=" + ferMin
				+ '}';
	}
}
