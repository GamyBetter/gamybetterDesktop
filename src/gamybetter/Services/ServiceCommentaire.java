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
import gamybetter.Models.Publication;
import gamybetter.Utils.DataSource;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mariem
 */
public class ServiceCommentaire implements gamybetter.Services.ICommentaire<Commentaire> {

    
      SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
    Date date=new Date() ;
    
    Connection cnx = DataSource.getInstance().getCnx();
//Object id_personne, Object date, Object cont_commentaire, Object id_publication

    @Override
    public void ajouter(Commentaire c) {
        System.out.println(c+"...............");
        String query = "INSERT INTO `commentaire` (`id_personne`,`date`,`cont_commentaire`) VALUES(?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);

            ps.setInt(1, c.getId_personne());
            ps.setObject(2, formatter.format(date));
           //System.out.println(c.getDate());
            ps.setObject(3, c.getCont_commentaire());
            //  ps.setInt(4, c.getId_publication());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean modifier(Commentaire c) {
        String sql = "UPDATE `commentaire` SET id_commentaire=?, id_personne=?, cont_commentaire=?, id_publication=?   WHERE id_commentaire=?";
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, c.getIdCommentaire());
            statement.setObject(2, c.getId_personne());
            //statement.setObject(3,c.getDate());
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
                Commentaire c = new Commentaire(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getInt(5));
                System.out.println(c + "-------------------");
                list.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Commentaire getById(int id) {

        String query = "select * from commentaire where id_publication=" + id;
        try {

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Commentaire c = new Commentaire(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5));
               
                return c;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return new Commentaire();
    }

    @Override
    public Commentaire getOne(Commentaire c) {
        System.out.println(c.getIdCommentaire());
        String query = "select * from `commentaire` where id_commentaire=" + c.getIdCommentaire();
        System.out.println(c.getIdCommentaire() + "ID commentaire");
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Commentaire c1 = new Commentaire(rs.getInt(1), rs.getInt(2),rs.getObject(3), rs.getString(4), rs.getInt(5));
                return c1;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Commentaire();
    }

    public void deleteById(int id) {
        String query = "DELETE FROM commentaire WHERE id_commentaire=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setInt(1, id);

            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Commentaire> getAllByID(int id) {
        List<Commentaire> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `commentaire` WHERE `id_publication` = " +id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Commentaire c = new Commentaire(rs.getInt(1), rs.getInt(2), rs.getObject(3), rs.getString(4), rs.getInt(5));
                System.out.println(c + "-------------------");
                list.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

}
