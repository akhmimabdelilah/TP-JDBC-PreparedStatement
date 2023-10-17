package demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * @author akhmim
 */
public class CreateDB {

    public static void main(String[] args) throws Exception {
        try {
            String user = "root";
            String password = "root";

            String url = "jdbc:mysql://localhost:3306/";
            String db = "db";

            String sql = "CREATE DATABASE " + db;

            Connection cn = DriverManager.getConnection(url, user, password);
            Statement st = cn.createStatement();

            st.executeUpdate(sql);
            st.close();
            JOptionPane.showMessageDialog(
                    null,
                    db,
                    " Database has been created successfully!",
                    // "System Message",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
