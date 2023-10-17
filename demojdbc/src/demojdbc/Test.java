/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author akhmim
 */
public class Test {

    // insert site into table in db
    public static void save(Site s) {
        // db access informations
        String user = "root";
        String password = "root";

        String url = "jdbc:mysql://localhost:3306/db";

        Connection cn = null;
        // cn = new Connection();
        Statement st = null;
        // st = new Statement();

        try {
            // drive loading
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            // connection recovery
            cn = DriverManager.getConnection(url, user, password);

            // statement creation
            //  st = (Statement) cn.createStatement();
            st = cn.createStatement();

            String req = "insert into site values(null,'" + s.getNom() + "')";

            // request execution
            st.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le drive");
        } finally {
            try {
                //  free memory ressources
                if (st != null && cn != null) {
                    st.close();
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Impossible de liberer les ressources");
            }
        }
    }

    // display differents sites
    public static void load() {
        String user = "root";
        String password = "root";

        String url = "jdbc:mysql://localhost:3306/db";
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
    //        ResultSet rs;

        //        rs = new ResultSet();
        try {
            // drive loading
            //            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            // connection recovery
            cn = DriverManager.getConnection(url, user, password);

            // statement creation
            st = (Statement) cn.createStatement();
            String req = "select * from Site";

            // request execution
            //   if (rs != null) {
            rs = st.executeQuery(req);
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "" + rs.getString(2));
            }
            //   }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        } finally {
            try {
                //  free memory ressources
                if (st != null && cn != null) {
                    st.close();
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Impossible de liberer les ressources");
            }
        }
    }

    public static void main(String[] args) {
        // data insertion
        save(new Site("Safi"));
        save(new Site("Marrakech"));
        save(new Site("El Jadida"));

        // data recovery
        load();
    }
}
