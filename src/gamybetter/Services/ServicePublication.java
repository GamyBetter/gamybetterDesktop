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
import gamybetter.Models.Publication;
import gamybetter.Utils.DataSource;

/**
 *
 * @author Mariem
 */
public class ServicePublication implements gamybetter.Services.IService<Publication> {

    Connection cnx = DataSource.getInstance().getCnx();
    //Object id_personne, Object publication, Object titre, Object nbr_commentaire,Object date
    @Override
    public void ajouter(Publication p) {
        String query = "INSERT INTO `publication` (`id_personne`,`publication`,`titre`,`nbr_commentaire`,`date`) VALUES (?,?,?,?,?,STR_TO_DATE(? ,'%d-%m-%Y'))";
        try {

            PreparedStatement ps = cnx.prepareStatement(query);
          
            ps.setInt(1, p.getId_personne());
            ps.setString(2, p.getPublication());
            ps.setString(3, p.getTitre());
            ps.setInt(4, p.getNbr_commentaire());
            ps.setString(5, p.getDate());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean modifier(Publication p) {
        String query = "UPDATE `publication` SET id_personne=? , publication=?,titre=?,nbr_commentaire=?, date=STR_TO_DATE(? ,'%d-%m-%Y') WHERE id_Publication=?";
        boolean rowUpdated = false;
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
          
            ps.setInt(1, p.getId_personne());
            ps.setString(2, p.getPublication());
            ps.setString(3, p.getTitre());
            ps.setInt(4, p.getNbr_commentaire());
            ps.setString(5, p.getDate());
            ps.setInt(6, p.getId_Publication());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Publication updated successfully");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean supprimer(Publication p) {
        String query = "DELETE FROM publication WHERE id_publication=?";
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setObject(1, p.getId_Publication());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" deleted successfully!");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Publication> getAll() {
        List<Publication> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM publication";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Publication p;
                p = new Publication(rs.getObject(1),rs.getObject(2),rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6));
                System.out.println(p + "-------------------");
                list.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override

    public Publication getById(int id) {
     
        String query = "select * from publication where id_publication=" +id;
        try {
          
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                 Publication p1;
               p1 = new Publication(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                System.out.println(p1 + "-------------------");
           
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return new Publication();
    }

    @Override
    public Publication getOne(Publication p) {

    System.out.println(p.getId_Publication());
     String query = "select * from publication where id_publication=" + p.getId_Publication();
     try {
     Statement st = cnx.createStatement();
     ResultSet rs = st.executeQuery(query);
     if (rs.next()) {
Publication p1 = new Publication(rs.getInt(1),  rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
return p1;
     }

     } catch (SQLException ex) {
     System.out.println(ex.getMessage());
     }

     return new Publication();
    }
}
