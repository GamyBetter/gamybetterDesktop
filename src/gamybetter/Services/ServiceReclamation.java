/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import gamybetter.Models.Reclamation;
import gamybetter.Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ServiceReclamation implements IService<Reclamation> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Reclamation r) {
        try {
            String req = "INSERT INTO `reclamation` (`titre`,`reclamation`,`email_sender`,`id_personne`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
         
            ps.setString(1, r.getTitre());
            ps.setString(2, r.getReclamation());
            ps.setString(3, r.getEmail_sender());
            ps.setInt(4,r.getId_personne());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public boolean modifier(Reclamation r) {
        String sql = "UPDATE `reclamation` SET  titre=?,reclamation=?,email_sender=?,id_personne=? WHERE id_reclamation=?";
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
         
            statement.setString(1, r.getTitre());
            statement.setString(2, r.getReclamation());
            statement.setString(3, r.getEmail_sender());
            statement.setInt(4,r.getId_personne());
            statement.setInt(5, r.getId_reclamation());
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
    public boolean supprimer(Reclamation r) {
        String sql = "DELETE FROM reclamation WHERE id_reclamation=?";
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, r.getId_reclamation());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowDeleted;
    }

    @Override
    public Reclamation getById(int id) {
        String query = "select * from reclamation where id_reclamation=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Reclamation r1 = new Reclamation(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5));

                return r1;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Reclamation();

    }

    @Override
    public List<Reclamation> getAll() {
        List<Reclamation> list = new ArrayList<>();
        try {
            String req = "Select * from `reclamation`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reclamation r = new Reclamation(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4),rs.getObject(5));
                System.out.println(r + "-------------------");
                list.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Reclamation getOne(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
