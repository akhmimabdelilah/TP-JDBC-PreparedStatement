package q3;

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
import java.util.Scanner;

import beans.DevData;

// public class ExoJDBC implements IDao<DevData> {
public class ExoJDBC {
    public void metaInfo() {
        String req =  new Scanner();
    // req = o.
    Statement st = null;
    boolean isResultSet = st.execute(req);

    if(isResultSet)
    {
        // Résultat est un ResultSet
        rs = st.getResultSet();

        // Afficher le nombre de colonnes
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        System.out.println("Nombre de colonnes : " + columnCount);

        // Afficher les informations sur chaque colonne
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            String columnType = metaData.getColumnTypeName(i);
            System.out.println("Nom de la colonne : " + columnName + ", Type de données : " + columnType);
        }

        // Afficher le contenu du ResultSet
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }else
    {
        // Résultat n'est pas un ResultSet (nombre de lignes modifiées)
        int rowCount = st.getUpdateCount();
        System.out.println("Nombre de lignes modifiées : " + rowCount);
    }}catch(

    SQLException e)
    {
        System.out.println("Erreur SQL : " + e.getMessage());
    }catch(
    ClassNotFoundException ex)
    {
        System.out.println("Impossible de charger le driver");
    }finally
    {
        try {
            // Etape 6 : Libérer les ressources de la mémoire
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Impossible de libérer les ressources");
        }
    }

    }

    public static void main(String[] args) throws Exception {
        try {

            Connexion.getConnection().createStatement();

            metaInfo();
            // nbMaxScript();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
