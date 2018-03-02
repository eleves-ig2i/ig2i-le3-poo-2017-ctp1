package modele;

/**
 * TODO.
 * @author user
 */
public class Aliment {

	private int id;
	private String nom;
	private int satisfaction;
	private int calories;
	private int calcium;
	private int vitamineC;
	private int fer;

	/**
	 * TODO.
	 * @param id TOOD
	 * @param nom TODO
	 * @param satisfaction TODO
	 * @param calories TODO
	 * @param calcium TODO
	 * @param vitamineC TODO
	 * @param fer TODO
	 */
	public Aliment(int id, String nom, int satisfaction, int calories, int calcium, int vitamineC, int fer) {
		this.id = id;
		this.nom = nom;
		this.satisfaction = satisfaction;
		this.calories = calories;
		this.calcium = calcium;
		this.vitamineC = vitamineC;
		this.fer = fer;
	}


	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public int getCalories() {
		return calories;
	}

	public int getCalcium() {
		return calcium;
	}

	public int getVitamineC() {
		return vitamineC;
	}

	public int getFer() {
		return fer;
	}

	@Override
	public String toString() {
		return "Aliment{" +
				"nom='" + nom + '\'' +
				", satisfaction=" + satisfaction +
				", calories=" + calories +
				", calcium=" + calcium +
				", vitamineC=" + vitamineC +
				", fer=" + fer +
				'}';
	}
}
