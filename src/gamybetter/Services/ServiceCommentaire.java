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
import tn.edu.esprit.modeles.Commentaire;
import tn.edu.esprit.utils.DataSource;

/**
 *
 * @author Mariem
 */
public class ServiceCommentaire implements tn.edu.esprit.service.IService<Commentaire> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void add(Commentaire c) {
        String query = "INSERT INTO `commentaire` (`id_commentaire`,`id_personne`,`date`,`cont_commentaire`) VALUES(?,?,STR_TO_DATE(? ,'%d-%m-%Y'),?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setInt(1, c.getIdCommentaire());
            ps.setInt(2, c.getId_personne());
            ps.setString(3, c.getDate());
            ps.setString(4, c.getCont_commentaire());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean update(Commentaire c) {
        String sql = "UPDATE `commentaire` SET id_commentaire=?, id_personne=?, date=STR_TO_DATE(? ,'%d-%m-%Y'), cont_commentaire=?   WHERE id_commentaire=?";
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, c.getIdCommentaire());
            statement.setObject(2, c.getId_personne());
            statement.setObject(3, c.getDate());
            statement.setObject(4, c.getCont_commentaire());
              statement.setObject(5, c.getIdCommentaire());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return rowUpdated;
    }

    @Override
    public boolean delete(Commentaire c) {
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
            String req = "Select * from commentaire";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Commentaire c = new Commentaire(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4));
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
     
        String query = "select * from commentaire where id_commentaire=" +id;
        try {
          
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Commentaire c = new Commentaire(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4));
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
Commentaire c1 = new Commentaire(rs.getInt(1), rs.getInt(2), rs.getDate(3),rs.getString(4));
return c1;
     }

     } catch (SQLException ex) {
     System.out.println(ex.getMessage());
     }

     return new Commentaire();
     } 
   

 }


