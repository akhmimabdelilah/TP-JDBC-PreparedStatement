package q2;

import connexion.Connexion;
import dao.IDao;
import service.DevDataService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

import beans.DevData;

public class ExoJDBC implements IDao<DevData> {
    @Override
    public List<DevData> nbMaxScript() {
        List<DevData> devdata = new ArrayList<>();
        Statement st = null;

        try {
            String req = "SELECT Developpeur, Jour, max(NbScripts) FROM DevData group by jour";

            st = Connexion.getConnection().createStatement();
            System.out.println("Success d'affichage de nb max");
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                devdata.add(new DevData(
                        rs.getString("Developpeur"),
                        rs.getString("Jour"),
                        rs.getInt("NbScripts")));
            }

        } catch (SQLException ex) {
            System.out.println("Erreur d'execution de la requete: " + ex.getMessage());
        }
        return devdata;
    }

    @Override
    public List<DevData> triDeveloper() {
        // String db = "tp1";
        List<DevData> devdata = new ArrayList<>();

        try {
            String req = "SELECT Developpeur, sum(NbScripts) as c FROM DevData group by Developpeurs ORDER BY c DESC";

            Statement st = Connexion.getConnection().createStatement();
            System.out.println("Success de list de developpeur");
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                devdata.add(new DevData(
                        rs.getString("Developpeur"),
                        rs.getInt("NbScripts")));
            }

        } catch (SQLException ex) {
            System.out.println("Erreur d'execution de la requete: " + ex.getMessage());
        }
        return devdata;
    }

    @Override
    public List<DevData> NbScriptsSem(String Developpeur) {
        // String db = "tp1";

        List<DevData> devdata = new ArrayList<>();

        try {
            String req = "SELECT Developpeurs, SUM(NbScripts) as s FROM DevData WHERE Developpeur = " + Developpeur;

            Statement st = Connexion.getConnection().createStatement();
            System.out.println("Success de list de developpeur");
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                devdata.add(new DevData(
                        rs.getString("Developpeur"),
                        rs.getInt("s")));
            }

        } catch (SQLException ex) {
            System.out.println("Erreur d'execution de la requete: " + ex.getMessage());
        }
        return devdata;
    }

    public static void main(String[] args) throws Exception {
        try {

            Connexion.getConnection().createStatement();

            // nbMaxScript();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
