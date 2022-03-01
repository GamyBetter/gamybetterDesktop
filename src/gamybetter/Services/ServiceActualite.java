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
import gamybetter.Models.Actualite;
import gamybetter.Utils.DataSource;

/**
 *
 * @author MAG028
 */
public class ServiceActualite implements IService <Actualite>  {
    
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void add(Actualite t) {
      String query = "INSERT INTO `actualite` (`image`, `video`,`id_match`) VALUES('" + t.getImage() + "','" + t.getVideo() + "','" + t.getId_match() + "')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean update(Actualite t) {
        String query = "UPDATE `actualite` SET image=? ,video=?,id_match=?  WHERE image=?";
        boolean rowUpdated = false;
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
             ps.setString(1,t.getImage());
            ps.setString(2,t.getVideo());
            ps.setInt(3,t.getId_match());
            ps.setString(4, t.getImage());
          
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return rowUpdated;
    }

    @Override
    public boolean delete(Actualite t) {
       String query ="DELETE FROM `actualite` WHERE image=?";
       boolean rowDeleted= false ;
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setObject(1, t.getImage());
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
    public List<Actualite> getAll() {
       List<Actualite> list = new ArrayList<>();
        String query = "Select * from `actualite`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Actualite a = new Actualite(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(a);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

   /* @Override
    public Actualite getOne(Actualite t) {
     System.out.println(t.getImage());
     String query = "select * from `actualite where actualite=" + t.getActualite);
     try {
     Statement st = cnx.createStatement();
     ResultSet rs = st.executeQuery(query);
     if (rs.next()) {
     Actualite a1 = new Actualite(rs.getString(1),rs.getString(2);
     return p;
     }

     } catch (SQLException ex) {
     System.out.println(ex.getMessage());
     }

     return new Actualite();
     }
    }*/

    @Override
    public Actualite getById(int id_match) {

        String query = "Select * from `actualite` where id_match=" +id_match;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Actualite m1 = new Actualite(rs.getString(1), rs.getString(2), rs.getInt(3));

                System.out.println(m1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Actualite();
    }
    }
        
    
    

   
   
    
