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
import javafx.collections.ObservableList;
import gamybetter.Models.Panier;
import gamybetter.Utils.DataSource;

/**
 *
 * @author Sayee
 */
public class ServicePanier implements IPanier<Panier>{
     Connection cnx = DataSource.getInstance().getCnx();  
    
    @Override
    public boolean add(Panier p) {
        
        String query = "INSERT INTO `panier` (`id_commande`,`itemCode`,`quanite_order`, `prix_unitaire` ) VALUES(?,?,?,?)";
        String sql ="Select prix_unitair from `produit` Where itemCode='"+p.getId_produit()+"'";
        try {
            //String[] Produits = null ;
            PreparedStatement ps = cnx.prepareStatement(query);
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            ps.setObject(1, p.getId_commande());
            ps.setObject(2, p.getId_produit());
            ps.setObject(3, p.getQuantite_order());   
            rs.next();
            ps.setObject(4, rs.getObject(1));

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public void ajouter2(Panier t) {
    }

    @Override
    public void update(Panier p) {
        String sql = "UPDATE `panier` SET `quanite_order`=? WHERE id_commande=? AND itemCode=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

           
            ps.setObject(1, p.getQuantite_order());

            ps.setObject(2, p.getId_commande());
            ps.setObject(3, p.getId_produit());
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing product from cart was updated successfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void delete(Panier p) {
        String sql = "DELETE FROM panier WHERE id_commande=? AND itemCode=?";
        
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            
            statement.setObject(1, p.getId_commande());
            statement.setObject(2, p.getId_produit());
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A product  was deleted successfully from cart !");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    
    @Override
    public List<Panier> getAll() {
        List<Panier> list = new ArrayList<>();
        String query = "Select * from `panier`";
        
        try {
            Statement stp = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
           
            
             
            while (rs.next()) {
               
                String sql = "Select image,nom_produit from `produit` where itemCode= '"+rs.getObject(2)+"'";
                ResultSet rsp = stp.executeQuery(sql);
                 rsp.next();
                double prix_unitaire = rs.getDouble(4);

                double prix_totale_produit=prix_unitaire*rs.getInt(3);
                Panier pan = new Panier(rs.getObject(1), rs.getObject(2),rs.getObject(3), rs.getObject(4),prix_totale_produit,rsp.getObject(1),rsp.getObject(2));
                 list.add(pan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    /**
     *
     *
     * @param id_commande
     * @return
     */
    @Override
    public List<Panier> getItems(String id_commande) {
        List<Panier> list = new ArrayList<>();
        
        String query = "Select itemCode,quanite_order,prix_unitaire from `panier` Where id_commande= '"+id_commande+"'";
        
        try {
            Statement stp = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
           
            
             
            while (rs.next()) {
                
                String sql = "Select image,nom_produit,discount from `produit` where itemCode= '"+rs.getObject(1)+"'";
                ResultSet rsp = stp.executeQuery(sql);
                 rsp.next();
                double prix_unitaire = rs.getDouble(3);

                double prix_totale_produit=prix_unitaire*rs.getInt(2);
                prix_totale_produit=(prix_totale_produit-((prix_totale_produit * rsp.getInt(3))/100));
                Panier pan = new Panier(id_commande,rs.getObject(1),rs.getObject(2), rs.getObject(3),rsp.getObject(3),rsp.getObject(1),rsp.getObject(2),prix_totale_produit);
                 list.add(pan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    @Override
    public Panier getOne(Panier p) {

        String query = "select * from `panier` where id_commande=" + p.getId_commande();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Panier pan = new Panier(rs.getObject(1), rs.getObject(2),rs.getObject(3), rs.getObject(4));
                return pan;
            } 
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Panier();
    }

    @Override
    public Panier getById(int id) {

        String query = "select * from `panier` where id_commande=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Panier p = new Panier(rs.getObject(1), rs.getObject(2),rs.getObject(3), rs.getObject(4));
                return p;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Panier();
    }

     @Override
    public double getItemPrix(String id){
        String query = "select prix_unitaire from `produit` where itemCode='" + id+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
               
                return rs.getDouble(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0f;
    }
}
