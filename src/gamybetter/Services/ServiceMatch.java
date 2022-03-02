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
//Object score, Object lien_streaming, Object status, Object gold, Object duree, Object Date,Object heros,Object id_equipe
    @Override
    public void ajouter(Match t) {
        String query = "INSERT INTO `match` (`score`,`lien_streaming`,`status`,`gold`,`duree`,`date`,`heros`,`id_equipe`) VALUES(?,?,?,?,?,STR_TO_DATE(? ,'%d-%m-%Y'),?,?)";
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
   
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean modifier(Match t) {
        String query = "UPDATE `match` SET id_match=? ,score=? ,lien_streaming=?, status=?, gold=?, duree=?, date=STR_TO_DATE(? ,'%d-%m-%Y'), heros=?, id_equipe=? WHERE id_match=?";
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
        
            ps.setInt(10, t.getId_match());
            
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
//Object score, Object lien_streaming, Object status, Object gold, Object duree, Object Date,Object heros,Object id_equipe
    @Override
    public List<Match> getAll() {
        List<Match> list = new ArrayList<>();
        String query = "Select * from `match`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Match m = new Match(rs.getObject(1),rs.getObject(2),rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6),rs.getObject(7),rs.getObject(8),rs.getObject(9));
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
        Match m1=new Match();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                m1 = new Match(rs.getObject(1),rs.getObject(2),rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6),rs.getObject(7),rs.getObject(8),rs.getObject(9));

                System.out.println(m1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return m1;
    }

    @Override
    public Match getOne(Match t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
