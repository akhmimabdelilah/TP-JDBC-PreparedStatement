/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.project.beans.Message;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/*
 * @author akhmim
 */
public class MessageService implements IDao<Message> {

    private EmployeService es;

    public MessageService() {
        es = new EmployeService();
    }

    @Override
    public boolean create(Message o) {
        try {
            String req = "insert into message (objet, sujet, date, idE, idR)
values( ?,  ?,  ?,  ?,  ?)
            ";
PreparedStatement ps
                    = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getObject());
            ps.setString(2, o.getSujet());
            ps.setDate(3, new Date(o.getDate().getTime()));
            ps.setInt(4, o.getEmpEmetteur().getId());
            ps.setInt(5, o.getEmpRecepteur().getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Message o) {
        return false;
    }

    @Override
    public boolean delete(Message o) {
        return false;
    }

    @Override
    public Message getById(int id) {
        Message employe = null;
        try {
            //à compléter
            implementsIDao<Message> {
    private EmployeService es;

    public MessageService() {
        es = new EmployeService();
    }

    @Override
    public boolean create(Message o) {
        try {
            String req = "insert into message (objet, sujet, date, idE, idR)
values( ?,  ?,  ?,  ?,  ?)
            ";
PreparedStatement ps
                    = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getObject());
            ps.setString(2, o.getSujet());
            ps.setDate(3, new Date(o.getDate().getTime()));
            ps.setInt(4, o.getEmpEmetteur().getId());
            ps.setInt(5, o.getEmpRecepteur().getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Message o) {
        return false;
    }

    @Override
    public boolean delete(Message o) {
        return false;
    }

    @Override
    public Message getById(int id) {
        Message employe = null;
        try {
//à compléter
        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return employe;
    }

    @Override
    public List<Message> getAll() {
        List<Message> employes = new ArrayList<>();
        try {
            String req = "select * from message ";
            PreparedStatement ps
                    = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
// à compléter
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return employes;
    }
}
