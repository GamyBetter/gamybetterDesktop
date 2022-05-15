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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gamybetter.Models.Commande;
import gamybetter.Utils.CurrentUser;
import gamybetter.Utils.DataSource;

/**
 *
 * @author Sayee
 */
public class ServiceCommande implements ICommande<Commande> {

    Connection cnx = DataSource.getInstance().getCnx();
    
    //java.util.Date date=new java.util.Date();
    //java.sql.Date sqlDate=new java.sql.Date(date.getTime());
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    Date date = new Date();  
    @Override
    public boolean add(Commande c) {
        
        String query = "INSERT INTO `commande` (`id_commande`,`date_commande`,`nom_personne` ,`address_personne`,`email_personne`,`IDpersonne`,`prix_totale`) VALUES(?,?,?,?,?,?,?)";
        
        String sql ="Select nom_personne,email from `personne` Where id_personne="+c.getId_personne();
        try {
            //String[] Produits = null ;
            PreparedStatement ps = cnx.prepareStatement(query);
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            ps.setObject(1, c.getId_commande());
            ps.setObject(2, formatter.format(date));
            ps.setObject(3, rs.getObject(1));
            ps.setObject(4,"Adresse@test.com" );
            ps.setObject(5, rs.getObject(2));
            ps.setObject(6, c.getId_personne());
            ps.setObject(7, c.getPrix_totale());
 
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public void ajouter2(Commande t) {
    }

    @Override
    public boolean update(Commande c) {
        String sql = "UPDATE `commande` SET date_commande=?,nom_personne=?,address_personne=?,email_personne=?,prix_totale=? discount=? WHERE id_commande=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setObject(1, formatter.format(date)); 
            ps.setObject(2, c.getNom_personne());
            ps.setObject(3, c.getAddresse_personne());
            ps.setObject(4, c.getEmail_personne());
            ps.setObject(5, c.getPrix_totale());
             ps.setObject(6, c.getDiscount());
            ps.setObject(7, c.getId_commande());
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Commande c) {
        String sql = "DELETE FROM commande WHERE id_commande=?";
        
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, c.getId_commande());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Commande> getAll() {
        List<Commande> list = new ArrayList<>();
        String query = "Select * from `commande`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Commande com = new Commande(rs.getObject(1), rs.getTimestamp(2),rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7),rs.getObject(8));
                 list.add(com);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Commande getOne(Commande c) {

        String query = "select * from `commande` where id_commande='" + c.getId_commande()+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Commande com = new Commande(rs.getObject(1), rs.getTimestamp(2),rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7),rs.getObject(8));
                return com;
            } 
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Commande();
    }

    @Override
    public Commande getById(int id) {

        String query = "select * from `commande` where id_commande=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Commande com = new Commande(rs.getObject(1), rs.getTimestamp(2),rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7),rs.getObject(8));
                return com;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Commande();
    }

    /**
     *
     * @param c
     * @param prix
     */
    @Override
    public boolean SetCommandPrice(Commande c,double prix) {
        String query = "UPDATE `commande` SET `date_commande`=?,`nom_personne`=?, `address_personne`=?,`email_personne`=?,`prix_totale`=? WHERE id_commande='"+c.getId_commande()+"'";
        
        String sql ="Select nom_personne,email from `personne` Where id_personne="+c.getId_personne();
        try {
            //String[] Produits = null ;
            PreparedStatement ps = cnx.prepareStatement(query);
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            
            ps.setObject(1, formatter.format(date));
            ps.setObject(2, rs.getObject(1));
            ps.setObject(4, rs.getObject(2));
            ps.setObject(3, "Adress@test.chtetbadel");

            ps.setObject(5, prix);
            
            
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public String getAdmin(int id){
        String query = "select email from `personne` where id_personne=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
                return rs.getString(1);
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return "Admin-access";
    }
}

