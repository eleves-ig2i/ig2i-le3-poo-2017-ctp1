package modele;

public class Prescription {

	private int id;
	private int quantitee;
	private int aliment;

	/**
	 * TODO.
	 * @param id TODO
	 * @param quantitee TODO
	 * @param aliment TODO
	 */
	public Prescription(int id, int quantitee, int aliment) {
		this.id = id;
		this.quantitee = quantitee;
		this.aliment = aliment;
	}

	public int getId() {
		return id;
	}

	public int getQuantite() {
		return quantitee;
	}


	public int getAliment() {
		return aliment;
	}

	@Override
	public String toString() {
		return "Prescription{"
				+ "quantitee=" + quantitee
				+ ", aliment=" + aliment
				+ '}';
	}
}
