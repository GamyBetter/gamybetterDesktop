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
public class ServiceProduit implements IService<Produit> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Produit t) {
        String query = "INSERT INTO `produit` (`nom_produit`, `prix_unitair`, `categorie`,`image`,`description`,`quantite_stock`) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setObject(1, t.getNom_produit());
            ps.setObject(2, t.getPrix());
            ps.setObject(3, t.getCategorie());
            ps.setObject(4, t.getImage());
            ps.setObject(5, t.getDescription());
            ps.setObject(6, t.getQuantiteStock());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void ajouter2(Produit t) {
    }

    @Override
    public boolean modifier(Produit t) {
        String sql = "UPDATE `produit` SET nom_produit=?, prix_unitair=?, categorie=? , image=?, description=? ,quantite_stock=? WHERE itemCode =?";
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, t.getNom_produit());
            statement.setObject(2, t.getPrix());
            statement.setObject(3,t.getCategorie());
            statement.setObject(4, t.getImage());
            statement.setObject(5, t.getDescription());
            statement.setObject(6, t.getQuantiteStock());
            statement.setObject(7, t.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    @Override
    public boolean supprimer(Produit t) {
        String sql = "DELETE FROM produit WHERE id=?";

        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, t.getId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
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
                Produit p = new Produit(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7));
                list.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Produit getOne(Produit t) {

        String query = "select * from `produit` where id=" + t.getId();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Produit p = new Produit(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7));
                return p;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Produit();
    }

    @Override
    public Produit getById(int id) {

        String query = "select * from `produit` where id=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Produit p = new Produit(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7));
                return p;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Produit();
    }
}
