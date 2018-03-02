package metier;

import java.sql.SQLException;
import vuecontrole.Accueil;


/**
 * Project DerbyRegime.
 */
public class Main {

	public static void main(String[] args){
		try {
			RequeteRegime.getInstance().ensAliments().forEach(al -> System.out.println(al.toString()));
			RequeteRegime.getInstance().ensPatients("").forEach(pa -> System.out.println(pa.toString()));
			Accueil.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
