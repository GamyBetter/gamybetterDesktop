/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import gamybetter.Models.Cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import gamybetter.Utils.DataSource;


/**
 *
 * @author skon1
 */
public class ServiceCours implements IService<Cours> {

    Connection cnx = DataSource.getInstance().getCnx();
//int id_coach, String email_coach, String categorie, String jeu, float prix, String lien_session,String liste_personnes, int id_session
    @Override
    public void ajouter(Cours t) {
        String query = "INSERT INTO `cours` (`id_coach`, `email_coach`, `categorie`, `jeu`, `prix`, `lien_session`, `liste_personnes`,`id_session`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setObject(1, t.getId_coach());
            ps.setObject(2, t.getEmail_coach());
            ps.setObject(3, t.getCategorie());
            ps.setObject(4, t.getJeu());
            ps.setObject(5, t.getPrix());
            ps.setObject(6, t.getLien_session());
            ps.setObject(7, t.getListe_personnes());
            ps.setObject(8, t.getId_session());
            ps.executeUpdate();
            System.out.println("Add successful");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public Cours getById(int id) {
        Cours c = null;
        try {
            String query = "SELECT * FROM cours WHERE id=" + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                c = new Cours(
                        rs.getObject(1),
                        rs.getObject("id_coach"),
                        rs.getObject("email_coach"),
                        rs.getObject("categorie"),
                        rs.getObject("jeu"),
                        rs.getObject("prix"),
                        rs.getObject("lien_session"),
                rs.getObject("liste_personnes"),
                rs.getObject("id_session"));
                System.out.println("GetById successful");
                System.out.println(c);
            } else {
                System.out.println("GetById unsuccessful !!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    @Override
    public List<Cours> getAll() {
        List<Cours> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM cours";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Cours c = new Cours(
                        rs.getObject(1),
                        rs.getObject("id_coach"),
                        rs.getObject("email_coach"),
                        rs.getObject("categorie"),
                        rs.getObject("jeu"),
                        rs.getObject("prix"),
                        rs.getObject("lien_session"),
                         rs.getObject("liste_personnes"),
                rs.getObject("id_session")
                );
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean modifier(Cours t) {
        String query = "UPDATE `cours` SET id_coach=?, email_coach=?, categorie=? , jeu=?, prix=?, lien_session=?, liste_personnes=?, id_session=? WHERE id=? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setObject(1, t.getId_coach());
            ps.setObject(2, t.getEmail_coach());
            ps.setObject(3, t.getCategorie());
            ps.setObject(4, t.getJeu());
            ps.setObject(5, t.getPrix());
            ps.setObject(6, t.getLien_session());
            ps.setObject(7, t.getListe_personnes());
            ps.setObject(8, t.getId_session());
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
    public boolean supprimer(Cours t) {
        String query = "DELETE FROM cours WHERE id=" + t.getId();
        try {
            Statement st = cnx.createStatement();
            int rowsDeleted = st.executeUpdate(query);
            Cours c = new Cours();
            if (getById(t.getId()).equals(c)) {
                System.out.println("Delete successful");
                return true;
            } else {
                System.out.println("Delete Unsuccessful !!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Cours getOne(Cours t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
