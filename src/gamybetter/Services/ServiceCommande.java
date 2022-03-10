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
        
        String query = "INSERT INTO `commande` (`id`,`date_commande`,`nom_personne`, `prenom_personne` ,`address_personne`,`email_personne`,`IDpersonne`,`prix_totale`) VALUES(?,?,?,?,?,?,?,?)";
        
        String sql ="Select nom,prenom,adresse,email from `personne` Where id='"+c.getId_personne()+"'";
        try {
            //String[] Produits = null ;
            PreparedStatement ps = cnx.prepareStatement(query);
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            ps.setObject(1, c.getId_commande());
            ps.setObject(2, formatter.format(date));
            ps.setObject(3, rs.getObject(1));
            ps.setObject(4, rs.getObject(2));
            ps.setObject(5, rs.getObject(3));
            ps.setObject(6, rs.getObject(4));
            ps.setObject(7, c.getId_personne());
            ps.setObject(8, c.getPrix_totale());
            
            
            //ps.setObject(7, c.getId_produit());
            /* for (int i = 0; i < c.getList_Produit().size(); i++) {
                System.out.println(c.get(i));
                
            }
            float prix_totale=0f;
            for (int i = 0; i < c.getId_produit().length; i++) {
                String query1 = "Select image,nom_produit,prix from `produit` Where id=" + i;
                ResultSet rs = ps.executeQuery(query1);
                int[] a = c.getQuantite();

           // ps.setObject(8,cnx.createArrayOf("string", Produits) );
            ps.setObject(7,     c.getQuantite());
            ps.setObject(8, c.getPrix_totale());
            
            }*/
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public void ajouter2(Commande t) {
    }

    @Override
    public void update(Commande c) {
        String sql = "UPDATE `commande` SET date_commande=?,nom_personne=?, prenom_personne=? ,address_personne=?,email_personne=?,prix_totale=? WHERE id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setObject(1, formatter.format(date)); 
            ps.setObject(2, c.getNom_personne());
            ps.setObject(3, c.getPrenom_personne());
            ps.setObject(4, c.getAddresse_personne());
            ps.setObject(5, c.getEmail_personne());
            ps.setObject(6, c.getPrix_totale());
            ps.setObject(7, c.getId_commande());
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing commande was updated successfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void delete(Commande c) {
        String sql = "DELETE FROM commande WHERE id=?";
        
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, c.getId_commande());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A commande was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Commande> getAll() {
        List<Commande> list = new ArrayList<>();
        String query = "Select * from `commande`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Commande com = new Commande(rs.getObject(1), rs.getTimestamp(2),rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8));
                 list.add(com);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Commande getOne(Commande c) {

        String query = "select * from `commande` where id='" + c.getId_commande()+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Commande com = new Commande(rs.getObject(1), rs.getTimestamp(2),rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8));
                return com;
            } 
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Commande();
    }

    @Override
    public Commande getById(String id) {

        String query = "select * from `commande` where id='" + id+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Commande com = new Commande(rs.getObject(1), rs.getTimestamp(2),rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8));
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
    public void SetCommandPrice(Commande c,double prix) {
        String query = "UPDATE `commande` SET `date_commande`=?,`nom_personne`=?, `prenom_personne`=? ,`address_personne`=?,`email_personne`=?,`IDpersonne`=?,`prix_totale`=? WHERE id='"+c.getId_commande()+"'";
        
        String sql ="Select nom,prenom,adresse,email from `personne` Where id='"+c.getId_personne()+"'";
        try {
            //String[] Produits = null ;
            PreparedStatement ps = cnx.prepareStatement(query);
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            
            ps.setObject(1, formatter.format(date));
            ps.setObject(2, rs.getObject(1));
            ps.setObject(3, rs.getObject(2));
            ps.setObject(4, rs.getObject(3));
            ps.setObject(5, rs.getObject(4));
            ps.setObject(6, c.getId_personne());
            ps.setObject(7, prix);
            
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing commande was updated successfully");
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

 
}

