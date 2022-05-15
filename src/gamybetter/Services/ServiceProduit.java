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
import gamybetter.Models.Produit;
import gamybetter.Utils.DataSource;

/**
 *
 * @author Sayee
 */
public class ServiceProduit implements IProduit<Produit> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public boolean add(Produit t) {
        String query = "INSERT INTO `produit` (`itemCode`, `nom_produit`, `description`,`categorie`,`quantite_stock`,`prix_unitair`,`image`,`discount`) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
             ps.setObject(1, t.getId());
            ps.setObject(2, t.getNom_produit());
            ps.setObject(3, t.getDescription());
            ps.setObject(4, t.getCategorie());
            ps.setObject(5, t.getQuantiteStock());
            ps.setObject(6, t.getPrix());
            ps.setObject(7, t.getImage());
            ps.setObject(8, t.getDiscount());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public void ajouter2(Produit t) {
    }

    @Override
    public boolean update(Produit t) {
        String sql = "UPDATE `produit` SET nom_produit=?, prix_unitair=?, categorie=? , description=? ,quantite_stock=?,image=?,discount=? WHERE itemCode =?";
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, t.getNom_produit());
            statement.setObject(2, t.getPrix());
            statement.setObject(3,t.getCategorie());

            statement.setObject(4, t.getDescription());
            statement.setObject(5, t.getQuantiteStock());
            statement.setObject(6, t.getImage());
            statement.setObject(7, t.getDiscount());
            statement.setObject(8, t.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Produit t) {
        String sql = "DELETE FROM produit WHERE itemCode=?";

        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, t.getId());

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
    public List<Produit> getAll() {
        List<Produit> list = new ArrayList<>();
        String query = "Select * from `produit`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Produit p = new Produit(rs.getObject(1),rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7),rs.getObject(8));
                list.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Produit getOne(Produit t) {

        String query = "select * from `produit` where itemCode='" + t.getId()+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Produit p = new Produit(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5));
                return p;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Produit();
    }

    @Override
    public Produit getById(String id) {

        String query = "select nom_produit,description ,categorie ,quantite_stock ,prix_unitair from `produit` where itemCode='" + id+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Produit p = new Produit(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5));
                return p;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Produit();
    }
}
