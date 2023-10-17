package q1;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class InsertData {

    public static boolean create() {
        String db = "tp1";

        try {
            String req = "INSERT INTO `DevData` VALUES('ALAMI', 'Lundi', 1);" +
                    "INSERT INTO `DevData` VALUES('WAFI', 'Mardi', 2);" +
                    "INSERT INTO `DevData` VALUES('SLAMI', 'Jeudi', 1)";

            Statement st = Connexion.getConnection().createStatement();
            System.out.println("Success d'insertion de donnees");
            JOptionPane.showMessageDialog(
                    null,
                    db,
                    " Data has been inserted successfully!",
                    // "System Message",
                    JOptionPane.INFORMATION_MESSAGE);

            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un client:" + ex.getMessage());
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        try {
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/tp1";

            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection(url, user, password);
            cn.createStatement();
            create();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
