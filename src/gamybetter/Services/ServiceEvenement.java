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
    DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
    @Override
    public void ajouter(Evenement t) {
        String query = "INSERT INTO `evenement`( `id_event` , `id_proprietaire`, `nb_eq`, `Nom_event`, `description_event`, `date_debut_event`, `date_fin_event`, `prix`, `etat`) VALUES (?,?,?,?,?,STR_TO_DATE(? ,'%d-%m-%Y'),STR_TO_DATE(? ,'%d-%m-%Y'),?,?)";
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setObject(1, t.getId_event());
            statement.setObject(2, t.getId_proprietaire());
            statement.setObject(3, t.getNb_eq());
            statement.setObject(4, t.getNom_event());
            statement.setObject(5, t.getDescription_event());
            statement.setObject(6, t.getDate_debut_event());
            statement.setObject(7, t.getDate_fin_event());
            statement.setObject(8, t.getPrix());
            statement.setObject(9, t.getEtat());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean modifier(Evenement t) {
        String query = "UPDATE `evenement` SET `id_proprietaire`=?,`nb_eq`=?,`Nom_event`=?,`description_event`=?,`date_debut_event`=STR_TO_DATE(? , '%d-%m-%Y'),`date_fin_event`=STR_TO_DATE(? ,'%d-%m-%Y'),`prix`=?,`etat`=? WHERE `id_event`=" + t.getId_event();
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
                Evenement e = new Evenement(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6).toString(), rs.getObject(7).toString(), rs.getObject(8), rs.getObject(9));
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
                Evenement e = new Evenement(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6).toString(), rs.getObject(7).toString(), rs.getObject(8), rs.getObject(9));
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
                Evenement e1 = new Evenement(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6).toString(), rs.getObject(7).toString(), rs.getObject(8), rs.getObject(9));

                return e1;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Evenement();
    }


}
