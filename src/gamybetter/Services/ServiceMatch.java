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

import gamybetter.Models.Match;
import gamybetter.Utils.DataSource;

/**
 *
 * @author MAG028
 */
public class ServiceMatch implements IService<Match> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Match t) {
        String query = "INSERT INTO `match` (`score`,`lien_streaming`,`status`,`gold`,`duree`,`date`,`heros`,`id_equipe`,`id_personne`) VALUES(?,?,?,?,?,STR_TO_DATE(? ,'%d-%m-%Y'),?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            
            ps.setInt(1, t.getScore());
            ps.setString(2, t.getLien_streaming());
            ps.setString(3, t.getStatus());
            ps.setString(4, t.getGold());
            ps.setString(5, t.getDuree());
            ps.setString(6, t.getDate());
            ps.setString(7, t.getHeros());
            ps.setInt(8, t.getId_equipe());
            ps.setInt(9, t.getId_personne());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean modifier(Match t) {
        String query = "UPDATE `match` SET id_match=? ,score=? ,lien_streaming=?, status=?, gold=?, duree=?, date=STR_TO_DATE(? ,'%d-%m-%Y'), heros=?, id_equipe=? , id_personne=? WHERE id_match=?";
        boolean rowUpdated = false;
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
             ps.setInt(1,t.getId_match());
            ps.setInt(2,t.getScore());
            ps.setString(3, t.getLien_streaming());
            ps.setString(4, t.getStatus());
            ps.setString(5, t.getGold());
            ps.setString(6, t.getDuree());
            ps.setString(7, t.getDate());
            ps.setString(8, t.getHeros());
            ps.setInt(9, t.getId_equipe());
            ps.setInt(10,t.getId_personne());
            ps.setInt(11, t.getId_match());
            
            int rowsUpdated = ps.executeUpdate();
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
   public boolean supprimer(Match t) {
       String query ="DELETE FROM `match` WHERE id_match=?";
       boolean rowDeleted= false ;
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setObject(1, t.getId_match());
             int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An existing user was deleted successfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowDeleted;
       
       
    }

    @Override
    public List<Match> getAll() {
        List<Match> list = new ArrayList<>();
        String query = "Select * from `match`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Match m = new Match(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10));
                System.out.println(m);
                list.add(m);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    /*  @Override
     public Match getOne(Match t) {
     System.out.println(t.getId());
     String query = "select * from `match` where id=" + t.getId();
     try {
     Statement st = cnx.createStatement();
     ResultSet rs = st.executeQuery(query);
     if (rs.next()) {
     Match p = new Match(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
     return p;
     }

     } catch (SQLException ex) {
     System.out.println(ex.getMessage());
     }

     return new Match();
     } */
    @Override
    public Match getById(int id_match) {

        String query = "Select * from `match` where id_match=" +id_match;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Match m1 = new Match(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10));

                System.out.println(m1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Match();
    }

    @Override
    public Match getOne(Match t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
