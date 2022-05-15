/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//gamybetter.Models
import gamybetter.Models.Evenement;
import gamybetter.Utils.DataSource;

/**
 *
 * @author snoussi amine
 */
public class ServiceEvenement implements IService<Evenement> {

    Connection cnx = DataSource.getInstance().getCnx();
    // DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
    //Object id_proprietaire, Object nb_eq, Object Nom_event, Object description_event, Object date_debut_event, Object date_fin_event, Object prix, Object etat,Object liste_equipe

    @Override
    public void ajouter(Evenement t) {
        String query = "INSERT INTO `evenement`(`id_proprietaire`, `nb_eq`, `Nom_event`, `description_event`, `date_debut_event`, `date_fin_event`, `prix`, `etat`,`liste_equipe`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = cnx.prepareStatement(query);

            statement.setObject(1, t.getId_proprietaire());
            statement.setObject(2, t.getNb_eq());
            statement.setObject(3, t.getNom_event());
            statement.setObject(4, t.getDescription_event());
            statement.setObject(5, t.getDate_debut_event());
            statement.setObject(6, t.getDate_fin_event());
            statement.setObject(7, t.getPrix());
            statement.setObject(8, t.getEtat());
            statement.setObject(9, t.getListe_equipe());

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean modifier(Evenement t) {
        String query = "UPDATE `evenement` SET `id_proprietaire`=?,`nb_eq`=?,`Nom_event`=?,`description_event`=?,`date_debut_event`=?,`date_fin_event`=?,`prix`=?,`etat`=?,`liste_equipe`=? WHERE `id_event`=" + t.getId_event();
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setObject(1, t.getId_proprietaire());
            statement.setObject(2, t.getNb_eq());
            statement.setObject(3, t.getNom_event());
            statement.setObject(4, t.getDescription_event());
            statement.setObject(5, t.getDate_debut_event());
            statement.setObject(6, t.getDate_fin_event());
            statement.setObject(7, t.getPrix());
            statement.setObject(8, t.getEtat());
            statement.setObject(8, t.getListe_equipe());
            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowUpdated;
    }

    @Override
    public boolean supprimer(Evenement t) {
        String query = "DELETE FROM evenement where id_event=? ";

        boolean rowDeleted = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setInt(1, t.getId_event());
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowDeleted;
    }

    @Override
    public List<Evenement> getAll() {
        List<Evenement> list = new ArrayList<>();
        String query = "Select * from `evenement`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Evenement e = new Evenement(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8), rs.getObject(9), rs.getObject(10));
                list.add(e);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Evenement getOne(Evenement t) {
        System.out.println(t.getId_event() + "---80");
        String query = "select * from `evenement` where id=" + t.getId_event();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Evenement e = new Evenement(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8), rs.getObject(9), rs.getObject(10));
                return e;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Evenement();
    }

    @Override
    public Evenement getById(int id) {
        String query = "select * from evenement where id_event=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Evenement e1 = new Evenement(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8), rs.getObject(9), rs.getObject(10));

                return e1;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Evenement();
    }

    public boolean eventSature(int id) {
        int i = 0;
        try {
            String requete = "select id_personne from personne where role='coach' and Select from evenement where id_event=" + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                i++;
            }
            requete = "select nb_eq from evenement where id_event=" + id;
            st = cnx.createStatement();
            rs = st.executeQuery(requete);
            if (rs.next()) {
                if (i >= rs.getInt("nb_eq")) {
                    return true;
                }
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean eventExpire(int id) {
        try {
            String requete = "select * from evenement where DATEDIFF(date_fin_event,'" + java.time.LocalDate.now() + "') >=0 AND id_event=" + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public List<Evenement> triEvenement() {
        ArrayList<Evenement> evenementList = new ArrayList<>();
        try {

            String requete = "select * from evenement ORDER BY date_debut_event";
            PreparedStatement pst = cnx.prepareStatement(requete);

            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setId_event(rs.getInt("id_event"));
                e.setId_proprietaire(rs.getInt("id_proprietaire"));
                e.setNb_eq(rs.getInt("nb_eq"));
                e.setNom_event(rs.getString("Nom_event"));
                e.setDescription_event(rs.getString("description_event"));
                e.setDate_debut_event(rs.getDate("date_debut_event"));
                e.setDate_fin_event(rs.getDate("date_fin_event"));          
                e.setPrix(rs.getFloat("prix"));
                e.setEtat(rs.getInt("etat"));
                e.setListe_equipe(rs.getString("liste_equipe"));
                evenementList.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenementList;
    }
    public int isParticipant(int idE, int idP) {
        int nbP = 0;
        try {
            String requete = "SELECT count(id_personne) where role='coach' and id_equipe=? as nbM FROM personne and Select Nom_event where id_event=" + idE + " AND id_proprietaire=" + idP;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            if (rs.next()) {
                nbP = rs.getInt("nbM");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nbP;
    }
    public int sinscrirEvenement(int idE, int idP) {
        int nbModif = 0;
        try {
            String requete = "SELECT COUNT(p.id_equipe) as nbE FROM personne p and Select e.nb_eq as nbMaxE FROM evenement e where e.id_event=" + idE + " and e.id_event= " + idE;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            if (rs.next()) {

                int nbP = isParticipant(idE, idP);
                if (nbP == 0) {
                    System.out.println("No One is Part in this event Yet");
                    if (rs.getInt("nbE") < rs.getInt("nbMaxE")) {
                        System.out.println("still got places");
                        PreparedStatement pst = cnx.prepareStatement(requete);
                        nbModif = pst.executeUpdate();
                        System.out.println("inscription effectuée");
                    }
                }
            } else {
                System.out.println("non");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nbModif;
    }


}
