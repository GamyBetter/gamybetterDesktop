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
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MAG028
 */
public class ServiceMatch implements IService<Match> {

    Connection cnx = DataSource.getInstance().getCnx();
//Object score, Object lien_streaming, Object status, Object gold, Object duree, Object Date,Object heros,Object id_equipe
   @Override
    public void ajouter(Match t) {
        String query = "INSERT INTO `game` (`id_equipe1`,`id_equipe2`,`image1`,`image2`,`score`,`lien_streaming`,`status`,`gold`,`duree`,`date`,`temps`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            
            
             ps.setInt(1, t.getId_equipe1());
             ps.setInt(2, t.getId_equipe2());
            ps.setString(3, t.getImage1());
            ps.setString(4, t.getImage2());
            ps.setString(5, t.getScore());
            ps.setString(6, t.getLien_streaming());
            ps.setString(7, t.getStatus());
            ps.setString(8, t.getGold());
            ps.setString(9, t.getDuree());
            ps.setObject(10, t.getDate());
            ps.setString(11, t.getTemps());
           
   
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean modifier(Match t) {
        String query = "UPDATE `game` SET id_equipe1=?, id_equipe2=? , image1=? , image2=? ,score=? ,lien_streaming=?, status=?, gold=?, duree=?, date=STR_TO_DATE(? ,'%d-%m-%Y'),temps=? WHERE id_match=?";
        boolean rowUpdated = false;
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
             ps.setInt(1, t.getId_equipe1());
             ps.setInt(2, t.getId_equipe2());
            ps.setString(3, t.getImage1());
            ps.setString(4, t.getImage2());
            ps.setString(5, t.getScore());
            ps.setString(6, t.getLien_streaming());
            ps.setString(7, t.getStatus());
            ps.setString(8, t.getGold());
            ps.setString(9, t.getDuree());
            ps.setObject(10, t.getDate());
            ps.setString(11, t.getTemps());
        
            ps.setInt(12, t.getId_match());
            
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
       String query ="DELETE FROM `game` WHERE id_match=?";
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
//Object score, Object lien_streaming, Object status, Object gold, Object duree, Object Date,Object heros,Object id_equipe, Object id_equipe1
    @Override
    public List<Match> getAll() {
        List<Match> list = new ArrayList<>();
        String query = "Select * from `game`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Match m = new Match(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDate(11),rs.getString(12));
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

        String query = "Select * from `game` where id_match=" +id_match;
        Match m1=new Match();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
               Match m = new Match(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDate(11),rs.getString(12));

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
    
    public void deleteById(int id_match) {
        String query = "DELETE FROM `game` WHERE id_match=?";
        try {
           PreparedStatement statement = cnx.prepareStatement(query);
           statement.setObject(1,id_match);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    /*
    public ObservableList<Match> getByStartDate(LocalDate startDate) {
            
        ObservableList <Match> x= FXCollections.observableArrayList();
        List <Match> ol= ServiceMatch.getAll();
       ol.stream().filter(e->e.getDate().isEqual(startDate)).forEach(e->x.add(e));
      return x;
    }
    */
}


