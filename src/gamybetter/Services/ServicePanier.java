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
import gamybetter.Models.Panier;
import gamybetter.Utils.DataSource;

/**
 *
 * @author Sayee
 */
public class ServicePanier implements IService<Panier>{
     Connection cnx = DataSource.getInstance().getCnx();  
    
    @Override
    public void ajouter(Panier p) {
        
        String query = "INSERT INTO `panier` (`id_commande`,`itemCode`,`quanite_order`, `prix_unitaire` ) VALUES(?,?,?,?)";
        String sql ="Select prix_unitair from `produit` Where itemCode="+p.getId_produit();
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
        }
        
    }

    public void ajouter2(Panier t) {
    }

    @Override
    public boolean modifier(Panier p) {
        String sql = "UPDATE `panier` SET `quanite_order`=? WHERE id_commande=? AND itemCode=?";
        boolean rowsUpdated = false;
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

           
            ps.setObject(1, p.getQuantite_order());

            ps.setObject(2, p.getId_commande());
            ps.setObject(3, p.getId_produit());
            
            rowsUpdated = ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowsUpdated;

    }

    @Override
    public boolean supprimer(Panier p) {
        String sql = "DELETE FROM panier WHERE id_commande=? AND itemCode=?";
        
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            
            statement.setObject(1, p.getId_commande());
            statement.setObject(2, p.getId_produit());
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A product  was deleted successfully from cart !");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
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
               
                String sql = "Select image,nom_produit from `produit` where itemCode= "+rs.getObject(2);
                ResultSet rsp = stp.executeQuery(sql);
                 rsp.next();
                double prix_unitaire = rs.getDouble(4);

                double prix_totale_produit=prix_unitaire*rs.getInt(2);
                Panier pan = new Panier(rs.getObject(1), rs.getObject(2),rs.getObject(3), rs.getObject(4),prix_totale_produit,rsp.getObject(1),rsp.getObject(2));
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
}
