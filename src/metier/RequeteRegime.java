package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Aliment;
import modele.Patient;
import modele.Prescription;

/**
 * TODO.
 * @author user
 */
public class RequeteRegime {

	private Connection connection;

	private static RequeteRegime instance;

	/**
	 * TODO.
	 * @return 
	 */
	public static RequeteRegime getInstance() {
		if (instance == null) {
			instance = new RequeteRegime();
		}
		return instance;
	}

	/**
	 * TODO.
	 */
	public RequeteRegime() {
		try {
			connect();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Récupère en base de donnée la liste des aliments présent.
	 *
	 * @return La liste de tout les aliments présents.
	 * @throws SQLException En cas d'erreur de connection ou de lecture...
	 */
	public List<Aliment> ensAliments() throws SQLException {
		ArrayList<Aliment> ls = new ArrayList<>();
		String query = "SELECT * FROM aliment";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			ls.add(new Aliment(
					resultSet.getInt("nAliment"),
					resultSet.getString("nom"),
					resultSet.getInt("satisfaction"),
					resultSet.getInt("calories"),
					resultSet.getInt("calcium"),
					resultSet.getInt("vitaminesC"),
					resultSet.getInt("fer")));
		}
		resultSet.close();
		statement.close();
		return ls;
	}

	/**
	 * TODO.
	 * @param nomprenom TODO
	 * @return TODO
	 * @throws SQLException TODO
	 */
	public List<Patient> ensPatients(String nomprenom) throws SQLException {
		ArrayList<Patient> ls = new ArrayList<>();
		String query = "SELECT * FROM patient  WHERE UPPER(nom) LIKE ? OR UPPER(prenom) LIKE ?";
		PreparedStatement statement = connection.prepareStatement(query);
		nomprenom = nomprenom.toUpperCase();
		nomprenom = "%" + nomprenom + "%";
		statement.setString(1, nomprenom);
		statement.setString(2, nomprenom);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			ls.add(new Patient(
					resultSet.getInt("nPatient"),
					resultSet.getString("nom"),
					resultSet.getString("prenom"),
					resultSet.getInt("caloriesMax"),
					resultSet.getInt("calciumMin"),
					resultSet.getInt("vitaminesCMin"),
					resultSet.getInt("ferMin")));
		}
		resultSet.close();
		statement.close();
		return ls;
	}

	/**
	 * TODO.
	 * @param p TODO
	 * @throws SQLException TODO
	 */
	public void addAllPrescriptionsToPatient(Patient p) throws SQLException {
		String query = "SELECT * FROM prescription WHERE nPatient = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, p.getId());
		ResultSet resultSet = statement.executeQuery();
				
		while (resultSet.next()) {
			p.addPrescription(
					new Prescription(resultSet.getInt("nPrescription"),
					resultSet.getInt("quantite"),
					resultSet.getInt("nAliment"))
			);
		}
		System.out.println(p);
		resultSet.close();
		statement.close();
	}

	private void connect() throws ClassNotFoundException, SQLException {
		String driverClass = "org.apache.derby.jdbc.ClientDriver";
		String urlDatabase = "jdbc:derby://localhost:1527/database";
		String user = "username";
		String pwd = "password";
		Class.forName(driverClass);
		connection = DriverManager.getConnection(urlDatabase, user, pwd);

	}


}
