/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import gamybetter.Models.Session;
import gamybetter.Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author skon1
 */
public class ServiceSession implements IService<Session> {

    Connection cnx = DataSource.getInstance().getCnx();
//Object email_coach, Object email_joueur, Object duree, Object date, Object jeu, Object categorie, Object prix
    @Override
    public void ajouter(Session t) {
        String query = "INSERT INTO `session` (`email_coach`, `email_joueur`, `duree`, `date`, `jeu`, `categorie`, `prix`,`nom_session` ) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setObject(1, t.getEmail_coach());
            ps.setObject(2, t.getEmail_joueur());
            ps.setObject(3, t.getDuree());
            ps.setObject(4, t.getDaate());
            ps.setObject(5, t.getJeu());
            ps.setObject(6, t.getCategorie());
            ps.setObject(7, t.getPrix());
            ps.setObject(8, t.getNom());
            ps.executeUpdate();
            System.out.println("Add successful");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Session getById(int id) {
        Session s = null;
        try {
            String query = "SELECT * FROM session WHERE id=" + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                s = new Session(
                        rs.getObject("id"),
                        rs.getObject("nom_session"),
                        rs.getObject("email_coach"),
                        rs.getObject("email_joueur"),
                        rs.getObject("duree"),
                        rs.getObject("date"),
                        rs.getObject("jeu"),
                        rs.getObject("categorie"),
                        rs.getObject("prix")
                );
                System.out.println("GetById successful");
                System.out.println(s);
            } else {
                System.out.println("GetById unsuccessful !!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return s;
    }

    @Override
    public List<Session> getAll() {
        List<Session> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM session";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Session s = new Session(
                        rs.getObject("id"),
                        rs.getObject("nom_session"),
                        rs.getObject("email_coach"),
                        rs.getObject("email_joueur"),
                        rs.getObject("duree"),
                        rs.getObject("date"),
                        rs.getObject("jeu"),
                        rs.getObject("categorie"),
                        rs.getObject("prix")
                );
                list.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean modifier(Session t) {
        String query = "UPDATE `session` SET  email_coach=?, email_joueur=? , duree=?, date=?, jeu=?, categorie=?,prix=? ,nom_session=? WHERE id=? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
         
            ps.setObject(1, t.getEmail_coach());
            ps.setObject(2, t.getEmail_joueur());
            ps.setObject(3, t.getDuree());
            ps.setObject(4, t.getDaate());
            ps.setObject(5, t.getJeu());
            ps.setObject(6, t.getCategorie());
            ps.setObject(7, t.getPrix());
            ps.setObject(8, t.getNom());
            ps.setObject(9, t.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update successful");
                return true;
            } else {
                System.out.println("Update Unsuccessful !!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean supprimer(Session t) {
        String query = "DELETE FROM session WHERE id=" + t.getId();
        try {
            Statement st = cnx.createStatement();
            int rowsDeleted = st.executeUpdate(query);
            Session s = new Session();
            getById(t.getId()).equals(s);
            System.out.println("Delete successful");
            return true;
        } catch (SQLException ex) {
            System.out.println("Delete Unsuccessful !!");
            
        }
        return false;
    }

    @Override
    public Session getOne(Session t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
