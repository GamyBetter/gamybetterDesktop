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
    //Object image, Object video,Object id_match,Object id_personne
     @Override
    public void ajouter(Actualite t) {
      String query = "INSERT INTO `actualite` (`image`, `video`,`id_match`,`id_personne`) VALUES('" + t.getImage() + "','" + t.getVideo() + "','" + t.getId_match() + "','" + t.getId_personne() + "')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public boolean modifier(Actualite t) {
        String query = "UPDATE `actualite` SET image=? ,video=?, id_match=? ,id_personne=?  WHERE id_actualité=? ";
        boolean rowUpdated = false;
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
             ps.setString(1,t.getImage());
            ps.setString(2,t.getVideo());
            ps.setInt(3,t.getId_match());
            ps.setInt(4,t.getId_personne());
            ps.setInt(5, t.getId_actualite());
          
            
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
   public boolean supprimer(Actualite t) {
       String query ="DELETE FROM `actualite` WHERE id_actualité=?";
       boolean rowDeleted= false ;
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setObject(1, t.getId_actualite());
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
                Actualite m = new Actualite(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                System.out.println(m);
                list.add(m);

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
    public Actualite getById(int id_actualite) {

        String query = "Select * from `actualite` where id_actualité=" +id_actualite;
        Actualite m1=new Actualite();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                m1 = new Actualite(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));

                System.out.println(m1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return m1;
    }

    @Override
    public Actualite getOne(Actualite t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
     public void deleteById(int id_actulite) {
        String query = "DELETE FROM `actualite` WHERE id_actualité=?";
        try {
           PreparedStatement statement = cnx.prepareStatement(query);
           statement.setInt(1,id_actulite);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    }
        
    
    

   
   
    
