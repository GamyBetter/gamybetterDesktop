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
public class ServiceCommande implements IService<Commande> {

    Connection cnx = DataSource.getInstance().getCnx();

    //java.util.Date date=new java.util.Date();
    //java.sql.Date sqlDate=new java.sql.Date(date.getTime());
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
//Object date,Object  nom_personne,Object  prenom_personne,Object addresse_personne, Object  email_personne, Object IDpersonne, Object prix_totale,Object liste_produits
    @Override
    public void ajouter(Commande c) {

        String query = "INSERT INTO `commande` (`date_commande`,`nom_personne`, `prenom_personne` ,`address_personne`,`email_personne`,`IDpersonne`,`prix_totale`,`liste_produits`) VALUES(?,?,?,?,?,?,?,?)";
        String sql = "Select nom_personne from `personne` Where id_personne=" + c.getIDpersonne();
        try {
            //String[] Produits = null ;
            PreparedStatement ps = cnx.prepareStatement(query);

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            
            ps.setObject(1, formatter.format(date));
            ps.setObject(2, rs.getObject(1));
            ps.setObject(3, rs.getObject(1));
            ps.setObject(4, c.getAddresse_personne());
            ps.setObject(5, c.getEmail_personne());
            ps.setObject(6, c.getIDpersonne());
            ps.setObject(7, c.getPrix_totale());
            ps.setObject(8, c.getListe_produits());

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

    }

    public void ajouter2(Commande t) {
    }

    @Override
    public boolean modifier(Commande c) {
        String sql = "UPDATE `commande` SET date_commande=?,nom_personne=?, prenom_personne=? ,address_personne=?,email_personne=?,IDpersonne=?,prix_totale=?,liste_produits WHERE id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setObject(1, formatter.format(date));
            ps.setObject(4, c.getAddresse_personne());
            ps.setObject(5, c.getEmail_personne());
            ps.setObject(6, c.getIDpersonne());
            ps.setObject(7, c.getPrix_totale());
            ps.setObject(8, c.getListe_produits());
            ps.setObject(9, c.getId_commande());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing commande was updated successfully");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    @Override
    public boolean supprimer(Commande c) {
        String query = "DELETE FROM `commande` WHERE id_commande=?";
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setObject(1, c.getId_commande());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                rowDeleted = true;
                System.out.println("Une commande was deleted successfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowDeleted;

    }

    @Override
    public List<Commande> getAll() {
        List<Commande> list = new ArrayList<>();
        String query = "Select * from `commande`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Commande com = new Commande(rs.getObject(1), rs.getTimestamp(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8),rs.getObject(9));
                list.add(com);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Commande getOne(Commande c) {

        String query = "select * from `commande` where id_commande=" + c.getId_commande();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Commande com = new Commande(rs.getObject(1), rs.getTimestamp(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8), rs.getObject(9));
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
                Commande com = new Commande(rs.getObject(1), rs.getTimestamp(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8),rs.getObject(9));
                return com;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Commande();
    }
}
