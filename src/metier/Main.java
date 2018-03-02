package metier;

import vuecontrole.Accueil;

import java.sql.SQLException;

/**
 * <br>
 * Author : <a href="https://git-01.dev.uhcwork.net/u/Rapace">Wazo</a><br>
 * Project DerbyRegime
 * <br>
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
