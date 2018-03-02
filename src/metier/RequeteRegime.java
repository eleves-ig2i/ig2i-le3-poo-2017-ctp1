package metier;

import modele.Aliment;
import modele.Patient;
import modele.Prescription;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequeteRegime {

    private Connection connection;

    private static RequeteRegime instance;

    public static RequeteRegime getInstance() {
        if (instance == null) {
            instance = new RequeteRegime();
        }
        return instance;
    }


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


    public List<Patient> ensPatients(String nomprenom) throws SQLException {
        ArrayList<Patient> ls = new ArrayList<>();
        String query = "SELECT * FROM patient  WHERE UPPER(nom) LIKE ? OR UPPER(prenom) LIKE ?;";
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

    public void addAllPrescriptionsToPatient(Patient p) throws SQLException {
        String query = "SELECT * FROM prescription WHERE nPatient = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, p.getId());
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            p.addPrescription(new Prescription(resultSet.getInt("nPrescription"),
                    resultSet.getInt("quantite"),
                    resultSet.getInt("nAliment")));
        }
        resultSet.close();
        statement.close();
    }

    private void connect() throws ClassNotFoundException, SQLException {
        String driverClass = "com.mysql.jdbc.Driver";
        String urlDatabase = "jdbc:mysql://localhost:3306/dev";
        String user = "root";
        String pwd = "toor";
        Class.forName(driverClass);
        connection = DriverManager.getConnection(urlDatabase, user, pwd);

    }


}
