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
import java.util.ArrayList;
import java.util.List;
import gamybetter.Models.Commentaire;
import gamybetter.Utils.DataSource;
import java.sql.ResultSetMetaData;

/**
 *
 * @author Mariem
 */
public class ServiceCommentaire implements gamybetter.Services.IService<Commentaire> {

    Connection cnx = DataSource.getInstance().getCnx();
//Object id_personne, Object date, Object cont_commentaire, Object id_publication
    @Override
    public void ajouter(Commentaire c) {
        String query = "INSERT INTO `commentaire` (`id_personne`,`date`,`cont_commentaire`,`id_publication`) VALUES(?,STR_TO_DATE(? ,'%d-%m-%Y'),?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
       
            ps.setInt(1, c.getId_personne());
            ps.setString(2, c.getDate());
            ps.setString(3, c.getCont_commentaire());
            ps.setInt(4, c.getId_publication());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean modifier(Commentaire c) {
        String sql = "UPDATE `commentaire` SET  id_personne=?, date=STR_TO_DATE(? ,'%d-%m-%Y'), cont_commentaire=?, id_publication=?   WHERE id_commentaire=?";
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            
            statement.setObject(1, c.getId_personne());
            statement.setObject(2, c.getDate());
            statement.setObject(3, c.getCont_commentaire());
            statement.setObject(4, c.getId_publication());
            statement.setObject(5, c.getIdCommentaire());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return rowUpdated;
    }

    @Override
    public boolean supprimer(Commentaire c) {
        String sql = "DELETE FROM commentaire WHERE id_commentaire=?";
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, c.getIdCommentaire());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowDeleted;
    }

    @Override
    public List<Commentaire> getAll() {

        List<Commentaire> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM commentaire";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {
                Commentaire c = new Commentaire(
                        rs.getObject(1),
                        rs.getObject("id_personne"),
                        rs.getObject("date"),
                        rs.getObject("cont_commentaire"),
                rs.getObject("id_publication"));
                System.out.println(c + "-------------------");
                list.add(c);
            }
            System.out.println(rs.next());

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Commentaire getById(int id) {

        String query = "select * from commentaire where id_commentaire=" + id;
        try {

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Commentaire c = new Commentaire( rs.getObject(1), rs.getObject(2), rs.getObject(3),rs.getObject(4),rs.getObject(5));
                System.out.println(c + "-------------------");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return new Commentaire();
    }

    @Override
    public Commentaire getOne(Commentaire c) {
        System.out.println(c.getIdCommentaire());
        String query = "select * from commentaire where id_commentaire=" + c.getIdCommentaire();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Commentaire c1 = new Commentaire(rs.getInt(1), rs.getDate(2), rs.getString(3),rs.getObject(4),rs.getObject(5));
                return c1;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Commentaire();
    }

}
