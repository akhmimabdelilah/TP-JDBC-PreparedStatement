/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * @author akhmim
 */
public class CreateTab {

    public static void main(String[] args) throws Exception {
        try {
            String user = "root";
            String password = "root";

            String url = "jdbc:mysql://localhost:3306/db";

            String sql = "CREATE TABLE site ( ‘id‘ int(11) primary key auto_increment,‘nom‘ varchar(100) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1;";

//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(url, user, password);
            Statement st = cn.createStatement();

            st.executeUpdate(sql);
            st.close();
            System.out.println("Table has been created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
