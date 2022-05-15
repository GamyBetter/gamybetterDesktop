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
      String query = "INSERT INTO `actualite` (`id_match`, `id_personne`,`image` ,`video`,`jeu`,`titre`,`description`,`date`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setInt(1,t.getId_match());
            ps.setInt(2,t.getId_personne());
            ps.setString(3,t.getImage());
            ps.setString(4,t.getVideo());
           ps.setString(5,t.getJeu());
            ps.setString(6,t.getTitre());
            ps.setString(7,t.getDescription());
            ps.setObject(8,t.getDate());
            
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public boolean modifier(Actualite t) {
        String query = "UPDATE `actualite` SET id_match=? ,id_personne=? ,image=? ,video=?, jeu=? ,titre=?, description=? ,date=STR_TO_DATE(? ,'%d-%m-%Y')  WHERE id_actualite=? ";
        boolean rowUpdated = false;
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setInt(1,t.getId_match());
            ps.setInt(2,t.getId_personne());
            ps.setString(3,t.getImage());
            ps.setString(4,t.getVideo());
            ps.setString(5,t.getJeu());
            ps.setString(6,t.getTitre());
            ps.setString(7,t.getDescription());
            ps.setObject(8,t.getDate());
            ps.setInt(9,t.getId_actualite());
          
            
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
       String query ="DELETE FROM `actualite` WHERE id_actualite=?";
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
                Actualite m = new Actualite(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDate(9));
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

        String query = "Select * from `actualite` where id_actualite=" +id_actualite;
        Actualite m1=new Actualite();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                m1 = new Actualite(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));

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
        String query = "DELETE FROM `actualite` WHERE id_actualite=?";
        try {
           PreparedStatement statement = cnx.prepareStatement(query);
           statement.setInt(1,id_actulite);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    }
        
    
    

   
   
    
